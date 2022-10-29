package com.testeTecnico.funcionario.controller;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testeTecnico.funcionario.model.FuncionarioModel;
import com.testeTecnico.funcionario.repository.FuncionarioRepository;

@RestController
@RequestMapping("/api/funcionario")
@CrossOrigin(origins = "*")
public class FuncionarioController {

	public final String emailPattern = "^(.+)@(\\S+)$";
	public final String digitsPattern = "\"[0-9]+\"";

	@Autowired
	private FuncionarioRepository repository;

	@GetMapping
	public List<FuncionarioModel> getAll() {
		return (List<FuncionarioModel>) repository.findAll();
	}

	@GetMapping("/{idFuncionario}")
	public ResponseEntity<FuncionarioModel> getById(@PathVariable(value = "idFuncionario") Long idFuncionario) {
		Optional<FuncionarioModel> funcionario = repository.findById(idFuncionario);

		if (funcionario.isPresent()) {
			return ResponseEntity.ok().body(funcionario.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<FuncionarioModel> persist(@Validated @RequestBody FuncionarioModel funcionario)
			throws Exception {
		if (!patternMatches(funcionario.getEmail(), emailPattern)
				|| !patternMatches(funcionario.getNis(), digitsPattern)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().body(repository.save(funcionario));
	}

	@PutMapping
	public FuncionarioModel edit(@Validated @RequestBody FuncionarioModel funcionario) {
		return repository.save(funcionario);
	}

	@DeleteMapping("/{idFuncionario}")
	public ResponseEntity<FuncionarioModel> deleteById(@PathVariable(value = "idFuncionario") Long idFuncionario) {
		repository.deleteById(idFuncionario);
		return ResponseEntity.noContent().build();

	}

	public static boolean patternMatches(String data, String regexPattern) {
		return Pattern.compile(regexPattern).matcher(data).matches();
	}

}
