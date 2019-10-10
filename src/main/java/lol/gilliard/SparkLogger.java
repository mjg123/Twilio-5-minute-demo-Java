package lol.gilliard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.after;

public class SparkLogger {

    public static Logger SPARK_LOGGER = LoggerFactory.getLogger(SparkLogger.class);

    public static void init() {
        after((req, res) -> {
            SPARK_LOGGER.info("Req: {} {} {}",
                req.requestMethod(),
                req.pathInfo(),
                (req.queryParams("From") == null) ? ""
                    : "From: " + req.queryParams("From") +
                    ", To:" + req.queryParams("To")
            );
        });
    }
}
