package com.sylim.practice.examUp07;

import java.io.Serializable;
import java.util.Objects;

public class Department implements Serializable {
    private String name;
    private Employee leader;
   
    public Department() {
        super();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Employee getLeader() {
        return leader;
    }
    public void setLeader(Employee leader) {
        this.leader = leader;
    }
    
    @Override
    public String toString() {
        return "Department [name=" + name + ", leader=" + leader + "]";
    }
    @Override
    public int hashCode() {
        return Objects.hash(leader, name);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Department other = (Department) obj;
        return Objects.equals(leader, other.leader) && Objects.equals(name, other.name);
    } 
}
