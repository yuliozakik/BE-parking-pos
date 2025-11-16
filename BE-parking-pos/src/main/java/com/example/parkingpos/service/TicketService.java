package com.example.parkingpos.service;

import com.example.parkingpos.dto.CheckInRequest;
import com.example.parkingpos.dto.CheckOutPreviewResponse;
import com.example.parkingpos.dto.CheckOutRequest;
import com.example.parkingpos.dto.MemberDTO;
import com.example.parkingpos.model.Member;
import com.example.parkingpos.model.Ticket;
import com.example.parkingpos.repository.MemberRepository;
import com.example.parkingpos.repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    MemberRepository memberRepository;

    private static final int RATE_PER_HOUR = 3000;

    @Transactional
    public Ticket checkIn(CheckInRequest request) {
        Date currentTimeStamp = new Date();
        String normalized = request.getPlateNumber().trim();

        Optional<Ticket> active = ticketRepository.findFirstByPlateNumberAndTypeAndStatus(normalized, request.getType(), "ACTIVE");
        if (active.isPresent()) {
            throw new IllegalStateException("Vehicle with plate already active");
        }
        System.out.println("DATAAA === " + request.getIsMember());
        Ticket t = new Ticket();
        t.setPlateNumber(normalized);
        t.setCheckInTime(currentTimeStamp);
        t.setStatus("ACTIVE");
        t.setTotalPrice(null);
        t.setCheckOutTime(null);
        t.setIsMember(request.getIsMember());
        t.setType(request.getType());
        t.setIdMember(request.getIdMember());

        return ticketRepository.save(t);
    }

    public MemberDTO checkMember(String plateNumber, String vehicleType) {

        String normalized = plateNumber.trim();
        Date now = new Date();

        Optional<Member> optionalMember =
                memberRepository.findFirstByPlateNumberAndType(normalized, vehicleType);

        if (optionalMember.isEmpty()) {
            return new MemberDTO(
                    false,
                    "NON-MEMBER",
                    null,
                    null,
                    null
            );
        }

        Member member = optionalMember.get();

        if (member.getExpiredDate().before(now)) {
            throw new IllegalStateException(
                    "Member with name " + member.getName() + " expired on " + member.getExpiredDate()
            );
        }

        return new MemberDTO(
                true,
                "MEMBER",
                member.getName(),
                member.getExpiredDate(),
                member.getId()
        );
    }

    public CheckOutPreviewResponse checkTicketForCheckout(String plateNumber, String vehicleType) {

        Ticket t = ticketRepository.findFirstByPlateNumberAndTypeAndStatus(plateNumber, vehicleType, "ACTIVE")
                .orElseThrow(() -> new RuntimeException("Active ticket not found"));

        Date now = new Date();

        long millis = now.getTime() - t.getCheckInTime().getTime();
        long hours = (long) Math.ceil(millis / (1000.0 * 60.0 * 60.0));
        if (hours < 1) hours = 1;

        int total = (int) (hours * RATE_PER_HOUR);
        int price = Boolean.TRUE.equals(t.getIsMember()) ? 0 : total;

        return new CheckOutPreviewResponse(
                t.getId(),
                t.getPlateNumber(),
                t.getCheckInTime(),
                now,
                hours,
                price,
                t.getIsMember()
        );
    }

    @Transactional
    public Ticket finalCheckout(CheckOutRequest request) {

        Ticket t = ticketRepository.findById(request.getTicketId())
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        if (!"ACTIVE".equals(t.getStatus())) {
            throw new IllegalStateException("Ticket is not active");
        }

        t.setStatus("FINISHED");
        t.setCheckOutTime(new Date());

        return ticketRepository.save(t);
    }


}
