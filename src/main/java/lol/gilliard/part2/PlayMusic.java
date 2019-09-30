package lol.gilliard.part2;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Pause;
import com.twilio.twiml.voice.Play;
import com.twilio.twiml.voice.Say;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.util.HashSet;

import static spark.Spark.post;

public class PlayMusic {

    public static void main(String[] args) {

        Twilio.init(
            System.getenv("ACCOUNT_SID"),
            System.getenv("AUTH_TOKEN"));

        PhoneNumber contestNumber = new PhoneNumber("");

        ResourceSet<Message> allMessages = Message.reader().setTo(contestNumber).read();

        // Don't forget to close the other running app before running this!

    }


    static void backupCode() {
        PhoneNumber contestNumber = new PhoneNumber("");
        ResourceSet<Message> allMessages = Message.reader().setTo(contestNumber).read();

// 1. Remove duplicate phone numbers
        HashSet<PhoneNumber> phoneNumbers = new HashSet<>();
        allMessages.forEach(msg -> phoneNumbers.add(msg.getFrom()));

// 3. Host the callback
        post("/call", (req, res) ->
            new VoiceResponse.Builder()
                .say(
                    new Say.Builder("Hello From Twilio")
                        .voice(Say.Voice.POLLY_MATTHEW)
                        .build())
                .pause(
                    new Pause.Builder()
                        .length(2)
                        .build())
                .play(
                    new Play.Builder()
                        .url("https://demo.twilio.com/docs/classic.mp3")
                        .build()
                )
                .build().toXml());

// 2. Call everyone
        phoneNumbers.forEach(phoneNumber -> {
                System.out.println("calling " + phoneNumber);
                Call.creator(phoneNumber, contestNumber, URI.create("https://XXXXXXXXXX.ngrok.io/call")).create();
            }
        );
    }
}
