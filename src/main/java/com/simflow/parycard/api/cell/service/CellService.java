package com.simflow.parycard.api.cell.service;

import com.simflow.parycard.api.cell.dto.CellDto;
import com.simflow.parycard.api.cell.dto.CellDto.ResponseCell;
import com.simflow.parycard.domain.entity.MemberCell;
import com.simflow.parycard.domain.entity.UserContext;
import com.simflow.parycard.domain.service.CellDomainService;
import com.simflow.parycard.domain.service.MemberCellDomainService;
import com.simflow.parycard.domain.service.MemberDomainService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class CellService {

    private final CellDomainService cellDomainService;
    private final MemberCellDomainService memberCellDomainService;
    private final MemberDomainService memberDomainService;

    @Transactional(readOnly = true)
    public List<ResponseCell> retrieveCellListAll() {
        return cellDomainService.findAll().stream()
            .map(ResponseCell::of)
            .collect(Collectors.toList());
    }

    @Transactional
    public ResponseCell createCell(CellDto.RequestCreate requestCreate, UserContext userContext) {
        var cell = cellDomainService.save(requestCreate);

        var member = memberDomainService.findById(userContext.getMemberId());
        memberCellDomainService.save(member, cell);

        return ResponseCell.of(cell);
    }
}
