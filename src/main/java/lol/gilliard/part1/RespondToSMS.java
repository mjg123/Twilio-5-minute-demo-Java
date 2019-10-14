package lol.gilliard.part1;

import lol.gilliard.SparkLogger;

import static spark.Spark.post;

public class RespondToSMS {

    public static final String PHONE_NUMBER = "";

    private static String message = "Hello from Twilio";

    public static void main(String[] args) {
        SparkLogger.init();

        post("/", (req, res) ->
            message
        );

    }
}


// live templates: message.responsemessage, voicepost, classicmp3
