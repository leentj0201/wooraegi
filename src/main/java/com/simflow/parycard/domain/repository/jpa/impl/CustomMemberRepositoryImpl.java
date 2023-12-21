package com.simflow.parycard.domain.repository.jpa.impl;


import static com.simflow.parycard.domain.entity.QCell.cell;
import static com.simflow.parycard.domain.entity.QMember.member;
import static com.simflow.parycard.domain.entity.QMemberCell.memberCell;
import static com.simflow.parycard.domain.entity.QMemberPray.memberPray;
import static com.simflow.parycard.domain.entity.QPray.pray;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.simflow.parycard.api.member.dto.MemberCellDto;
import com.simflow.parycard.api.member.dto.MemberCellDto.ResponseSearch;
import com.simflow.parycard.api.member.dto.MemberPrayDto;
import com.simflow.parycard.domain.entity.Member;
import com.simflow.parycard.domain.entity.UserContext;
import com.simflow.parycard.domain.repository.jpa.CustomMemberRepository;
import java.util.List;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class CustomMemberRepositoryImpl extends QuerydslRepositorySupport implements CustomMemberRepository {

    public CustomMemberRepositoryImpl() {
        super(Member.class);
    }

    private static BooleanExpression containsCellName(String callName) {
        if (callName == null) {
            return null;
        }
        return cell.cellName.contains(callName);
    }

    private static BooleanExpression containsPrayTitle(String prayTitle) {
        if (prayTitle == null) {
            return null;
        }
        return pray.prayTitle.contains(prayTitle);
    }


    @Override
    protected Querydsl getQuerydsl() {
        return super.getQuerydsl();
    }

    @Override
    public List<ResponseSearch> searchMemberCellList(MemberCellDto.RequestSearch request, UserContext userContext) {
        var response = getQuerydsl().createQuery()
            .select(Projections.constructor(
                MemberCellDto.ResponseSearch.class,
                cell.cellId,
                cell.cellName
            ))
            .from(member)
            .innerJoin(memberCell).on(member.eq(memberCell.member))
            .innerJoin(cell).on(cell.eq(memberCell.cell))
            .fetchJoin()
            .where(
                containsCellName(request.getCellName()),
                member.memberId.eq(userContext.getMemberId())
            )
            .fetch();

        return response;
    }

    @Override
    public List<MemberPrayDto.ResponseSearch> searchMemberPrayList(MemberPrayDto.RequestSearch request, UserContext userContext) {
        var response = getQuerydsl().createQuery()
            .select(Projections.constructor(
                MemberPrayDto.ResponseSearch.class,
                pray.prayTitle,
                pray.prayContent
            ))
            .from(member)
            .innerJoin(memberPray).on(member.eq(memberPray.member))
            .innerJoin(pray).on(pray.eq(memberPray.pray))
            .fetchJoin()
            .where(
                containsPrayTitle(request.getPrayTitle()),
                member.memberId.eq(userContext.getMemberId())
            )
            .fetch();

        return response;
    }
}
