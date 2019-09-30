package lol.gilliard.part1;

import static spark.Spark.get;

public class RespondToSMS {

    // Contest Phone number is:

    private static String message = "Thanks for entering the raffle";

    public static void main(String[] args) {
        get("/", (req, res) -> {
            System.out.println(req.queryParamOrDefault("From", "none"));
            res.header("Content-Type", "application/xml");
            return "<Response><Message>" + message + "</Message></Response>";
        });
    }
}
