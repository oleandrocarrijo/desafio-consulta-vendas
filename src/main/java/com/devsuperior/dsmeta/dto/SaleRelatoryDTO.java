package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SaleRelatoryProjection;
import com.devsuperior.dsmeta.projections.SaleSumProjection;

import java.time.LocalDate;

public class SaleRelatoryDTO {

    private Long id;
    private LocalDate date;
    private Double amount;
    private String sellerName;

    public SaleRelatoryDTO(Long id, LocalDate date, Double amount, String sellerName) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.sellerName = sellerName;
    }

    public SaleRelatoryDTO(SaleRelatoryProjection projection) {
        id = projection.getId();
        date = projection.getDate();
        amount = projection.getAmount();
        sellerName = projection.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Override
    public String toString() {
        return "SaleRelatoryDTO{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", sellerName='" + sellerName + '\'' +
                '}';
    }
}
