package com.mentortee.user.domain;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class Member {


    private UUID userId;

    private String nickName;
}
