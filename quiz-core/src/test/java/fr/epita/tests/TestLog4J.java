package fr.epita.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class TestLog4J {

    private static final Logger LOGGER = LogManager.getLogger(TestLog4J.class);


    @Test
    public void firstOuptut(){
        LOGGER.trace("trace message"); // most precise
        LOGGER.debug("debug message");
        LOGGER.info("info message");
        LOGGER.warn("warn message");
        LOGGER.error("error message"); // most general
    }





}
