package com.devsuperior.dsmeta;

import com.devsuperior.dsmeta.dto.SaleRelatoryDTO;
import com.devsuperior.dsmeta.dto.SaleSumDTO;
import com.devsuperior.dsmeta.projections.SaleRelatoryProjection;
import com.devsuperior.dsmeta.projections.SaleSumProjection;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DsmetaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsmetaApplication.class, args);
	}
}
