package lol.gilliard.part2;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Play;
import com.twilio.twiml.voice.Say;
import com.twilio.type.PhoneNumber;
import com.twilio.type.Twiml;

import java.util.HashSet;

import static lol.gilliard.part1.RespondToSMS.PHONE_NUMBER;

public class SayPlay {

    public static void main(String[] args) {

        Twilio.init(
            System.getenv("ACCOUNT_SID"),
            System.getenv("AUTH_TOKEN"));

        var myTwilioPhoneNumber = new PhoneNumber(PHONE_NUMBER);

        // fetch all messages
        var messages = Message.reader().setTo(myTwilioPhoneNumber).read();

        // get unique senders' phone numbers
        HashSet<PhoneNumber> phoneNumbers = new HashSet<>();
        messages.forEach(msg -> phoneNumbers.add(msg.getFrom()));

        // call 'em all
        phoneNumbers.forEach(pn ->
            Call.creator(pn, myTwilioPhoneNumber,
                new Twiml(
                    new VoiceResponse.Builder()
                        .say(new Say.Builder("Thanks for calling, have a great day").build())
                        .play(new Play.Builder("https://demo.twilio.com/docs/classic.mp3").build())
                        .build().toXml()
                )).create()
        );
    }

}
