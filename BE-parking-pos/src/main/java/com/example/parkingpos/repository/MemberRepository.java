package com.example.parkingpos.repository;

import com.example.parkingpos.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findFirstByPlateNumberAndType(String plateNumber, String type);
}
