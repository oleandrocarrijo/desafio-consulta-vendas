package com.devsuperior.dsmeta;

import com.devsuperior.dsmeta.dto.SaleSumDTO;
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
public class DsmetaApplication implements CommandLineRunner {

	@Autowired
	private SaleRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DsmetaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<SaleSumProjection> list = repository.search1("2022-01-01", "2022-06-30");
		List<SaleSumDTO> result1 = list.stream().map(x -> new SaleSumDTO(x)).collect(Collectors.toList());

		for (SaleSumDTO obj : result1) {
			System.out.println(obj);
		}

		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		System.out.println(today);
	}
}
