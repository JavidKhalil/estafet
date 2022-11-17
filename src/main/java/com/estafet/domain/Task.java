package com.estafet.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Task {

    private Long id;

    private String title;

    private String description;

    private Boolean finished;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Customer customer;

    public Task(){

    }

    public Task(String title, String description, Boolean finished, Customer customer) {
        this.title = title;
        this.description = description;
        this.finished = finished;
        this.customer = customer;
    }

    public Task(Long id, String title, String description, Boolean finished, Customer customer) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.finished = finished;
        this.customer = customer;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (!getId().equals(task.getId())) return false;
        if (!getTitle().equals(task.getTitle())) return false;
        if (!getDescription().equals(task.getDescription())) return false;
        if (!getFinished().equals(task.getFinished())) return false;
        return getCustomer().equals(task.getCustomer());
    }

    @Override
    public int hashCode() {
        int id = this.getId() == null ? 1 : this.getId().intValue();
        int result = id;
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getFinished().hashCode();
        result = 31 * result + getCustomer().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", finished=" + finished +
                ", customer=" + customer +
                '}';
    }
}
