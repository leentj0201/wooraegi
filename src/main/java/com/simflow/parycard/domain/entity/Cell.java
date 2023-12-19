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
@Table(name = "cell")
@Builder
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Cell extends BaseEntity {

    /**
     * 기도 아이디
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String cellId;

    /**
     * 그룹 이름
     */
    private String cellName;

    /**
     * 셀 설명
     */
    private String cellDescription;

    /**
     * 공개 여부
     */
    private Boolean isPublic;

    /**
     * 사용 여부
     */
    private Boolean isUsed;

}
