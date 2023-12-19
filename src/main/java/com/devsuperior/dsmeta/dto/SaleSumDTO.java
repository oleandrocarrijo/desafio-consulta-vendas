package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SaleSumProjection;

public class SaleSumDTO {

    private String  sellerName;
    private Double total;

    public SaleSumDTO(String  sellerName, Double total) {
        this. sellerName =  sellerName;
        this.total = total;
    }

    public SaleSumDTO(SaleSumProjection projection) {
         sellerName = projection.getNomeVendedor();
        total = projection.getTotal();
    }

    public String getsellerName() {
        return  sellerName;
    }

    public void setsellerName(String  sellerName) {
        this. sellerName =  sellerName;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SaleSumDTO{" +
                " sellerName='" +  sellerName + '\'' +
                ", total=" + total +
                '}';
    }
}

