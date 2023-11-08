package org.JFarrow.Core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionComponentTest {
    PositionComponent position;
    @BeforeEach
    void setUp() {
        position = new PositionComponent(1.2456, 2.75472);
    }

    @Test
    void getX() {
        assertEquals(1.2456, position.getX());
    }

    @Test
    void getY() {
        assertEquals(2.75472, position.getY());
    }

    @Test
    void intX() {
        assertEquals(1, position.intX());
    }

    @Test
    void intY() {
        assertEquals(3, position.intY());
    }

    @Test
    void testToString() {
        String expected = "row: 1.2456, col: 2.75472";
        assertEquals(expected, position.toString());
    }
}