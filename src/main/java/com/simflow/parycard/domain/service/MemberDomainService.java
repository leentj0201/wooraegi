package com.simflow.parycard.domain.service;

import com.simflow.parycard.api.member.dto.MemberCellDto;
import com.simflow.parycard.api.member.dto.MemberPrayDto;
import com.simflow.parycard.domain.entity.Member;
import com.simflow.parycard.domain.entity.UserContext;
import com.simflow.parycard.domain.repository.jpa.MemberRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberDomainService {

    private final MemberRepository memberRepository;

    public List<Member> findByMemberName(String memberName) {
        return memberRepository.findByMemberName(memberName);
    }
    public Member findById(String memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }

    public List<MemberCellDto.ResponseSearch> searchMemberCellList(MemberCellDto.RequestSearch requestSearch, UserContext userContext) {
        return memberRepository.searchMemberCellList(requestSearch, userContext);
    }

    public List<MemberPrayDto.ResponseSearch> searchMemberPrayList(MemberPrayDto.RequestSearch requestSearch, UserContext userContext) {
        return memberRepository.searchMemberPrayList(requestSearch, userContext);
    }

    public Member save(String memberName) {
        return memberRepository.save(
            Member.builder()
                .memberName(memberName)
                .build()
        );
    }
}
