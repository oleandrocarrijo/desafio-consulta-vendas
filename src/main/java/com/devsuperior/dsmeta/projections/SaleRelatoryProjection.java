package com.devsuperior.dsmeta.projections;

import java.time.LocalDate;

public interface SaleRelatoryProjection {

    Long getId();
    LocalDate getDate();
    Double getAmount();
    String getName();


}
