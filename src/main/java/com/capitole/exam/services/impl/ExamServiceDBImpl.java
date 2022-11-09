package com.capitole.exam.services.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitole.exam.domain.ExamServiceDto;
import com.capitole.exam.repository.ExamRepository;
import com.capitole.exam.services.ExamServiceDB;


@Service
public class ExamServiceDBImpl implements ExamServiceDB {
	
	private final ExamRepository repository;
	
	@Autowired
	public ExamServiceDBImpl(ExamRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public ExamServiceDto findPvp(Calendar startDate, Calendar endDate, Long productId, Long brandId) {
		return (ExamServiceDto) repository.findAll();
		
	}








}
	