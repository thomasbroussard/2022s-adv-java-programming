package fr.epita.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class TestLog4J {

    private static final Logger LOGGER = LogManager.getLogger(TestLog4J.class);


    @Test
    public void firstOuptut(){
        LOGGER.info("test message");
    }





}
