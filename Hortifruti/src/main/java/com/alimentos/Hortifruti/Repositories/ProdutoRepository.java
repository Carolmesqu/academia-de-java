package com.alimentos.Hortifruti.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alimentos.Hortifruti.Models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}

