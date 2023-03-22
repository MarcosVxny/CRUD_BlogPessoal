package com.generation.blogpessoal.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoal.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{

    //findAllByTituloContainingIgnoreCase() com a função de trazer todas as  Postagens cujo título possua a palavra pesquisada.
	public List <Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);

	public Optional <Postagem> findByTitulo(String titulo);
	
	
	
	
		
	



}
