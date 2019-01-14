package br.com.fmchagas.loucademia.domain.aluno;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ALUNO")
public class Aluno implements Serializable {

	public enum Sexo {
		Masculino, Feminino;
	}
	
	public enum Situacao {
		Ativo, Inativo, Pendente;
	}
	
	private String matricula;
	private String nome;
	private Sexo sexo;
	private Integer rg;
	private LocalDate dataNascimento;
	private Situacao situacao;
	private String email;
	private Endereco endereco = new Endereco();
	private Telefone telefone = new Telefone();
	
	@Id
	@Column(name = "ID", nullable = false, length = 8)
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	@Column(name = "NOME", nullable = false, length = 64)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Enumerated (EnumType.ORDINAL)
	@Column(name = "SEXO", nullable = false, length = 1 )
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	@Column(name = "RG", nullable = false, length = 10)
	public Integer getRg() {
		return rg;
	}
	public void setRg(Integer rg) {
		this.rg = rg;
	}
	
	@Column(name = "NASCIMENTO", nullable = false)
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "SITUACAO", nullable = false, length=1)
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	@Column(name = "EMAIL", nullable = true, length = 64)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Embedded
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@Embedded
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aluno [matricula=");
		builder.append(matricula);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", sexo=");
		builder.append(sexo);
		builder.append(", rg=");
		builder.append(rg);
		builder.append(", dataNascimento=");
		builder.append(dataNascimento);
		builder.append(", situacao=");
		builder.append(situacao);
		builder.append(", email=");
		builder.append(email);
		builder.append(", endereco=");
		builder.append(endereco);
		builder.append(", telefone=");
		builder.append(telefone);
		builder.append("]");
		return builder.toString();
	}
	
}
