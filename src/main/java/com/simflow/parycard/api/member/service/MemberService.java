package com.simflow.parycard.api.member.service;

import com.simflow.parycard.api.member.dto.MemberCellDto;
import com.simflow.parycard.api.member.dto.MemberPrayDto;
import com.simflow.parycard.domain.entity.UserContext;
import com.simflow.parycard.domain.service.MemberDomainService;
import com.simflow.parycard.api.member.dto.MemberDto;
import com.simflow.parycard.api.member.dto.MemberDto.ResponseMember;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberDomainService memberDomainService;

    @Transactional(readOnly = true)
    public List<ResponseMember> retrieveMemberList(MemberDto.RequestSearch requestSearch) {
        return memberDomainService.findByMemberName(requestSearch.getMemberName()).stream()
            .map(ResponseMember::of)
            .collect(Collectors.toList());
    }

    @Transactional
    public MemberDto.ResponseMember createMember(MemberDto.RequestCreate requestCreate) {
        var member =  memberDomainService.save(requestCreate.getMemberName());
        return MemberDto.ResponseMember.of(member);
    }

    @Transactional(readOnly = true)
    public List<MemberCellDto.ResponseSearch> searchMemberCellList(MemberCellDto.RequestSearch requestSearch, UserContext userContext) {
        return memberDomainService.searchMemberCellList(requestSearch, userContext);

    }

    @Transactional(readOnly = true)
    public List<MemberPrayDto.ResponseSearch> searchMemberPrayList(MemberPrayDto.RequestSearch requestSearch, UserContext userContext) {
        return memberDomainService.searchMemberPrayList(requestSearch, userContext);

    }
}
