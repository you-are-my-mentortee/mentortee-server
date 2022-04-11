package com.mentortee.user.domain;

import com.mentortee.common.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "USER_ID")
    @Type(type = "uuid-char")
    private UUID userId;

    private String nickName;

    @Builder
    public Member(String nickName){
        this.nickName = nickName;
    }

}
