package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SaleRelatoryDTO;
import com.devsuperior.dsmeta.dto.SaleSumDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<List<SaleRelatoryDTO>> getReport(
			@RequestParam(name = "minDate", defaultValue = "") String minDate,
			@RequestParam(name = "maxDate", defaultValue = "") String maxDate,
			@RequestParam(name = "name", defaultValue = "") String name
	) {
		List<SaleRelatoryDTO> dto = service.getReport(minDate, maxDate, name);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<List<SaleSumDTO>> getSummary(
			@RequestParam(name = "minDate", defaultValue = "") String minDate,
			@RequestParam(name = "maxDate", defaultValue = "") String maxDate
	) {
		List<SaleSumDTO> dto = service.getSummary(minDate, maxDate);
		return ResponseEntity.ok(dto);
	}
}
