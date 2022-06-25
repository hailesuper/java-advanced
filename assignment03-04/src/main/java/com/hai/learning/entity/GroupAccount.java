package com.hai.learning.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "groupAccount")
public class GroupAccount {
    @EmbeddedId
    private GroupAccountPK id;

    @ManyToOne
    @MapsId("groupID")
    @JoinColumn(name = "groupID")
    private Group group;

    @ManyToOne
    @MapsId("accountID")
    @JoinColumn(name = "accountID")
    private Account account;

    @Column(name = "joinDate")
    @CreationTimestamp
    private LocalDate joinDate;

    // Constructors
    public GroupAccount(Group group, Account account, LocalDate joinDate) {
        this.group = group;
        this.account = account;
        this.joinDate = joinDate;
    }

    public GroupAccount() {
    }

    // Getters and Setters

    public GroupAccountPK getId() {
        return id;
    }

    public void setId(GroupAccountPK id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }
}
