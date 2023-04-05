package com.generation.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.blogpessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		
		usuarioRepository.deleteAll();
		
		usuarioRepository.save(new Usuario(0L, "João da Silva", "joao@gmail.com.br", "987456321", "https://i.imgur.com/FETvs20.jpg"));
		
		usuarioRepository.save(new Usuario(0L, "Munuela de Sousa", "munuela@gmail.com.br", "541297836", "https://i.imgur.com/NtyGneo.jpg"));
		
		usuarioRepository.save(new Usuario(0L, "Adriana de Oliveira", "adriana@gmail.com.br", "987420091", "https://i.imgur.com/mB3VM2N.jpg"));
		
		usuarioRepository.save(new Usuario(0L, "Paula Fernandes", "fernandes@gmail.com.br", "31209781641", "https://i.imgur.com/jr7KUFU.jpg"));
	}
	
	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRernarUmUsuario() {
		
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("joao@gmail.com.br");
		assertTrue(usuario.get().getUsuario().equals("joao@gmail.com"));
		
	}
	
	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRernarTresUsuarios() {
		
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(3, listaDeUsuarios.size());
		
		assertTrue(listaDeUsuarios.get(0).getNome().equals("João da Silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Manuela da Silva"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Adriana da Silva"));
		
	}
	
	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}
	
}