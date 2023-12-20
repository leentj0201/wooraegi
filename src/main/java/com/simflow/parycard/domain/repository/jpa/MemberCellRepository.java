package com.simflow.parycard.domain.repository.jpa;

import com.simflow.parycard.domain.entity.MemberCell;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberCellRepository extends JpaRepository<MemberCell, String> {

    List<MemberCell> findAll();

}
