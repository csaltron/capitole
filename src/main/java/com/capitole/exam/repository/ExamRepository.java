package com.capitole.exam.repository;


import org.springframework.data.repository.CrudRepository;

import com.capitole.exam.domain.ExamServiceDto;

public interface ExamRepository extends CrudRepository<ExamServiceDto,Long>{
	
}
