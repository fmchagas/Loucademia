package br.com.fmchagas.loucademia.application.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.ValidationException;

import br.com.fmchagas.loucademia.application.util.StringUtils;
import br.com.fmchagas.loucademia.domain.acesso.AcessoRepository;
import br.com.fmchagas.loucademia.domain.acesso.TipoAcesso;
import br.com.fmchagas.loucademia.domain.aluno.Aluno;
import br.com.fmchagas.loucademia.domain.aluno.AlunoRepository;

@Stateless
public class AcessoService {

	@EJB
	private AcessoRepository acessoRepository;
	
	@EJB
	private AlunoRepository alunoRepository;

	public TipoAcesso registrar(String matricula, Integer rg) {
		if (StringUtils.isEmpty(matricula) && rg ==null) {
			throw new ValidationException("É preciso fornecer a matrícula ou o RG.");
		}
		
		Aluno aluno;
		if (StringUtils.isEmpty(matricula)) {
			aluno = alunoRepository.findByRG(rg);
		}else {
			aluno =  alunoRepository.findByMatricula(matricula);
		}
		
		if (aluno == null) {
			throw new ValidationException("O aluno não foi encontrado.");
		}
		
		
		
		return null;
	}
	
	
}
