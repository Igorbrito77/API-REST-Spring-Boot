package com.apirestbookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirestbookstore.models.Book;

//O JPA já tem métodos prontos para fazer persistências no bd.
//Criamos uma consulta usando a API de critérios JPA, 
//e isso se traduz numa consulta ao POstgreSQL (query):

public interface BookRepository extends JpaRepository<Book, Long>{
	
	Book findById(long id);
}
