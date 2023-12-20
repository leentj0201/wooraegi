package com.simflow.parycard.domain.service;

import com.simflow.parycard.api.pray.dto.PrayDto;
import com.simflow.parycard.domain.entity.Cell;
import com.simflow.parycard.domain.entity.Member;
import com.simflow.parycard.domain.entity.MemberCell;
import com.simflow.parycard.domain.entity.Pray;
import com.simflow.parycard.domain.repository.jpa.MemberCellRepository;
import com.simflow.parycard.domain.repository.jpa.PrayRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberCellDomainService {

    private final MemberCellRepository memberCellRepository;

    public List<MemberCell> findAll() {
        return memberCellRepository.findAll();
    }

    public MemberCell save(Member member, Cell cell) {
        return memberCellRepository.save(
            MemberCell.builder()
                .member(member)
                .cell(cell)
                .build()
        );
    }
}
