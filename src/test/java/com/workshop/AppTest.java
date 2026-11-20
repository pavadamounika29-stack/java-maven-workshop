package com.workshop;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    public void testGreet() {
        App app = new App();
        assertEquals("Hello CI/CD Workshop!", app.greet());
    }
}
