/*
 * @Autor: Ronan Almeida
 * @Email: ronan.ti@hotmail.com
 * 
 */

package br.com.agenda.entidade;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 *  Essas anotacoes devem serem importadsa do pacote javax.persistence.Entity;
 *  
 * @Entity - Informamos ao hibernate que esta classe representa uma entidade
 *
 * @Table(name="contato") - informamos ao hibernate o nome da tabela no banco que
 * representa essa entidade. So e obrigatoria quando o nome da classe for diferente
 * do nome da tabela no banco. Observe que ele diferencia letras Maiusculas de
 * Minusculas, portanto Contato != contato
 * 
 * @Id - estamos informando que o campo representa a chave primaria na tabela
 * 
 * @GeneratedValue(strategy = GenerationType.AUTO) - estamos informando que a
 * chave primaria sera incrementada automaticamente. Por padrao a strategy e AUTO
 * portanto se informar apenas @GeneratedValue e o banco possuir o recurso
 * de auto increment ira funcionar.
 * 
 * @Column(name="id_contato") - Essa anotacao so e obrigatoria se o nome do
 * campo no banco for diferente do nome do atributo na classe
 * 
 * @Temporal(TemporalType.TIMESTAMP) - Usado para mapear campos referentes ao tempo
 *  		 TemporalType.DATE - para campos de data ex. tipo date no banco
 * 			 TemporalType.TIMESTAMP - para campos de data e hora ex. tipo timestamp ou datetime no banco
 * 
 * 
 * Estudem os outros parametros dessas anotacoes pois existem varios,
 * estou explicando aqui somente os que precisamos usar para esta aplicacao!
 * 
 */

@Entity
@Table(name="contato")
public class Contato implements Serializable {
	
	// implementamos a Serializable para tornar a nossa entidade Serializavel

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_contato")
	private int idContato;
	
	private String nome;
	private String sexo;
	
	@Temporal(TemporalType.DATE) // Anotacao usada para mapear campos de data
	private Date nascimento;
	
	private String email;
	private Boolean ativo;
	
	@Column(name="data_cadastro")
	@Temporal(TemporalType.TIMESTAMP) // data e hora
	private Calendar dataCadastro;
	
	@Column(name="data_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataUpdate;
	
	// relacionamento 1 pra 1
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_endereco")
	private Endereco endereco;
	
	// relacionamento N pra N
	@ManyToMany
    @JoinTable(name="contato_especialidade",
    joinColumns={@JoinColumn(name="fk_contato")},
    inverseJoinColumns={@JoinColumn(name="fk_especialidade")})
    private List<Especialidade> especialidades;
	
	// relacionamento 1 pra N
	@OneToMany(mappedBy = "contato", targetEntity = Telefone.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Telefone> telefones;
	
	public Contato(){
		this.endereco = new Endereco();
		this.nascimento = Calendar.getInstance().getTime();
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public int getIdContato() {
		return idContato;
	}

	public void setIdContato(int idContato) {
		this.idContato = idContato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Calendar getDataUpdate() {
		return dataUpdate;
	}

	public void setDataUpdate(Calendar dataUpdate) {
		this.dataUpdate = dataUpdate;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result
				+ ((dataUpdate == null) ? 0 : dataUpdate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result
				+ ((especialidades == null) ? 0 : especialidades.hashCode());
		result = prime * result + idContato;
		result = prime * result
				+ ((nascimento == null) ? 0 : nascimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Contato other = (Contato) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (dataUpdate == null) {
			if (other.dataUpdate != null)
				return false;
		} else if (!dataUpdate.equals(other.dataUpdate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (especialidades == null) {
			if (other.especialidades != null)
				return false;
		} else if (!especialidades.equals(other.especialidades))
			return false;
		if (idContato != other.idContato)
			return false;
		if (nascimento == null) {
			if (other.nascimento != null)
				return false;
		} else if (!nascimento.equals(other.nascimento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}
	
	
}
