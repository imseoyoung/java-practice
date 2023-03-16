package com.sylim.practice.examUp3;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private int id;
         
    public Student(int id, String name) {
        this.name = name;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Student [name=" + name + ", id=" + id + "]";
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        return id == other.id && Objects.equals(name, other.name);
    }
    
    @Override
    public int compareTo(Student o) {
        // return (id < o.id) ? -1 : ((id == o.id) ? 0 : 1;
        return this.name.compareTo(o.name) * -1;
    }
    

}
