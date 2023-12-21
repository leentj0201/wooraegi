package com.simflow.parycard.api.member.controller;


import static com.simflow.parycard.endpoint.MemberEndPoint.MEMBER_CELL_LIST;
import static com.simflow.parycard.endpoint.MemberEndPoint.MEMBER_CREATE;
import static com.simflow.parycard.endpoint.MemberEndPoint.MEMBER_LIST;
import static com.simflow.parycard.endpoint.MemberEndPoint.MEMBER_PRAY_LIST;

import com.simflow.parycard.api.member.dto.MemberCellDto;
import com.simflow.parycard.api.member.dto.MemberPrayDto;
import com.simflow.parycard.api.member.service.MemberService;
import com.simflow.parycard.api.member.dto.MemberDto;
import com.simflow.parycard.api.member.dto.MemberDto.ResponseMember;
import com.simflow.parycard.domain.entity.MemberCell;
import com.simflow.parycard.domain.entity.MemberPray;
import com.simflow.parycard.domain.entity.UserContext;
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

    @PostMapping(MEMBER_CELL_LIST)
    public List<MemberCellDto.ResponseSearch> searchMemberCellList(@RequestBody MemberCellDto.RequestSearch requestSearch) {
        var userContext = UserContext.builder().memberId("280c7bee-0f6e-4b71-8254-cc2a75147634").build(); //todo 로그인 구현하여 제거
        return memberService.searchMemberCellList(requestSearch, userContext);
    }

    @PostMapping(MEMBER_PRAY_LIST)
    public List<MemberPrayDto.ResponseSearch> searchMemberPrayList(@RequestBody MemberPrayDto.RequestSearch requestSearch) {
        var userContext = UserContext.builder().memberId("280c7bee-0f6e-4b71-8254-cc2a75147634").build(); //todo 로그인 구현하여 제거
        return memberService.searchMemberPrayList(requestSearch, userContext);
    }
}
