package com.testeTecnico.funcionario.repository;

import org.springframework.data.repository.CrudRepository;

import com.testeTecnico.funcionario.model.FuncionarioModel;

public interface FuncionarioRepository extends CrudRepository<FuncionarioModel, Long> {

}
