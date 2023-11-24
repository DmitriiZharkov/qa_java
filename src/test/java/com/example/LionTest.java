package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    private Lion lion;
    private Feline felineMock;

    @Before
    public void setUp() throws Exception {
        felineMock = mock(Feline.class);
        lion = new Lion("Самец", felineMock);
    }

    @Test
    public void testGetKittens() {
        when(felineMock.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testDoesHaveMane() {
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void testDoesHaveManeFemale() throws Exception {
        Lion lionFemale = new Lion("Самка", felineMock);
        assertFalse(lionFemale.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception {
        new Lion("Некорректный пол", felineMock);
    }
}
