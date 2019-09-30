package lol.gilliard.part2;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Say;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.util.HashSet;
import java.util.Random;

import static spark.Spark.post;

public class PickARaffleWinner {

    private static String winnerMsg = "Congratulations, you've won!";
    private static String notWinnerMsg = "Sorry, you didn't win";

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

// 1. Remove Duplicates
        HashSet<PhoneNumber> phoneNumbers = new HashSet<>();
        allMessages.forEach(msg -> phoneNumbers.add(msg.getFrom()));

// 2. Pick a Winner
        String winnerNumber = phoneNumbers.stream()
            .skip(new Random().nextInt(phoneNumbers.size()))
            .findFirst()
            .get()
            .toString();

// 4. Host the callback
        post("/call", (req, res) ->
            new VoiceResponse.Builder().say(
                new Say.Builder(req.queryParams("To").equals(winnerNumber) ? winnerMsg : notWinnerMsg)
                    .loop(3)
                    .voice(Say.Voice.POLLY_MATTHEW)
                    .build()
            ).build().toXml());

// 3. Make phone calls
        phoneNumbers.forEach(phoneNumber -> {
                System.out.println("calling " + phoneNumber);
                Call.creator(phoneNumber, contestNumber, URI.create("https://d59bcd5a.ngrok.io/call")).create();
            }
        );
    }
}
