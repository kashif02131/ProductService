package com.kashif.ticket.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kashif.ticket.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
