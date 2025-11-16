package com.example.parkingpos.dto;

public class CheckOutRequest {
    private Long ticketId;
    private Boolean isMember;

    public Long getTicketId() {
        return this.ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Boolean isIsMember() {
        return this.isMember;
    }

    public Boolean getIsMember() {
        return this.isMember;
    }

    public void setIsMember(Boolean isMember) {
        this.isMember = isMember;
    }

}
