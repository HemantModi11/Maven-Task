package com.example.automation;

public class Automation {

    /**
     * Simulates clicking an element by its identifier.
     *
     * @param elementId The identifier of the element to click.
     * @return true if the click operation is successful, false otherwise.
     */
    public boolean click(String elementId) {
        if (elementId == null || !elementExists(elementId)) {
            throw new ElementNotFoundException("Element not found: " + elementId);
        }
        System.out.println("Clicked element with ID: " + elementId);
        return true;
    }

    /**
     * Simulates typing into an element.
     *
     * @param elementId The identifier of the element to type into.
     * @param value     The value to be typed.
     * @return true if the type operation is successful, false otherwise.
     */
    public boolean type(String elementId, String value) {
        if (elementId == null) {
            throw new IllegalArgumentException("Element identifier cannot be null.");
        }
        if (!elementExists(elementId)) {
            throw new ElementNotFoundException("Element not found: " + elementId);
        }
        System.out.println("Typed '" + value + "' into element with ID: " + elementId);
        return true;
    }

    /**
     * Simulates selecting a value from a dropdown menu.
     *
     * @param elementId The identifier of the dropdown menu.
     * @param value     The value to select.
     * @return true if the selection is successful, false otherwise.
     */
    public boolean selectDropdown(String elementId, String value) {
        if (!elementExists(elementId)) {
            throw new ElementNotFoundException("Element not found: " + elementId);
        }
        System.out.println("Selected '" + value + "' from dropdown with ID: " + elementId);
        return true;
    }

    /**
     * Simulates checking if an element exists.
     *
     * @param elementId The identifier of the element.
     * @return true if the element exists, false otherwise.
     */
    private boolean elementExists(String elementId) {
        // Dummy implementation for element existence check
        return !"nonExistentElement".equals(elementId);
    }

    public static void main(String[] args) {
        // Example usage
        Automation tool = new Automation();
        try {
            tool.click("submitButton");
            tool.type("usernameField", "test_user");
            tool.selectDropdown("countryDropdown", "India");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

/**
 * Custom exception for handling cases where an element is not found.
 */
class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String message) {
        super(message);
    }
}
