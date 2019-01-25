package br.com.fmchagas.loucademia.interfaces.relatorio.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ValidationException;

import br.com.fmchagas.loucademia.application.service.AlunoService;
import br.com.fmchagas.loucademia.domain.aluno.Aluno;
import br.com.fmchagas.loucademia.domain.aluno.Aluno.Situacao;

@Named
@ViewScoped
public class RelatorioSituacoesBean implements Serializable {

	@EJB
	private AlunoService alunoService;
	
	@Inject
	private FacesContext facesContext;
	
	private Situacao situacao;
	
	private List<Aluno> alunos;
	

	public String gerarRelatorio() {		
		try {
			this.alunos = this.alunoService.listSituacoesAlunos(this.situacao);
			
		} catch (ValidationException e) {
			facesContext.addMessage(null, new FacesMessage(e.getMessage()));
		}
		
		return null;
	}
	
	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
}
