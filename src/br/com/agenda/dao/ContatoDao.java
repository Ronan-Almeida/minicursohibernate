package br.com.agenda.dao;

import java.util.List;

import br.com.agenda.entidade.Contato;

public interface ContatoDao {
	
	public void salvar(Contato contato) throws Exception;
	public void atualizar(Contato contato) throws Exception;
	public void excluir(Contato contato) throws Exception;
	
	public Contato recuperarPeloId(int id);
	
	public List<Contato> listarTudo();
	
}
