package task2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Stream;

class Human{
    int age;
    String firstName;
    String lastName;
    LocalDate birthDate;
    int weight;

    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Human: {" +
                "age: " + age +
                ", firstName: " + firstName +
                ", lastName: " + lastName +
                ", birthDate: " + birthDate +
                ", weight: " + weight +
                "}";
    }
}

public class StreamWork {

    public static void main(String[] args) {
        Human[] humans = {
                new Human(12, "Bob", "Pupkin", LocalDate.of(2023, 11, 10), 56),
                new Human(10, "Maxim", "Volkov", LocalDate.of(1999, 2, 3), 20),
                new Human(23, "Vasa", "LastName", LocalDate.of(1800, 11, 10), 78),
                new Human(14, "Sasha", "Simin", LocalDate.of(2012, 11, 10), 120),
                new Human(18, "Nikita", "Red", LocalDate.of(2003, 8, 10), 36),
        };

        Stream<Human> stream = Arrays.stream(humans);
        stream.filter(human -> human.birthDate.compareTo(LocalDate.of(1999, 2, 3)) < 1)
                .forEach(human -> {
                    human.weight -= 5;
                    System.out.print(human.lastName + " ");
                });
    }
}
