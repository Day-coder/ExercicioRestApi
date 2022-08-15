package com.projeto.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.entidade.Livro;
import com.projeto.repository.LivroRepository;

@Service
public class LivroService {
	@Autowired
	LivroRepository repository;
	
	public Livro salvar(Livro livro) {
		return repository.save(livro);
	}
	
	public List<Livro> mostrarLivros(){
		List<Livro> livros= repository.findAll();
		return livros;
		
	}
	
	public Livro mostrarUmLivro(Long idlivro) {
		Optional<Livro> opLivro= repository.findById(idlivro);
		Livro livro= opLivro.orElseThrow(()-> new EntityNotFoundException("Livro não encontrado"));
		return livro;
		
	}
	
	public void deletarLivro(Long idlivro) {
		repository.deleteById(idlivro);
	}
	
	public Livro atualizarLivro(Long idlivro, Livro livro) {
		Livro livro1= mostrarUmLivro(idlivro);
		livro1.setAutor(livro.getAutor());
		livro1.setTitulo(livro.getTitulo());
		livro1.setEditora(livro.getEditora());
		livro1.setAnoPublicacao(livro.getAnoPublicacao());
		livro1.setVolume(livro.getVolume());
		return repository.save(livro1);
	}
}
