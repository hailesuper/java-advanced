package com.hai.advanced.a1ex1.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "`groups`")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "create_date")
    @CreationTimestamp
    private LocalDate createDate;

    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group(String groupName, LocalDate createDate) {
        this.groupName = groupName;
        this.createDate = createDate;
    }

    public Group(int id) {
        this.id = id;
    }

    public Group(int id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "\nGroup{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", createDate=" + createDate +
                "}\n";
    }
}
