package com.hai.advanced.a1ex2_a2ex1_a3ex2.entity;

import jakarta.persistence.*; // javax.persistance JPA API
import org.hibernate.annotations.CreationTimestamp; // Hibernate

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int id;

    @Column(name = "email", length = 320,unique = true, nullable = false)
    private String email;

    @Column(name = "username", length = 50, unique = true, nullable = false)
    private String username;

    @Column(name = "full_name", length = 100, nullable = false)
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "position_id")
    private Position position;

    @Column(name = "create_date")
    @CreationTimestamp
    private LocalDateTime createDate;

    @OneToMany(mappedBy = "creator")
    private List<CompanyGroup> companyGroupsByCreator;

    @ManyToMany
    @JoinTable(name = "group_accounts",
        joinColumns = {@JoinColumn(name = "account_id")},
        inverseJoinColumns = {@JoinColumn(name = "group_id")})
    private List<CompanyGroup> companyGroups;

    // CONSTRUCTORS

    public Account(String email, String username, String fullName) {
        this.email = email;
        this.username = username;
        this.fullName = fullName;
    }

    public Account() {
    }

    public Account(String username, String fullName, String email, Department department, Position position) {
        this.email = email;
        this.username = username;
        this.fullName = fullName;
        this.department = department;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", position=" + position +
                ", createDate=" + createDate +
                '}';
    }

    // GETTERS AND SETTERS


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public List<CompanyGroup> getCompanyGroupsByCreator() {
        return companyGroupsByCreator;
    }

    public void setCompanyGroupsByCreator(List<CompanyGroup> companyGroupsByCreator) {
        this.companyGroupsByCreator = companyGroupsByCreator;
    }

    public List<CompanyGroup> getCompanyGroups() {
        return companyGroups;
    }

    public void setCompanyGroups(List<CompanyGroup> companyGroups) {
        this.companyGroups = companyGroups;
    }
}
