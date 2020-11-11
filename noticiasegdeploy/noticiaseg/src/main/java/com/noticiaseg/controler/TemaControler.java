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

import com.noticiaseg.model.Tema;
import com.noticiaseg.repository.TemaRepository;

@RestController
@RequestMapping ("/tema")
@CrossOrigin("*")
public class TemaControler {
	
	
		@Autowired
		private TemaRepository repository;

		@GetMapping
		public ResponseEntity <List<Tema>> ListarTema (){
				return ResponseEntity.ok(repository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Tema> ListarTemaPorId(@PathVariable long id) {
			return repository.findById(id) .map(resp -> ResponseEntity.ok(resp)). orElse (ResponseEntity.notFound() .build());
		}
			
		@PostMapping
		public ResponseEntity<Tema> incluirTema(@RequestBody Tema tema) {
				return ResponseEntity.status(HttpStatus.CREATED) .body(repository.save (tema));
		}
		@PutMapping
		public ResponseEntity<Tema> atualizarTema(@RequestBody Tema tema) {
				return ResponseEntity.status(HttpStatus.OK) .body(repository.save (tema));
		}
		@DeleteMapping("/{id}")
		public void deletarTema(@PathVariable long id) {
				repository.deleteById(id);
		}


	
	
}
