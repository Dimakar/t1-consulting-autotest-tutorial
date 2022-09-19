package ru.t1consulting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(OurNewExtension.class)
public class FixtureTest {
    static Triangle triangle;

    @BeforeAll
    static void beforeAll() {
        triangle = new Triangle(3, 4, 6);
    }

    @Test
    void positiveTest() {
        assertTrue(triangle.hasTheSamePerimeter(new Triangle(4, 4, 5)));
    }


    @Test
    void negativeTest() {
        assertFalse(triangle.hasTheSamePerimeter(new Triangle(4, 4, 6)));
    }
}
