package lesson02.servlet;

public class Student {
    private final String name;
    private final int age;
    private final String group;

    public Student(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String uname() {
        return name.toUpperCase();
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }
}
