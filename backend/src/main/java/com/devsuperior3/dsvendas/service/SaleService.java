package com.devsuperior3.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior3.dsvendas.dto.SaleDto;
import com.devsuperior3.dsvendas.dto.SaleSuccessDto;
import com.devsuperior3.dsvendas.dto.SaleSumDto;
import com.devsuperior3.dsvendas.entities.Sale;
import com.devsuperior3.dsvendas.repositories.SaleRepository;
import com.devsuperior3.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDto> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = saleRepository.findAll(pageable);
		return result.map(x -> new SaleDto(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDto> amountGroupedBySeller(){
		return saleRepository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDto> successGroupedBySeller(){
		return saleRepository.successGroupedBySeller();
	}
	
}
