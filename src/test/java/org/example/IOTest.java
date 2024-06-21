package org.example;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class IOTest {

    @Test
    void writeFile() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        ReflectionSolve rt = new ReflectionSolve();
        IO io = new IO();
        io.writeFile(String.valueOf(rt.createClass(6, 12, new DataContainer(20, "Mari", true))), "test.txt");
        String s = io.readFile("test.txt");
        assertEquals("DataContainer(year=20, name=Mari, status=true)", s);
    }

}