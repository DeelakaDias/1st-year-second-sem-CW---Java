package com.example.java_cw2_2237934;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ADDTest {
    @Test
    public void checkDriverNumberEmpty() {
        HelloController check = new HelloController();
        assertFalse(check.checkdriverNumberValid(""));
    }

    @Test
    public void checkDriverNameEmpty(){
        HelloController check = new HelloController();
        assertFalse(check.checkdriverNameValid(""));
    }

    @Test
    public void checkDriverNameIntegerOrNot(){
        HelloController check = new HelloController();
        assertFalse(check.checkdriverNameValid("233"));
    }

    @Test
    public void checkDriverAgeEmpty(){
        HelloController check = new HelloController();
        assertFalse(check.checkDriverAgeValid(""));
    }

    @Test
    public void checkDriverAgeStringOrNot(){
        HelloController check = new HelloController();
        assertFalse(check.checkDriverAgeValid("abcd"));
    }

    @Test
    public void checkDriverAgeBetweenRange(){
        HelloController check = new HelloController();
        assertTrue(check.checkDriverAgeValid("18"));
    }

    @Test

    public void checkDriverTeamEmpty(){
        HelloController check = new HelloController();
        // how to check whether team is empty or not using this case
        assertFalse(check.checkDriverTeamValid(""));
    }

    @Test

    public void checkCarModelEmpty(){
        HelloController check = new HelloController();
        assertFalse(check.checkDriverModelValid(""));
    }

    @Test

    public void checkDriverPointsEmpty(){
        HelloController check = new HelloController();
        assertFalse(check.checkDriverPointsValid(""));
    }

    @Test

    public void checkDriverPointsEmptyStringOrNot(){
        HelloController check = new HelloController();
        assertFalse(check.checkDriverPointsValid("abcd"));
    }
}