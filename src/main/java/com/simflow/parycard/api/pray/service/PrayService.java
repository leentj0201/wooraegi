package com.simflow.parycard.api.pray.service;

import com.simflow.parycard.domain.entity.UserContext;
import com.simflow.parycard.domain.service.MemberDomainService;
import com.simflow.parycard.domain.service.PrayDomainService;
import com.simflow.parycard.api.pray.dto.PrayDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PrayService {

    private final PrayDomainService prayDomainService;

    @Transactional(readOnly = true)
    public List<PrayDto.ResponsePray> retrievePrayListAll() {
        return prayDomainService.findAll().stream()
            .map(PrayDto.ResponsePray::of)
            .collect(Collectors.toList());
    }

    @Transactional
    public PrayDto.ResponsePray createPray(PrayDto.RequestCreate requestCreate, UserContext userContext) {
        var pray = prayDomainService.save(requestCreate, userContext.getMemberId());
        return PrayDto.ResponsePray.of(pray);
    }
}
