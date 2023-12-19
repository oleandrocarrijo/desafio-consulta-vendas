package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devsuperior.dsmeta.dto.SaleRelatoryDTO;
import com.devsuperior.dsmeta.dto.SaleSumDTO;
import com.devsuperior.dsmeta.projections.SaleRelatoryProjection;
import com.devsuperior.dsmeta.projections.SaleSumProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public List<SaleSumDTO> getSummary(String minDate, String maxDate) {

		if (maxDate.isEmpty()) {
			LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
			maxDate = String.valueOf(today);
		}
		if (minDate.isEmpty()) {
			LocalDate date = LocalDate.parse(maxDate).minusYears(1L);
			minDate = String.valueOf(date);
		}

		List<SaleSumProjection> list = repository.search1(minDate, maxDate);
		List<SaleSumDTO> result = list.stream().map(x -> new SaleSumDTO(x)).collect(Collectors.toList());

		return result;
	}

	public List<SaleRelatoryDTO> getReport(String minDate, String maxDate, String name) {

		if (maxDate.isEmpty()) {
			LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
			maxDate = String.valueOf(today);
		}
		if (minDate.isEmpty()) {
			LocalDate date = LocalDate.parse(maxDate).minusYears(1L);
			minDate = String.valueOf(date);
		}

		List<SaleRelatoryProjection> list = repository.search2(minDate, maxDate, name);
		List<SaleRelatoryDTO> result = list.stream().map(x -> new SaleRelatoryDTO(x)).collect(Collectors.toList());
		return result;
	}
}
