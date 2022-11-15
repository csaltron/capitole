package com.capitole.exam.domain;

import java.util.Date;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PricesDto {

	@Id
	private Long priceId;
	
//	PRODUCT_ID: Identificador código de producto.
	private Long productId;

//	BRAND_ID: foreign key de la cadena del grupo (1 = ZARA).
	private Long brandId;

//	START_DATE , END_DATE: rango de fechas en el que aplica el precio tarifa indicado.
	private Date startDate;

	private Date endDate;

//	PRICE_LIST: Identificador de la tarifa de precios aplicable.
	private Double priceList;

//	PRIORITY: Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor numérico).
	private Integer priority;

//	PRICE: precio final de venta.
	private Double price;

//	CURR: iso de la moneda.
	private String curr;

}
