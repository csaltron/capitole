package com.capitole.exam.services.impl;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitole.exam.domain.PricesEntity;
import com.capitole.exam.repository.ExamRepository;
import com.capitole.exam.services.ExamServiceDB;


@Service
public class ExamServiceDBImpl implements ExamServiceDB {

	@Autowired
	private ExamRepository repository;

	@Override
	public PricesEntity findPvp(Date startDate, Date endDate, Long productId, Long brandId) {
		List<PricesEntity> items = repository.findPvp(startDate, endDate, productId, brandId);

		Optional<PricesEntity> maxPvp = items.stream().max(Comparator.comparing(PricesEntity::getPriority));

		PricesEntity pvp = maxPvp.get();

		return pvp;

	}

}
