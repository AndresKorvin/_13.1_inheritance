package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SmartphoneTest {
    Smartphone smartphone = new Smartphone(1, "Iphone X", 999, "Apple");
    @Test
    void getId() {

        int expected = smartphone.getId();
        int actual = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getName() {

        String expected = smartphone.getName();
        String actual = "Iphone X";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPrice() {

        int expected = smartphone.getPrice();
        int actual = 999;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getManufacturer() {

        String expected = smartphone.getManufacturer();
        String actual = "Apple";

        Assertions.assertEquals(expected, actual);
    }
}
