package br.com.fmchagas.loucademia.application.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.fmchagas.loucademia.application.util.StringUtils;
import br.com.fmchagas.loucademia.application.util.Validation;
import br.com.fmchagas.loucademia.application.util.ValidationException;
import br.com.fmchagas.loucademia.domain.aluno.Aluno;
import br.com.fmchagas.loucademia.domain.aluno.AlunoRepository;
import br.com.fmchagas.loucademia.domain.aluno.Aluno.Situacao;

@Stateless
public class AlunoService {

	@EJB
	private AlunoRepository alunoRepository;
	

	public void createOrUpdate(Aluno aluno) {
		if (StringUtils.isEmpty(aluno.getMatricula())) {
			create(aluno);
		} else {
			update(aluno);
		}
	}

	private void create(Aluno aluno) {
		Validation.assertNotEmpty(aluno);
		
		String maxMatricula = alunoRepository.getMaxMatriculaAno();
		aluno.gerarMatricula(maxMatricula);
		
		//TODO implementar regra de negocio, para validar unico rg
		
		alunoRepository.store(aluno);
	}

	private void update(Aluno aluno) {
		Validation.assertNotEmpty(aluno);
		Validation.assertNotEmpty(aluno.getMatricula());
		
		alunoRepository.update(aluno);
	}

	public Aluno findByMatricula(String matricula) {
		return alunoRepository.findByMatricula(matricula);
	}
	
	public List<Aluno> listAlunos(String matricula, String nome, Integer rg, Integer telefone){
		if (StringUtils.isEmpty(matricula) && StringUtils.isEmpty(nome) && rg == null && telefone == null)  {
			throw new ValidationException("Pelo menos um critério de pesquisa deve ser fornecido");
		}
		
		return alunoRepository.listAlunos(matricula, nome, rg, telefone);
	}

	public void delete(String matricula) {
		alunoRepository.delete(matricula);
	}
	
	public List<Aluno> listSituacoesAlunos(Situacao situacao){
		Validation.assertNotEmpty(situacao);
		
		return alunoRepository.listSituacoesAlunos(situacao);
	}

}
