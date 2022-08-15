package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projeto.entidade.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
