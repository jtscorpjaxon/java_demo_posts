package uz.mohirdev.mohirdev.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    public Student(Long id, String name, String lastname, Integer age, Course course) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.course = course;
    }

    private Long id;
    private String name;
//    @JsonProperty("last_name")
    private String lastname;
    private Integer age;
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
