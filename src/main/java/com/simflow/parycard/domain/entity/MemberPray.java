package com.simflow.parycard.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "memberPray")
@Builder
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPray extends BaseEntity {

    /**
     * 멤버 셀 아이디
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String memberPrayId;

    /**
     * 멤버 아이디
     */
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    /**
     * 기도 아이디
     */
    @ManyToOne
    @JoinColumn(name = "pray_id")
    private Pray pray;
}
