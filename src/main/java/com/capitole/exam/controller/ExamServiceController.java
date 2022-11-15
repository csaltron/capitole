package com.capitole.exam.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capitole.exam.domain.PricesDto;
import com.capitole.exam.domain.PricesEntity;
import com.capitole.exam.mapping.PricesMapper;
import com.capitole.exam.services.ExamServiceDB;


@RestController
@RequestMapping(value = "consultar")
public class ExamServiceController {

	@Autowired
	private ExamServiceDB service;
	
	@Autowired
	private PricesMapper pricesMapper;

//    REQUERIMIENTO
//    Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
//    Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.
//     

	@RequestMapping(value = "/pvp/{start}/{end}/{productId}/{brandId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PricesDto> consultarPvp(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd hh24:mi:ss") Date start,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd hh24:mi:ss") Date end, @PathVariable Long productId,
			@PathVariable Long brandId) {

		PricesEntity response = service.findPvp(start, end, productId, brandId);
		
		PricesDto pricesDto = pricesMapper.priceDbToPricesDto(response);

		return ResponseEntity.ok(pricesDto);
	}

}
