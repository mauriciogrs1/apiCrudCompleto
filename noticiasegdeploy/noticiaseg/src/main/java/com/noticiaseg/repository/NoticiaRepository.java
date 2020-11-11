package com.noticiaseg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noticiaseg.model.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Long>  {

}
