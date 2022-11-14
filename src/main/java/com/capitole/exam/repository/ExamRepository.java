package com.capitole.exam.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capitole.exam.domain.PricesEntity;

public interface ExamRepository extends JpaRepository<PricesEntity, Long> {

	List<PricesEntity> findAll();

	@Query("SELECT T FROM PricesEntity T WHERE (:string BETWEEN startDate AND endDate) "
			+ "OR (:string2 BETWEEN startDate AND endDate) AND productId = :productId AND brandId = :brandId")
	List<PricesEntity> findPvp(@Param("string") Date string, @Param("string2") Date string2,
			@Param("productId") Long productId, @Param("brandId") Long brandId);

}
