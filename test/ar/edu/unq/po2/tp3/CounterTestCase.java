package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CounterTestCase {

    private Counter counter;

    @BeforeEach
    public void setUp() throws Exception {

        counter = new Counter();

        counter.addNumber(1);
        counter.addNumber(2);
        counter.addNumber(3);
        counter.addNumber(4);
        counter.addNumber(5);
        counter.addNumber(6);
        counter.addNumber(7);
        counter.addNumber(8);
        counter.addNumber(9);
        counter.addNumber(10);
    }

    @Test
    public void testContarPares() {
        int cantidad = counter.getCantidadDePares();
        assertEquals(5, cantidad);
    }

    @Test
    public void testContarImpares() {
        int cantidad = counter.getCantidadImpares();
        assertEquals(5, cantidad);
    }

    @Test
    public void testMultiplosDe() {
        assertEquals(3, counter.getMultiplosDe(3));
        assertEquals(2, counter.getMultiplosDe(5));
    }
}