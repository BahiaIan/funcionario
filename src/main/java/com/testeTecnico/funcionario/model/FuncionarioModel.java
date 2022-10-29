package com.testeTecnico.funcionario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class FuncionarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nome;
	private String sobrenome;
	private String email;
	private String nis;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNis() {
		return nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}

}
