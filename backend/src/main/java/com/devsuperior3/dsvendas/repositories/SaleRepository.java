package com.devsuperior3.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior3.dsvendas.dto.SaleSuccessDto;
import com.devsuperior3.dsvendas.dto.SaleSumDto;
import com.devsuperior3.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("SELECT new com.devsuperior3.dsvendas.dto.SaleSumDto(obj.seller, SUM(obj.amount)) " 
			+ "FROM Sale AS obj GROUP BY obj.seller ")
	List<SaleSumDto> amountGroupedBySeller();
	
	@Query("SELECT new com.devsuperior3.dsvendas.dto.SaleSuccessDto(obj.seller, SUM(obj.visited), SUM(obj.deals)) " 
			+ "FROM Sale AS obj GROUP BY obj.seller ")
	List<SaleSuccessDto> successGroupedBySeller();
	
	
}
