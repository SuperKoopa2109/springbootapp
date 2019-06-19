package com.nik.projgreet;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class mainTest {
    @Test public void testAppHasAGreeting() {
        main classUnderTest = new main();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
        assertTrue("app returning incorrect greeting", classUnderTest.getGreeting().equals("Hello world."));
    }
}
