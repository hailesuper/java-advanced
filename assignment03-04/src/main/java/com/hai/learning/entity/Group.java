package com.hai.learning.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupID")
    private short id;

    @Column(name = "groupName")
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "creatorID")
    private Account account;

    @Column(name = "createDate")
    private LocalDate createDate;

    // Constructors
    public Group() {
    }

    public Group(String groupName, Account account) {
        this.groupName = groupName;
        this.account = account;
    }

    // Getters and Setters

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
