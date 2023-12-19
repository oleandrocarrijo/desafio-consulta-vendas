package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.projections.SaleRelatoryProjection;
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

    @Query(nativeQuery = true, value = "SELECT " +
            "TB_SALES.ID, " +
            "TB_SALES.DATE, " +
            "TB_SALES.AMOUNT, " +
            "TB_SELLER.NAME " +
            "FROM " +
            "TB_SALES " +
            "JOIN " +
            "TB_SELLER ON TB_SALES.SELLER_ID = TB_SELLER.ID " +
            "WHERE " +
            "TB_SALES.DATE BETWEEN :minDate AND :maxDate " +
            "AND UPPER(TB_SELLER.NAME) LIKE UPPER('%' || :name || '%');")
    List<SaleRelatoryProjection> search2(String minDate, String maxDate, String name);
}
