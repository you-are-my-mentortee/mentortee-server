package com.mentortee.user.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Member {

    @Id
    private UUID userId;

    private String nickName;
}
