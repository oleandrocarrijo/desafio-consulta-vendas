package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.projections.SaleSumProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(nativeQuery = true, value = "SELECT " +
            "TB_SELLER.NAME AS NomeVendedor, " +
            "SUM(TB_SALES.AMOUNT) AS total  "+
            "FROM " +
            "TB_SELLER " +
            "JOIN " +
            "TB_SALES ON TB_SELLER.ID = TB_SALES.SELLER_ID " +
            "WHERE " +
            "TB_SALES.DATE BETWEEN :minDate AND :maxDate " +
            "GROUP BY " +
            "TB_SELLER.ID, TB_SELLER.NAME;")
    List<SaleSumProjection> search1(String minDate, String maxDate);
    // minDate= 2022-01-01
    // maxDate= 2022-06-30
    // String minDate, String maxDate
}
