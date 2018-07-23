package by.tarelko.projectmaneger.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private ListType name;

    @ManyToOne
    @JoinColumn(name = "boardId", nullable = false)
    private Board board;

    public TaskList() {
    }

    public TaskList(ListType name) {
        this.name = name;
    }

    public TaskList(ListType name, Board board) {
        this.name = name;
        this.board = board;
    }

    public TaskList(Board board) {
        this.board = board;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ListType getName() {
        return name;
    }

    public void setName(ListType name) {
        this.name = name;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskList list = (TaskList) o;
        return id == list.id &&
                name == list.name &&
                Objects.equals(board, list.board);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, board);
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + id +
                ", name=" + name +
                ", board=" + board +
                '}';
    }
}
