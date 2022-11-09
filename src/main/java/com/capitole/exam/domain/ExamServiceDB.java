package com.capitole.exam.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRICES")
public class ExamServiceDB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	PRODUCT_ID: Identificador código de producto.
	private Long productId;

//	BRAND_ID: foreign key de la cadena del grupo (1 = ZARA).
	private Long brandId;

//	START_DATE , END_DATE: rango de fechas en el que aplica el precio tarifa indicado.
	private Calendar startDate;

	private Calendar endDate;

//	PRICE_LIST: Identificador de la tarifa de precios aplicable.
	private Double priceList;

//	PRIORITY: Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor numérico).
	private Integer priority;

//	PRICE: precio final de venta.
	private Double price;

//	CURR: iso de la moneda.
	private String curr;
	
	
	
	
	

}
