package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CatTest {

    private Cat cat;
    private Feline felineMock;

    @Before
    public void setUp() {
        felineMock = mock(Feline.class);
        cat = new Cat(felineMock);
    }

    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception{
        List<String> expectedFoodList = List.of("Мясо");
        when(felineMock.eatMeat()).thenReturn(expectedFoodList);
        assertEquals(expectedFoodList, cat.getFood());
    }
}
