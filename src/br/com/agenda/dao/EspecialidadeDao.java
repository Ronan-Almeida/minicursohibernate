package br.com.agenda.dao;

import java.util.List;

import br.com.agenda.entidade.Especialidade;

public interface EspecialidadeDao {

	public void salvar(Especialidade especialidade) throws Exception;
	public void atualizar(Especialidade especialidade) throws Exception;
	public void excluir(Especialidade especialidade) throws Exception;
	
	public Especialidade recuperarPeloId(int id);
	public List<Especialidade> listarTudo();
	
}
