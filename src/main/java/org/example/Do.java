package org.example;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Do {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        DataContainer dataContainer = new DataContainer(2010, "Cat", true);
        System.out.println(dataContainer);
        ReflectionSolve rt = new ReflectionSolve();
       ArrayList<Class> classes = rt.createClass(6, dataContainer);
        IO io = new IO();
        io.createLog();
    }
}
