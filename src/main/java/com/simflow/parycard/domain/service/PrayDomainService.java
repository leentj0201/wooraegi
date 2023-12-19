package com.simflow.parycard.domain.service;

import com.simflow.parycard.domain.entity.Pray;
import com.simflow.parycard.domain.repository.jpa.PrayRepository;
import com.simflow.parycard.member.dto.PrayDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrayDomainService {

    private final PrayRepository prayRepository;

    public List<Pray> findAll() {
        return prayRepository.findAll();
    }

    public List<Pray> findByMemberId(String memberId) {
        return prayRepository.findByMemberId(memberId);
    }

    public Pray findById(String prayId) {
        return prayRepository.findById(prayId).orElse(null);
    }

    public Pray save(String memberId, String prayTitle, String prayContent, Boolean isOpened) {
        return prayRepository.save(
            Pray.builder()
                .memberId(memberId)
                .prayTitle(prayTitle)
                .prayContent(prayContent)
                .isOpened(isOpened)
                .build()
        );
    }

    public Pray save(PrayDto.RequestCreate requestCreate, String memberId) {
        var pray = PrayDto.RequestCreate.toEntity(requestCreate);
        pray.setMemberId(memberId);
        return prayRepository.save(pray);
    }
}
