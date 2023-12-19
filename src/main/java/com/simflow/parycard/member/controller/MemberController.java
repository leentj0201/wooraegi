package com.simflow.parycard.member.controller;


import static com.simflow.parycard.endpoint.MemberEndPoint.MEMBER_CREATE;
import static com.simflow.parycard.endpoint.MemberEndPoint.MEMBER_LIST;

import com.simflow.parycard.member.dto.MemberDto;
import com.simflow.parycard.member.dto.MemberDto.ResponseMember;
import com.simflow.parycard.member.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * @param requestSearch
     * @return MemberDto.ResponseMember
     */
    @PostMapping(MEMBER_LIST)
    public List<ResponseMember> retrieveMemberList(@RequestBody MemberDto.RequestSearch requestSearch) {
        return memberService.retrieveMemberList(requestSearch);
    }

    /**
     *
     * @param requestCreate
     * @return MemberDto.ResponseMember
     */
    @PostMapping(MEMBER_CREATE)
    public MemberDto.ResponseMember saveMember(@RequestBody MemberDto.RequestCreate requestCreate) {
        return memberService.createMember(requestCreate);
    }

}
