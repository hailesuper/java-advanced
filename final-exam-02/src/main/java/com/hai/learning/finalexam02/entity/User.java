package com.hai.learning.finalexam02.entity;

import com.hai.learning.finalexam02.entity.enumconverter.UserRoleConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "password", nullable = false, length = 200)
    private String password;

    public enum UserRole {
        ADMIN, MANAGER, USER
    }

    @Column(name = "role")
    @Convert(converter = UserRoleConverter.class)
    private UserRole role;

    @OneToMany(mappedBy = "creator")
    private List<Group> groups;
}
