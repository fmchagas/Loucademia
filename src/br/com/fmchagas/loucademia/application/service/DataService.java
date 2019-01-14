package br.com.fmchagas.loucademia.application.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.fmchagas.loucademia.domain.aluno.Estado;
import br.com.fmchagas.loucademia.domain.aluno.EstadoRepository;
import br.com.fmchagas.loucademia.domain.aluno.Aluno.Sexo;
import br.com.fmchagas.loucademia.domain.aluno.Aluno.Situacao;

@Stateless
public class DataService {

	@EJB
	private EstadoRepository estadoRepository;
	
	public List<Estado> listEstados(){
		return estadoRepository.listEstados();
	}
	
	public Sexo[] getSexos() {
		return Sexo.values();
	}
	
	public Situacao[] getSituacoes() {
		return Situacao.values();
	}
}