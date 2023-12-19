package com.simflow.parycard.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pray")
@Builder
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Pray extends BaseEntity {

    /**
     * 기도 아이디
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String prayId;

    /**
     * 기도 소유자 아이디 (멤버 아이디)
     */
    private String memberId;

    /**
     * 기도 제목
     */
    private String prayTitle;

    /**
     * 기도 내용
     */
    private String prayContent;

    /**
     * 오픈 여부
     */
    private Boolean isOpened;


}
