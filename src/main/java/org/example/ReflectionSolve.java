package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ReflectionSolve {

    public ArrayList<Class> init(){
        ArrayList<Class> clazs = new ArrayList<>();
        clazs.add(DaughterClass1.class);
        clazs.add(DaughterClass2.class);
        return clazs;

    }

    public DataContainer createClass(int a, int hour, DataContainer dataContainer) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        ArrayList<Class> clasz = init();
        clasz = (ArrayList<Class>) clasz.stream().filter(x -> ((CustomAnnotations)x.getAnnotation(CustomAnnotations.class)).daysWeek() == a).collect(Collectors.toList());
        for(Class c :clasz){
            List<Method> method = List.of(c.getDeclaredMethods());
            Object s = c.newInstance();
            method = method.stream().filter(x -> x.getAnnotation(MyAnnotations2.class).hour()== hour).collect(Collectors.toList());
            method = method.stream().sorted(Comparator.comparingInt(x -> x.getAnnotation(MyAnnotations2.class).priority())).toList();
            for(Method m: method){
                m.invoke(s, dataContainer);
            }
        }
        return dataContainer;
    }

}