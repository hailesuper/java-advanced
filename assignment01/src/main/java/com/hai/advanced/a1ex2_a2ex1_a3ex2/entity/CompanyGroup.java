package com.hai.advanced.a1ex2_a2ex1_a3ex2.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "company_groups")
public class CompanyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private short id;

    @Column(name = "group_name", unique = true, nullable = false)
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "creator_id", referencedColumnName = "account_id")
    private Account creator;

    @Column(name = "create_date")
    @CreationTimestamp
    private LocalDate createDate;

    @ManyToMany(mappedBy = "companyGroups")
    private List<Account> accounts;

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

    public Account getCreator() {
        return creator;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
