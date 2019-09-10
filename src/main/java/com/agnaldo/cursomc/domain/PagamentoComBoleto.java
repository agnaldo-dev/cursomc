package com.agnaldo.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PagamentoComBoleto extends Pagamento {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date dataVencimento; 
	
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;
	
	
}
