package org.example;

import lombok.NonNull;

@CustomAnnotations(daysWeek = 1)
abstract class ParentClass{
    abstract void method(@NonNull DataContainer dataContainer);
    abstract void method1(@NonNull DataContainer dataContainer);
}


class DaughterClass1 extends ParentClass{
    @MyAnnotations2(hour = 11, description = "приоритет 2", priority = 2)
    public void method(@NonNull DataContainer dataContainer){
        dataContainer.setName("Мистер Кот");
        System.out.println(dataContainer.getName());
    }

    @MyAnnotations2(hour = 22, description = "приоритет 2", priority = 2)
    public void method1(@NonNull DataContainer dataContainer){
        dataContainer.setName("Мистер Мышь");
        System.out.println(dataContainer.getName());
    }
}


@CustomAnnotations(daysWeek = 1)
class DaughterClass2 extends ParentClass{
    @MyAnnotations2(hour = 11, description = "прироритет 1", priority = 1)
    public void method(@NonNull DataContainer dataContainer){
        dataContainer.status(false);
        System.out.println(dataContainer.status);
    }

    @Override
    void method1(@NonNull DataContainer dataContainer) {

    }

}


