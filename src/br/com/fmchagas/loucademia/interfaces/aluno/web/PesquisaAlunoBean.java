package br.com.fmchagas.loucademia.interfaces.aluno.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.fmchagas.loucademia.application.service.AlunoService;
import br.com.fmchagas.loucademia.domain.aluno.Aluno;

@Named
@ViewScoped
public class PesquisaAlunoBean implements Serializable {
	
	@EJB
	private AlunoService alunoService;
	
	private String matricula;
	private String nome;
	private String rg;
	private String telefone;
	
	private List<Aluno> alunos;
	
	public String pesquisar() {
		alunos = alunoService.listAlunos(matricula, nome, rg, telefone);
		return null;
	}
	
	public String excluir(String matricula) {
		System.out.println(matricula);
		
		alunoService.delete(matricula);
		
		return pesquisar();
	}
	
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public List<Aluno> getAlunos() {
		return alunos;
	}
	
}
