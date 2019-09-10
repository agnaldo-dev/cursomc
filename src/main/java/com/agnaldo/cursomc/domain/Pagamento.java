package com.agnaldo.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Integer estado;
	
	@JoinColumn(name = "pedido_id")
	@OneToOne
	@MapsId
	private Pedido pedido;
	
	

}
