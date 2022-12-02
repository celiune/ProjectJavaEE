package com.example.projectjavaee;

public class ToDos {

    private int id;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ToDos(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public ToDos(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ToDos{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
