package com.example.java_cw2_2237934;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteTest {

    @Test
    public void checkDriverNumberEmpty() {
        HelloController check = new HelloController();
        assertFalse(check.checkdriverNumberForDelete(""));
    }

}