package org.example;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionTaskClassTest {


    @org.junit.jupiter.api.Test
    void createClass() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        ReflectionSolve rt = new ReflectionSolve();
        assertEquals(new DataContainer(20, "Mari", true), rt.createClass(6, 12, new DataContainer(20, "Mari", true)));

    }
}