package com.simflow.parycard.api.cell.service;

import com.simflow.parycard.api.cell.dto.CellDto;
import com.simflow.parycard.api.cell.dto.CellDto.ResponseCell;
import com.simflow.parycard.domain.service.CellDomainService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CellService {

    private final CellDomainService cellDomainService;

    @Transactional(readOnly = true)
    public List<ResponseCell> retrieveCellListAll() {
        return cellDomainService.findAll().stream()
            .map(ResponseCell::of)
            .collect(Collectors.toList());
    }

    @Transactional
    public ResponseCell createCell(CellDto.RequestCreate requestCreate) {
        var cell = cellDomainService.save(requestCreate);
        return ResponseCell.of(cell);
    }
}
