package ru.trader.springvalue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringValueApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringValueApplication.class, args);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Student student = (Student) context.getBean("student", Student.class);
        System.out.println(student.getName());
        System.out.println(student.getLastName());
        System.out.println(student.getGroup());
    }

}
