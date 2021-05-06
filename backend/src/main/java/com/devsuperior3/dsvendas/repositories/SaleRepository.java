package com.devsuperior3.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior3.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
