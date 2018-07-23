package by.tarelko.projectmaneger.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, unique = true)
    private String description;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "taskId", nullable = false)
    private TaskList taskList;

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
}
