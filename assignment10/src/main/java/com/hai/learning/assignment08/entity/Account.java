package com.hai.learning.assignment08.entity;

import com.hai.learning.assignment08.enumconverter.AccountRoleConverter;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "account")
@Data
@RequiredArgsConstructor
public class Account {
    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountID")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    // AUTH
    @Column(name = "password")
    private String password;

    public enum Role {ADMIN, EMPLOYEE, MANAGER}
    @Column(name = "role")
    @Convert(converter = AccountRoleConverter.class)
    private Role role;

    @ManyToOne()
    @JoinColumn(name = "departmentID")
    Department department;

    @ManyToOne
    @JoinColumn(name = "positionID")
    Position position;

    @ManyToOne
    @JoinColumn(name = "salaryID")
    Salary salary;

    @Column(name = "createDate")
    @CreationTimestamp
    LocalDate createDate;
}
