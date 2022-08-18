//package com.hai.learning.assignment08.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "group")
//@Data
//@RequiredArgsConstructor
//@NoArgsConstructor
//public class Group {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "groupID")
//    private short id;
//
//    @Column(name = "groupName")
//    private String groupName;
//
//    @ManyToOne
//    @JoinColumn(name = "creatorID")
//    private Account account;
//
//    @Column(name = "createDate")
//    private LocalDate createDate;
//}
