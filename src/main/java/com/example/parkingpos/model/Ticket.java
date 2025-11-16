package com.example.parkingpos.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plate_number", nullable = false, length = 50)
    private String plateNumber;

    @Column(name = "check_in_time", nullable = false)
    private Date checkInTime;

    @Column(name = "check_out_time")
    private Date checkOutTime;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "created_at", updatable = false, insertable = false)
    private Date createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Date updatedAt;

    @Column(name = "is_member", updatable = false)
    private Boolean isMember;

    @Column(name = "type", length = 10)
    private String type;
        
    @Column(name = "id_member", length = 10)
    private Long idMember;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return this.plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Date getCheckInTime() {
        return this.checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getCheckOutTime() {
        return this.checkOutTime;
    }

    public void setCheckOutTime(Date checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public Integer getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getIdMember() {
        return this.idMember;
    }

    public void setIdMember(Long idMember) {
        this.idMember = idMember;
    }

}
