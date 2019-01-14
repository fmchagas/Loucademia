package br.com.fmchagas.loucademia.domain.aluno;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Telefone implements Serializable {

	private Integer dddCelular;
	private Integer numeroCelular;
	private Integer dddFixo;
	private Integer numeroFixo;
	
	@Column(name = "CELULAR_DDD", nullable = false, length = 2)
	public Integer getDddCelular() {
		return dddCelular;
	}
	public void setDddCelular(Integer dddCelular) {
		this.dddCelular = dddCelular;
	}
	
	@Column(name = "CELULAR_NUMERO", nullable = false, length = 9)
	public Integer getNumeroCelular() {
		return numeroCelular;
	}
	public void setNumeroCelular(Integer numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	
	@Column(name = "FIXO_DDD", nullable = true, length = 2)
	public Integer getDddFixo() {
		return dddFixo;
	}
	public void setDddFixo(Integer dddFixo) {
		this.dddFixo = dddFixo;
	}
	
	@Column(name = "FIXO_NUMERO", nullable = true, length = 8)
	public Integer getNumeroFixo() {
		return numeroFixo;
	}
	public void setNumeroFixo(Integer numeroFixo) {
		this.numeroFixo = numeroFixo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dddCelular == null) ? 0 : dddCelular.hashCode());
		result = prime * result + ((dddFixo == null) ? 0 : dddFixo.hashCode());
		result = prime * result + ((numeroCelular == null) ? 0 : numeroCelular.hashCode());
		result = prime * result + ((numeroFixo == null) ? 0 : numeroFixo.hashCode());
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
		Telefone other = (Telefone) obj;
		if (dddCelular == null) {
			if (other.dddCelular != null)
				return false;
		} else if (!dddCelular.equals(other.dddCelular))
			return false;
		if (dddFixo == null) {
			if (other.dddFixo != null)
				return false;
		} else if (!dddFixo.equals(other.dddFixo))
			return false;
		if (numeroCelular == null) {
			if (other.numeroCelular != null)
				return false;
		} else if (!numeroCelular.equals(other.numeroCelular))
			return false;
		if (numeroFixo == null) {
			if (other.numeroFixo != null)
				return false;
		} else if (!numeroFixo.equals(other.numeroFixo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Telefone [dddCelular=");
		builder.append(dddCelular);
		builder.append(", numeroCelular=");
		builder.append(numeroCelular);
		builder.append(", dddFixo=");
		builder.append(dddFixo);
		builder.append(", numeroFixo=");
		builder.append(numeroFixo);
		builder.append("]");
		return builder.toString();
	}
	
	
}
