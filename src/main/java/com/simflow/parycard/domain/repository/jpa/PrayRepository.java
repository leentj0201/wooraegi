package com.simflow.parycard.domain.repository.jpa;

import com.simflow.parycard.domain.entity.Member;
import com.simflow.parycard.domain.entity.Pray;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrayRepository extends JpaRepository<Pray, String> {

    List<Pray> findByMemberId(String memberId);

}
