package task1;

class Student{
    int x;

    Student(int x){
        this.x = x;
    }
}

public class TestComparatorStudent {
    public static void main(String[] args) {
        Student student1 = new Student(2);
        Student student2 = new Student(4);
        ComparatorStudents<Student> comparatorStudents = (s1, s2) -> {
            if(s1.x - s2.x > 0){
                return "Первый";
            }else if(s1.x - s2.x < 0){
                return "Второй";
            }
            return "Равны";
        };

        System.out.println(comparatorStudents.compare(student1, student2));
    }
}
