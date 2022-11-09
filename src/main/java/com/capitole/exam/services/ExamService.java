package com.capitole.exam.services;

import java.util.Calendar;

import com.capitole.exam.domain.ExamServiceDto;

public interface ExamService {

    ExamServiceDto consultar(Long id);
    
    ExamServiceDto consultarPvp(Calendar start, Calendar end, Long productId, Long brandId);
    
    

}
