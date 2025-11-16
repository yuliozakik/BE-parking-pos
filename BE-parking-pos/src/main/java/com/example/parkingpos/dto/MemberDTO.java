package com.example.parkingpos.dto;

import java.util.Date;

public class MemberDTO {

    private boolean isMember;
    private String jenisParkir;
    private String name;
    private Date expiredDate;
    private Long idMember;

    public MemberDTO() {}

    public MemberDTO(boolean isMember, String jenisParkir, String name, Date expiredDate, Long idMember) {
        this.isMember = isMember;
        this.jenisParkir = jenisParkir;
        this.name = name;
        this.expiredDate = expiredDate;
        this.idMember = idMember;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    public String getJenisParkir() {
        return jenisParkir;
    }

    public void setJenisParkir(String jenisParkir) {
        this.jenisParkir = jenisParkir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public boolean isIsMember() {
        return this.isMember;
    }

    public boolean getIsMember() {
        return this.isMember;
    }

    public void setIsMember(boolean isMember) {
        this.isMember = isMember;
    }

    public Long getIdMember() {
        return this.idMember;
    }

    public void setIdMember(Long idMember) {
        this.idMember = idMember;
    }

}
