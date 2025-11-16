package com.example.parkingpos.repository;

import com.example.parkingpos.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findFirstByPlateNumberAndTypeAndStatus(String plateNumber, String type, String status);
}
