package com.example.automation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.automation.Automation;

public class AutomationToolTest {

    @Test
    public void testClickOperation() {
        Automation Automation = new Automation();
        boolean result = Automation.click("submitButton");
        assertTrue(result, "Click operation failed!");
    }

    @Test
    public void testTypeOperation() {
        Automation Automation = new Automation();
        boolean result = Automation.type("usernameField", "test_user");
        assertTrue(result, "Type operation failed!");
    }

    @Test
    public void testSelectDropdownOperation() {
        Automation Automation = new Automation();
        boolean result = Automation.selectDropdown("countryDropdown", "India");
        assertTrue(result, "Dropdown selection failed!");
    }

    @Test
    public void testElementNotFound() {
        Automation Automation = new Automation();
        Exception exception = null;

        try {
            Automation.click("nonExistentElement");
        } catch (ElementNotFoundException e) {
            exception = e;
        }

        assertNotNull(exception, "Expected exception for non-existent element was not thrown!");
        assertEquals("Element not found: nonExistentElement", exception.getMessage(), "Unexpected exception message");
    }

    @Test
    public void testNullInputHandling() {
        Automation Automation = new Automation();
        Exception exception = null;

        try {
            Automation.type(null, "value");
        } catch (IllegalArgumentException e) {
            exception = e;
        }

        assertNotNull(exception, "Expected exception for null input was not thrown!");
        assertEquals("Element identifier cannot be null.", exception.getMessage(), "Unexpected exception message");
    }
}
