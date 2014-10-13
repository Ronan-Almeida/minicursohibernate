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
import javax.persistence.Table;

@Entity
@Table(name="especialidade")
public class Especialidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_especialidade")
	private int idEspecialidade;
	private String nome;
	private String detalhes;
	
	public int getIdEspecialidade() {
		return idEspecialidade;
	}
	
	public void setIdEspecialidade(int idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDetalhes() {
		return detalhes;
	}
	
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((detalhes == null) ? 0 : detalhes.hashCode());
		result = prime * result + idEspecialidade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Especialidade other = (Especialidade) obj;
		if (detalhes == null) {
			if (other.detalhes != null)
				return false;
		} else if (!detalhes.equals(other.detalhes))
			return false;
		if (idEspecialidade != other.idEspecialidade)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
		
}
