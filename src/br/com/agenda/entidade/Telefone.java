/*
 * @Autor: Ronan Almeida
 * @Email: ronan.ti@hotmail.com
 * 
 */

package br.com.agenda.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="telefone")
public class Telefone implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_telefone")
	private int idTelefone;
	
	private String numero;
	
	@ManyToOne
	@JoinColumn(name="fk_contato")
	private Contato contato;
	
	public Telefone(String numero, Contato contato){
		this.numero = numero;
		this.contato = contato;
	}
	
	
	public Telefone() {
		this.contato = new Contato();
	}
	
	public int getIdTelefone() {
		return idTelefone;
	}
	
	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Contato getContato() {
		return contato;
	}
	
	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		result = prime * result + idTelefone;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		if (contato == null) {
			if (other.contato != null)
				return false;
		} else if (!contato.equals(other.contato))
			return false;
		if (idTelefone != other.idTelefone)
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	
}
