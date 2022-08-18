package com.hai.learning.finalexam02.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "`groups`")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "group_name", nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "total_member", columnDefinition = "int default 0")
    private int totalMember;

    @ManyToOne
    @JoinColumn(name = "creator_id", updatable = false)
    private User creator;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    public Group(String name, int totalMember) {
        this.name = name;
        this.totalMember = totalMember;
    }

    public Group(String name, int totalMember, LocalDate createDate) {
        this.name = name;
        this.totalMember = totalMember;
        this.createDate = createDate;
    }
}
