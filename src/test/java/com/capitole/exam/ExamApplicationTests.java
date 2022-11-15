package com.capitole.exam;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.capitole.exam.controller.ExamServiceController;
import com.capitole.exam.domain.PricesDto;
import com.capitole.exam.repository.ExamRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = ExamApplication.class)
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@AutoConfigureTestDatabase
@ActiveProfiles("logging-test")
class ExamApplicationTests {

	@Autowired
	private ExamRepository repository;

	@After
	public void resetDb() {
		repository.deleteAll();
	}

	@Autowired
	ExamServiceController services;

//	-Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
//	 Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.

	@Test
	void test1() {
		
		LocalDateTime dateFrom = LocalDateTime.parse("2020-06-01T10:00:00");
		LocalDateTime dateTo   = LocalDateTime.parse("2020-06-14T10:59:59");

		Date startDate = Date.from(dateFrom.atZone(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(dateTo.atZone(ZoneId.systemDefault()).toInstant());

		ResponseEntity<PricesDto> item = services.consultarPvp(startDate, endDate, Long.valueOf(35455),
				Long.valueOf(1));

		log.info("RESULT TEST 1: " + item.getBody().toString());

		assertNotNull(item.hasBody());

	}
//	

//	-Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	@Test
	void test2() {

		LocalDateTime dateFrom = LocalDateTime.parse("2020-07-14T16:00:00");
		LocalDateTime dateTo   = LocalDateTime.parse("2020-07-14T16:59:59");

		Date startDate = Date.from(dateFrom.atZone(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(dateTo.atZone(ZoneId.systemDefault()).toInstant());

		ResponseEntity<PricesDto> item = services.consultarPvp(startDate, endDate, Long.valueOf(35455),
				Long.valueOf(1));

		log.info("RESULT TEST 2: " + item.getBody().toString());
		assertNotNull(item.hasBody());
	}

//	-Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)

	@Test
	void test3() {

		LocalDateTime dateFrom = LocalDateTime.parse("2020-06-14T21:00:00");
		LocalDateTime dateTo   = LocalDateTime.parse("2020-06-14T21:59:59");

		Date startDate = Date.from(dateFrom.atZone(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(dateTo.atZone(ZoneId.systemDefault()).toInstant());

		ResponseEntity<PricesDto> item = services.consultarPvp(startDate, endDate, Long.valueOf(35455),
				Long.valueOf(1));

		log.info("RESULT TEST 3: " + item.getBody().toString());

		assertNotNull(item.hasBody());
	}

//	 -Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
	@Test
	void test4() {

		LocalDateTime dateFrom = LocalDateTime.parse("2020-06-15T10:00:00");
		LocalDateTime dateTo   = LocalDateTime.parse("2020-06-15T10:59:59");

		Date startDate = Date.from(dateFrom.atZone(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(dateTo.atZone(ZoneId.systemDefault()).toInstant());

		ResponseEntity<PricesDto> item = services.consultarPvp(startDate, endDate, Long.valueOf(35455),
				Long.valueOf(1));

		log.info("RESULT TEST 4: " + item.getBody().toString());

		assertNotNull(item.hasBody());
	}

//	 -Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)

	@Test
	void test5() {
		
		LocalDateTime dateFrom = LocalDateTime.parse("2020-06-16T21:00:00");
		LocalDateTime dateTo   = LocalDateTime.parse("2020-06-16T21:59:59");

		Date startDate = Date.from(dateFrom.atZone(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(dateTo.atZone(ZoneId.systemDefault()).toInstant());

		ResponseEntity<PricesDto> item = services.consultarPvp(startDate, endDate, Long.valueOf(35455),
				Long.valueOf(1));

		log.info("RESULT TEST 5: " + item.getBody().toString());

		assertNotNull(item.hasBody());
	}

}
