package com.agnaldo.cursomc.domain;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento {

	private static final long serialVersionUID = 1L;

	
	private Integer numeroDeParcelas;

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

}
