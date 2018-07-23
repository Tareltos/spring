package by.tarelko.projectmaneger.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, unique = true)
    private String description;
    @ManyToOne
    @JoinColumn(name = "task",nullable = false)
    private TaskList taskList;


    public Task() {
    }

    public Task(String description, TaskList taskList) {
        this.description = description;
        this.taskList = taskList;
    }

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

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(description, task.description) &&
                Objects.equals(taskList, task.taskList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, description, taskList);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", taskList=" + taskList +
                '}';
    }
}
