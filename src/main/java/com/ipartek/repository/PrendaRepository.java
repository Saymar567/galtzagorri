package com.ipartek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipartek.model.Prenda;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Integer>{

}
