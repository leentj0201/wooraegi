package com.simflow.parycard.member.controller;


import static com.simflow.parycard.endpoint.MemberEndPoint.MEMBER_LIST;

import com.simflow.parycard.member.dto.MemberDto;
import com.simflow.parycard.member.dto.MemberDto.ResponseSearch;
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
     *
     * @return ResponseSearch
     */
    @PostMapping(MEMBER_LIST)
    public List<ResponseSearch> searchMemberList(@RequestBody MemberDto.RequestSearch requestSearch) {
        return memberService.searchMemberList(requestSearch);
    }

}
