package com.itbulls.rahman;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoLog {

    private static final Logger logger =
            LogManager.getLogger(DemoLog.class);

    public static void main(String[] args) {

        for (int i = 1; i <= 200; i++) {

            logger.info(
                "Message {} - Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                i
            );

        }

        System.out.println("Done!");
    }
}