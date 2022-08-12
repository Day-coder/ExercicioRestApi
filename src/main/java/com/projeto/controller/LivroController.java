package com.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.entidade.Livro;
import com.projeto.repository.LivroRepository;

@RestController
@RequestMapping("/")
public class LivroController {
	
	@Autowired
	LivroRepository repository;
	
	@GetMapping("/livros")
	public ResponseEntity<List<Livro>> mostraTodosLivros(){
		List<Livro> livros= (List<Livro>) repository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(livros);	
	}
	
	@PostMapping("/livros")
	public ResponseEntity<Livro> salvaLivro(@RequestBody Livro livro){
		Livro livro1= repository.save(livro);
		return ResponseEntity.status(HttpStatus.CREATED).body(livro1);
	}
	
	@GetMapping("/livros/{idlivro}")
	public ResponseEntity<Livro> mostraUmLivro(@PathVariable("idlivro") Long idlivro){
		Optional<Livro> livro=repository.findById(idlivro);
		return ResponseEntity.ok(livro.get());
	}
	
	@PutMapping("/livros/{idlivro}")
	public ResponseEntity<Livro> atualizaLivro(@PathVariable("idlivro") Long idlivro,
			@RequestBody Livro livro){
		return ResponseEntity.ok(repository.save(livro));
	}
	
	@DeleteMapping("/livros/{idlivro}")
	public ResponseEntity<String> deletaLivro(@PathVariable("idlivro") Long idlivro){
		repository.deleteById(idlivro);
		return new ResponseEntity("Deletado com sucesso", HttpStatus.OK);
		
	}

}
