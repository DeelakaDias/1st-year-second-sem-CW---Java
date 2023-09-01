package com.example.java_cw2_2237934;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdateTest {
    HelloController check = new HelloController();

    @Test
    public void checkDriverNumberEmpty() {
        assertFalse(check.checkdriverNumberValidForUpdate(""));
    }

    @Test
    public void checkDriverNameEmpty(){
        assertFalse(check.checkdriverNameValidForUpdate(""));
    }

    @Test
    public void checkDriverNameIntegerOrNot(){
        assertFalse(check.checkdriverNameValidForUpdate("233"));
    }

    @Test
    public void checkDriverAgeEmpty(){
        assertFalse(check.checkDriverAgeValidForUpdate(""));
    }

    @Test
    public void checkDriverAgeStringOrNot(){
        assertFalse(check.checkDriverAgeValidForUpdate("abcd"));
    }

    @Test
    public void checkDriverAgeBetweenRange(){
        assertTrue(check.checkDriverAgeValidForUpdate("18"));
    }

    @Test

    public void checkDriverTeamEmpty(){
        // how to check whether team is empty or not using this case
        assertFalse(check.checkDriverTeamValidForUpdate(""));
    }

    @Test

    public void checkCarModelEmpty(){
        assertFalse(check.checkDriverModelValidForUpdate(""));
    }

    @Test

    public void checkDriverPointsEmpty(){
        assertFalse(check.checkDriverPointsValidForUpdate(""));
    }

    @Test

    public void checkDriverPointsEmptyStringOrNot(){
        assertFalse(check.checkDriverPointsValidForUpdate("abcd"));
    }
}