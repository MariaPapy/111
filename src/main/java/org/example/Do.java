package org.example;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class Do {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        DataContainer dataContainer = new DataContainer(20, "Mari", true);
        System.out.println(dataContainer);
        ReflectionSolve rt = new ReflectionSolve();
        IO io = new IO();
        io.createLog();
    }
}
