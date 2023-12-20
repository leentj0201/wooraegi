package com.simflow.parycard.domain.repository.jpa;

import com.simflow.parycard.domain.entity.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String>, CustomMemberRepository {

    List<Member> findByMemberName(String memberName);
}
