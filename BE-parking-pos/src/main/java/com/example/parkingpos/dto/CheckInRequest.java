package com.example.parkingpos.dto;

public class CheckInRequest {
    private String plateNumber;
    private String type;
    private Boolean isMember;
    private Long idMember;

    public String getPlateNumber() {
        return this.plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String isType() {
        return this.type;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Long getIdMember() {
        return this.idMember;
    }

    public void setIdMember(Long idMember) {
        this.idMember = idMember;
    }

}
