package com.noticiaseg.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noticiaseg.model.Noticia;
import com.noticiaseg.repository.NoticiaRepository;


@RestController
@RequestMapping ("/noticia")
@CrossOrigin("*")
public class NoticiaController {
	@Autowired
	private NoticiaRepository repository;

	@GetMapping
	public ResponseEntity <List<Noticia>> ListarNoticia (){
			return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Noticia> ListarNoticiaPorId(@PathVariable long id) {
		return repository.findById(id) .map(resp -> ResponseEntity.ok(resp)). orElse (ResponseEntity.notFound() .build());
	}
		
	@PostMapping
	public ResponseEntity<Noticia> incluirNoticia(@RequestBody Noticia noticia) {
			return ResponseEntity.status(HttpStatus.CREATED) .body(repository.save (noticia));
	}
	@PutMapping
	public ResponseEntity<Noticia> atualizarNoticia(@RequestBody Noticia noticia) {
			return ResponseEntity.status(HttpStatus.OK) .body(repository.save (noticia));
	}
	@DeleteMapping("/{id}")
	public void deletarNoticia(@PathVariable long id) {
			repository.deleteById(id);
	}




}
