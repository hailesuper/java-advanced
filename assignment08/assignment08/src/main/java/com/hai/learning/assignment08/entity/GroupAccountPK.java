package com.hai.learning.assignment08.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class GroupAccountPK implements Serializable {
    @Column(name = "groupID")
    private short groupID;

    @Column(name = "accountID")
    private short accountID;

    // Constructor

    public GroupAccountPK(short groupID, short accountID) {
        this.groupID = groupID;
        this.accountID = accountID;
    }

    public GroupAccountPK() {
    }
}
