package com.simflow.parycard.domain.service;

import com.simflow.parycard.api.cell.dto.CellDto;
import com.simflow.parycard.domain.entity.Cell;
import com.simflow.parycard.domain.repository.jpa.CellRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CellDomainService {

    private final CellRepository cellRepository;

    public List<Cell> findAll() {
        return cellRepository.findAll();
    }

    public List<Cell> findByGroupName(String cellName) {
        return cellRepository.findByCellName(cellName);
    }

    public Cell findById(String cellId) {
        return cellRepository.findById(cellId).orElse(null);
    }

    public Cell save(String cellName, String cellDescription, Boolean isPublic, Boolean isUsed) {
        return cellRepository.save(
            Cell.builder()
                .cellName(cellName)
                .cellDescription(cellDescription)
                .isPublic(isPublic)
                .isUsed(isUsed)
                .build()
        );
    }

    public Cell save(CellDto.RequestCreate requestCreate) {
        return cellRepository.save(CellDto.RequestCreate.toEntity(requestCreate));
    }
}
