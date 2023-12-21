package com.simflow.parycard.domain.repository.jpa;

import com.simflow.parycard.api.member.dto.MemberCellDto;
import com.simflow.parycard.api.member.dto.MemberPrayDto;
import com.simflow.parycard.domain.entity.UserContext;
import java.util.List;

public interface CustomMemberRepository {

    List<MemberCellDto.ResponseSearch> searchMemberCellList(MemberCellDto.RequestSearch request, UserContext userContext);
    List<MemberPrayDto.ResponseSearch> searchMemberPrayList(MemberPrayDto.RequestSearch request, UserContext userContext);
}
