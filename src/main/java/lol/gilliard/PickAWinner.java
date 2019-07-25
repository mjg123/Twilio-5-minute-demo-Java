package lol.gilliard;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.CallCreator;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Say;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static spark.Spark.post;

public class PickAWinner {

    private static String winnerMsg = "Congratulations, you've won the license!";
    private static String notWinnerMsg = "Sorry, you didn't win this time but we give one out every month";

    public static void main(String[] args) {

        Twilio.init(
            System.getenv("ACCOUNT_SID"),
            System.getenv("AUTH_TOKEN"));

        PhoneNumber contestNumber = new PhoneNumber("+44 7723 460138");

        ResourceSet<Message> allMessage = Message.reader().setTo(contestNumber).read();


        // Don't forget to close the other running app before running this!


    }


    static void backupCode() {


//        HashSet<PhoneNumber> phoneNumbers = new HashSet<>();
//        allMessages.forEach(msg -> phoneNumbers.add(msg.getFrom()));


//        String winnerNumber = phoneNumbers.stream()
//            .skip(new Random().nextInt(phoneNumbers.size()))
//            .findFirst()
//            .get()
//            .toString();


//        post("/call", (req, res) ->
//            new VoiceResponse.Builder().say(
//                new Say.Builder(req.queryParams("To").equals(winnerNumber) ? notWinnerMsg : notWinnerMsg)
//                    .loop(3)
//                    .voice(Say.Voice.POLLY_MATTHEW)
//                    .build()
//            ).build().toXml());


//        phoneNumbers.forEach(phoneNumber -> {
//                System.out.println("calling " + phoneNumber);
//                Call.creator(phoneNumber, contestNumber, URI.create("https://d59bcd5a.ngrok.io/call")).create();
//            }
//        );
    }
}
