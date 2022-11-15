package com.capitole.exam.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.capitole.exam.domain.PricesDto;
import com.capitole.exam.domain.PricesEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PricesMapper {
	

	PricesDto priceDbToPricesDto(final PricesEntity prices);
}
