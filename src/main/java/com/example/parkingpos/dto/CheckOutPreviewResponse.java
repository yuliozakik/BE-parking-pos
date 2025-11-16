package com.example.parkingpos.dto;

import java.util.Date;

public class CheckOutPreviewResponse {

    private Long ticketId;
    private String plateNumber;
    private Date checkInTime;
    private Date checkOutPreviewTime;
    private long totalHours;
    private int totalPrice;
    private Boolean isMember;

    // 🔥 Tambah constructor lengkap sesuai yang dipakai di service
    public CheckOutPreviewResponse(
            Long ticketId,
            String plateNumber,
            Date checkInTime,
            Date checkOutPreviewTime,
            long totalHours,
            int totalPrice,
            Boolean isMember
    ) {
        this.ticketId = ticketId;
        this.plateNumber = plateNumber;
        this.checkInTime = checkInTime;
        this.checkOutPreviewTime = checkOutPreviewTime;
        this.totalHours = totalHours;
        this.totalPrice = totalPrice;
        this.isMember = isMember;
    }

    // Getter + Setter
    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getCheckOutPreviewTime() {
        return checkOutPreviewTime;
    }

    public void setCheckOutPreviewTime(Date checkOutPreviewTime) {
        this.checkOutPreviewTime = checkOutPreviewTime;
    }

    public long getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(long totalHours) {
        this.totalHours = totalHours;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getIsMember() {
        return isMember;
    }

    public void setIsMember(Boolean isMember) {
        this.isMember = isMember;
    }
}
