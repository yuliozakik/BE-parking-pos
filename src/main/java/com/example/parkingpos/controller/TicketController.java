package com.example.parkingpos.controller;

import com.example.parkingpos.dto.CheckInRequest;
import com.example.parkingpos.dto.CheckOutPreviewResponse;
import com.example.parkingpos.dto.CheckOutRequest;
import com.example.parkingpos.dto.MemberDTO;
import com.example.parkingpos.model.Ticket;
import com.example.parkingpos.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/parking")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @RequestMapping(value = "/checkin", method = RequestMethod.POST)
    public ResponseEntity<?> checkIn(@RequestBody CheckInRequest req) {
        try {
            Ticket ticket = ticketService.checkIn(req);
            return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
        } catch (IllegalStateException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message", ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", ex.getMessage()));
        }
    }
    
    @RequestMapping(value = "/checkmember", method = RequestMethod.GET)
    public ResponseEntity<?> checkMember(
            @RequestParam("plateNumber") String plateNumber,
            @RequestParam("type") String vehicleType) {

        try {
            MemberDTO dto = ticketService.checkMember(plateNumber, vehicleType);
            return ResponseEntity.ok(dto);

        } catch (IllegalStateException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("message", ex.getMessage()));

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("message", ex.getMessage()));
        }
    }

    @RequestMapping(value = "/checkout/check", method = RequestMethod.GET)
    public ResponseEntity<?> checkTicket(
            @RequestParam("plateNumber") String plateNumber,  
            @RequestParam("type") String vehicleType) {
        try {
            CheckOutPreviewResponse response = ticketService.checkTicketForCheckout(plateNumber, vehicleType);
            return ResponseEntity.ok(response);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", ex.getMessage()));
        }
    }
    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public ResponseEntity<?> checkout(@RequestBody CheckOutRequest req) {
        try {
            Ticket ticket = ticketService.finalCheckout(req);
            return ResponseEntity.ok(ticket);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", ex.getMessage()));
        }
    }

    }
