package org;

import org.example.Laskin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaskinTest {

    @Test
    void addValues(){
        assertEquals(6, Laskin.addValues(3,3));
        assertEquals(25, Laskin.addValues(20,5));
    }

    @Test
    void subValues(){
        assertEquals(6, Laskin.subtract(9,3));
        assertEquals(-10, Laskin.subtract(20,30));
    }

    @Test
    void multiplyValues(){
        assertEquals(30, Laskin.multiply(6,5));
        assertEquals(600, Laskin.multiply(20,30));
    }

    @Test
    void divideValues(){
        assertEquals(4, Laskin.divide(20,5));
        assertEquals(6, Laskin.divide(30,5));
    }

}