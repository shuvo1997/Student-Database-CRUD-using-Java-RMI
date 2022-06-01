// Student (Id, name, dept, gender, age, ad_year)

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String department;
    private String gender;
    private int age;
    private int ad_year;
    Student(int id, String name, String department, String gender, int age, int ad_year){
        this.id = id;
        this.name = name;
        this.department = department;
        this.gender = gender;
        this.age = age;
        this.ad_year = ad_year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", ad_year=" + ad_year +
                '}';
    }
}
