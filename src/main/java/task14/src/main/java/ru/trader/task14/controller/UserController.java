package ru.trader.task14.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.trader.task14.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private ArrayList<User> list = new ArrayList<>();

    @GetMapping(value = "home")
    public String getTestPage() {
        return "home.html";
    }

    @GetMapping(value = "add-student")
    public String createStudent(@RequestParam("name") String name,@RequestParam("surname") String surname, @RequestParam("midlename")String midlename) {
        System.out.println(name +" " + surname+" "+midlename);
        User student = new User(name, surname, midlename);
        list.add(student);
        System.out.println(student);
        return student.toString();
    }

    @GetMapping(value = "show-student")
    @ResponseBody
    public Object[] showStudents() {
        return list.stream()
                .filter(item -> item instanceof User).toArray();
    }

    @GetMapping(value = "delete-student")
    @ResponseBody
    public boolean deleteStudent(@RequestParam("name") String name,@RequestParam("surname") String surname, @RequestParam("midlename")String midlename) {
        List<User> rList = new ArrayList<>();
        list.stream()
                .filter(item -> item instanceof User)
                .map(User.class::cast)
                .filter(student -> student.getFirstName().equals(name) &&
                        student.getLastName().equals(surname) &&
                        student.getMiddleName().equals(midlename))
                .forEach(rList::add);
        list.removeAll(rList);
        return rList.size() != 0 ?  true :  false;
    }
}
