package com.apirestbookstore.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestbookstore.models.Book;
import com.apirestbookstore.repository.BookRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value=" API REST Livros")
@CrossOrigin(origins= "*")

public class BookResource {
	
	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("/livros")
	@ApiOperation(value= "Retorna lista de livros.")
	public List<Book> listBooks(){
		return bookRepository.findAll();
	}
	
	@GetMapping("/livro/{id}")
	@ApiOperation(value= "Retorna um livro único.")
	public Book listBook(@PathVariable(value= "id") long id) {
		return bookRepository.findById(id);
	}
	
	@PostMapping("/livro")
	@ApiOperation(value= "Salva um livro")
	public Book saveBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	@DeleteMapping("/livro")
	@ApiOperation(value= "Exclui um livro.")
	public void deleteBook(@RequestBody Book book) {
		bookRepository.delete(book);
	}
	
	@PutMapping("/livro")
	@ApiOperation(value= "Atualiza um livro..")
	public Book updateBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
}
