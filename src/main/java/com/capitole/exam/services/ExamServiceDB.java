package com.capitole.exam.services;

import java.util.Calendar;

import com.capitole.exam.domain.ExamServiceDto;

public interface ExamServiceDB {

    /*Operaciones de BDD*/
    
    
    ExamServiceDto findPvp(Calendar startDate, Calendar endDate, Long productId, Long brandId);



}
