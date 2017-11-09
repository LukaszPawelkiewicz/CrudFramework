package com.lp.crudframework.main;

import com.lp.crudframework.api.Facade;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.lp.crudframework"
})
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        Facade facade = context.getBean(Facade.class);
        facade.generateClasses("test.xml");

        context.close();
    }

}
