package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devsuperior.dsmeta.dto.SaleSumDTO;
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

		if (minDate.isEmpty() && maxDate.isEmpty()) {
			LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
			minDate = String.valueOf(today.minusYears(1L));
			maxDate = String.valueOf(today);
		}

		List<SaleSumProjection> list = repository.search1(minDate, maxDate);
		List<SaleSumDTO> result1 = list.stream().map(x -> new SaleSumDTO(x)).collect(Collectors.toList());

		return result1;
	}
}
