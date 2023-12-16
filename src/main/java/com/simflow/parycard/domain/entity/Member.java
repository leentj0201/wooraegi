package com.simflow.parycard.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "member")
@Setter
@Getter
@NoArgsConstructor
public class Member extends BaseEntity {

    /**
     * 멤버 아이디
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2")
    private String memberId;

    /**
     * 멤버 이름
     */
    private String memberName;
}
