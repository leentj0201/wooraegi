package com.simflow.parycard.member.service;

import com.simflow.parycard.domain.service.MemberDomainService;
import com.simflow.parycard.member.dto.MemberDto;
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
    public List<MemberDto.ResponseSearch> searchMemberList(MemberDto.RequestSearch requestSearch) {
        return memberDomainService.findByMemberName(requestSearch.getMemberName()).stream()
            .map(MemberDto.ResponseSearch::of)
            .collect(Collectors.toList());
    }
}
