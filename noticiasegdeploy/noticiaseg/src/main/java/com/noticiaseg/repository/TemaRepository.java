package com.noticiaseg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noticiaseg.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long> {
	
	public List<Tema> findAllByNomeContainingIgnoreCase( String nome);
	
}
