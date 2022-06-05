package com.hai.advanced.a1ex2_a2ex1.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "company_groups")
public class CompanyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private short id;

    @Column(name = "group_name", unique = true, nullable = false)
    private String groupName;

//    private Account creator;

    @Column(name = "create_date")
    @CreationTimestamp
    private LocalDate createDate;

    @Override
    public String toString() {
        return "CompanyGroup{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", createDate=" + createDate +
                '}';
    }

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

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
