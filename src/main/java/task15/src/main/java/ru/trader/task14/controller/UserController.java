package ru.trader.task14.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.trader.task14.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class UserController {

    private static final String URL = "jdbc:postgresql://localhost:5432/users";
    private static final String USERNAME = "postrges";
    private static final String PASSWORD = "123";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<User> takeUsers() {
        ArrayList<User> list = new ArrayList<>();

        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM Users");
            while(resultSet.next()){
                String firstname = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String middleName = resultSet.getString("middleName");
                String birthDate = resultSet.getString("birthDate");
                User user = new User(firstname, lastName, middleName, birthDate);
                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @GetMapping(value = "home")
    public String getTestPage() {
        return "home.html";
    }

    @GetMapping(value = "add-student")
    public void createStudent(@RequestParam("name") String name,@RequestParam("surname") String surname, @RequestParam("middleName")String middleName) {
        System.out.println(name +" " + surname+" "+middleName);
        User student = new User(name, surname, middleName, new Date().toString());

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Users VALUES (1, ?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, middleName);
            preparedStatement.setString(4, new Date().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(student);
    }

    @GetMapping(value = "show-student")
    @ResponseBody
    public Object[] showStudents(){

        ArrayList<User> list = takeUsers();
        return list.stream()
                .filter(item -> item instanceof User).toArray();
    }

    @GetMapping(value = "delete-student")
    @ResponseBody
    public void deleteStudent(@RequestParam("name") String name,@RequestParam("surname") String surname, @RequestParam("middleName")String middleName)  {

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Users WHERE firstname=?");
            preparedStatement.setString(1, name);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
