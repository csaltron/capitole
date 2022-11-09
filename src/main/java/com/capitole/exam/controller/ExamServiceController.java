package com.capitole.exam.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capitole.exam.domain.ExamServiceDto;
import com.capitole.exam.services.ExamService;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping(value = "consultar")
public class ExamServiceController {
    
    @Autowired
    private ExamService service;
    

    
    
    
    
//    REQUERIMIENTO
//    Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
//    Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.
//     
    
	@RequestMapping(value = "/pvp/{start}/{end}/{productId}/{brandId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ExamServiceDto> consultarPvp(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date  start, @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date  end, 
			@PathVariable Long productId, @PathVariable Long brandId) {
		
//		log.info("Consultando el precio final (pvp) del producto " + productId);

		Calendar desde = Calendar.getInstance(); desde.setTime(start);
		Calendar hasta = Calendar.getInstance(); hasta.setTime(end);
        ExamServiceDto response = service.consultarPvp(desde,  hasta, productId, brandId);
        return ResponseEntity.ok(response);
    }
	


}
