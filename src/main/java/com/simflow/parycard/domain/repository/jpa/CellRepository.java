package com.simflow.parycard.domain.repository.jpa;

import com.simflow.parycard.domain.entity.Cell;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CellRepository extends JpaRepository<Cell, String> {

    List<Cell> findByCellName(String cellName);

}
