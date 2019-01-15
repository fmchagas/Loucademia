package br.com.fmchagas.loucademia.interfaces.aluno.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.fmchagas.loucademia.application.service.AlunoService;
import br.com.fmchagas.loucademia.domain.aluno.Aluno;

@Named
@RequestScoped
public class AlunoBean implements Serializable{
	
	@EJB
	private AlunoService alunoService;
	
	private Aluno aluno = new Aluno();
	
	public String gravar() {
		//System.out.println("ALUNO ==>" + aluno);
		alunoService.createOrUpdate(aluno);
		return null;
	}

	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
