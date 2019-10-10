package lol.gilliard.part2;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import static lol.gilliard.part1.RespondToSMS.PHONE_NUMBER;

public class SayPlay {

    public static void main(String[] args) {

        Twilio.init(
            System.getenv("ACCOUNT_SID"),
            System.getenv("AUTH_TOKEN"));

        PhoneNumber twilioNumber = new PhoneNumber(PHONE_NUMBER);

        ResourceSet<Message> allMessages = Message.reader().setTo(twilioNumber).read();

    }

}


// live template: callcreator