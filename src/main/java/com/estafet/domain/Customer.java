package com.estafet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
import java.util.*;

public class Customer {

    private Long id;

    private String name;

    private String surname;

    private Date created;

    @JsonIgnore
    private Set<Task> tasks;

    public Customer(){}

    public Customer(String name){
        this.name = name;
        this.created = new Date(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        if (!getId().equals(customer.getId())) return false;
        if (!getName().equals(customer.getName())) return false;
        if (!getSurname().equals(customer.getSurname())) return false;
        if (!getCreated().equals(customer.getCreated())) return false;
        return getTasks().equals(customer.getTasks());
    }

    @Override
    public int hashCode() {
        int id = this.getId() == null ? 1 : this.getId().intValue();
        int result = id;
        result = 31 * result + getName().hashCode();
        result = 31 * result + getSurname().hashCode();
        result = 31 * result + getCreated().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", created=" + created +
                ", tasks=" + tasks +
                '}';
    }
}
