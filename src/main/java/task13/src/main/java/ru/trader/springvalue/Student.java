package ru.trader.springvalue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Value("${student.name}")
    private String name;
    @Value("${student.last_name}")
    private String lastName;
    @Value("${student.group}")
    private String group;



    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return group;
    }
}
