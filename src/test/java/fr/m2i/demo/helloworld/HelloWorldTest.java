package fr.m2i.demo.helloworld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class HelloWorldTest {
    @Test
    public void testSayHello() {
        HelloWorld instance = new HelloWorld();

        String result = instance.sayHello();

        assertEquals("Hello world!", result);
        assertNotEquals("Not that.", result);
    }
}