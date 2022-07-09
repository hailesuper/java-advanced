//package com.hai.learning.assignment08.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "groupAccount")
//@Data
//@RequiredArgsConstructor
//@NoArgsConstructor
//public class GroupAccount {
//    @EmbeddedId
//    private GroupAccountPK id;
//
//    @ManyToOne
//    @MapsId("groupID")
//    @JoinColumn(name = "groupID")
//    private Group group;
//
//    @ManyToOne
//    @MapsId("accountID")
//    @JoinColumn(name = "accountID")
//    private Account account;
//
//    @Column(name = "joinDate")
//    @CreationTimestamp
//    private LocalDate joinDate;
//}
