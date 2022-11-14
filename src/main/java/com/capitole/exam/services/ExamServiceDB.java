package com.capitole.exam.services;

import java.util.Date;

import com.capitole.exam.domain.PricesEntity;

public interface ExamServiceDB {

	/* Operaciones de BDD */

	public PricesEntity findPvp(Date start, Date end, Long productId, Long brandId);

}
