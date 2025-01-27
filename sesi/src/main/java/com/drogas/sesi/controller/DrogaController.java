package com.drogas.sesi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.drogas.sesi.dto.DrogasDto;
import com.drogas.sesi.model.DrogaModel;
import com.drogas.sesi.repository.DrogaRepository;

@RestController
@RequestMapping("/droga")
@CrossOrigin
public class DrogaController {

	@Autowired
	private DrogaRepository repo;

	@PostMapping
	public ResponseEntity<?> criar(@RequestBody DrogasDto d) {
		DrogaModel s = new DrogaModel(d);
		return ResponseEntity.ok(repo.save(s));
	}

	@GetMapping("/{id}")
	public Optional<DrogaModel> getDrogaById(@PathVariable Long id) {
		Optional<DrogaModel> usuario = repo.findById(id);
		return usuario;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUsuario(@PathVariable Long id) {
		repo.deleteById(id);
		return ResponseEntity.ok("Droga deletada");
	}

	@PutMapping("/{id}")
	public DrogaModel updateUsuario(Long id, DrogaModel usuarioAtualizado) {
		DrogaModel usuario = repo.findById(id).get(); // Obtém o usuário | busca se ja existe
		usuario.setNome(usuarioAtualizado.getNome());
		usuario.setPureza(usuarioAtualizado.getPureza());
		usuario.setQuantidade(usuarioAtualizado.getQuantidade());
		usuario.setLegalizada(usuarioAtualizado.getLegalizada());
		return usuario;
	}

	@GetMapping()
	public ResponseEntity<List<DrogaModel>> getAll() {
		return ResponseEntity.ok(repo.findAll());
	}
}