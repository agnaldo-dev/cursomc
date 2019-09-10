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

	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer id, Integer estado, Pedido pedido,Date dataPagamento,Date dataVencimento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
		
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
}
