package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionSolve{

    public ArrayList<Class> init(){
        ArrayList<Class> Myclass = new ArrayList<>();
        Myclass.add(DaughterClass1.class);
        Myclass.add(DaughterClass2.class);
        return Myclass;
    }

    public ArrayList<Class> createClass(int a, DataContainer dataContainer) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        ArrayList<Class> clasz = init();
        clasz = (ArrayList<Class>) clasz.stream().filter(x -> ((CustomAnnotations)x.getAnnotation(CustomAnnotations.class)).daysWeek() == a).collect(Collectors.toList());
        for(Class c :clasz){
            List<Method> method = List.of(c.getDeclaredMethods());
            Object s = c.newInstance();
            method = method.stream().sorted(Comparator.comparingInt(x -> ((MyAnnotations2)x.getAnnotation(MyAnnotations2.class)).priority())).toList();
            for(Method m: method){
                m.invoke(s, dataContainer);
                System.out.println(dataContainer.toString());            }
        }
        return null;
    }
}
