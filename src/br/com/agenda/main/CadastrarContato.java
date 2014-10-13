package br.com.agenda.main;

import java.util.ArrayList;
import java.util.Calendar;
import br.com.agenda.dao.ContatoDao;
import br.com.agenda.dao.ContatoDaoHibernate;
import br.com.agenda.dao.EspecialidadeDao;
import br.com.agenda.dao.EspecialidadeDaoHibernate;
import br.com.agenda.entidade.Contato;
import br.com.agenda.entidade.Endereco;
import br.com.agenda.entidade.Especialidade;
import br.com.agenda.entidade.Telefone;

public class CadastrarContato {

	public static void main(String[] args) throws Exception {

		ArrayList<Especialidade> especialidades = new ArrayList<Especialidade>();
		EspecialidadeDao especDao = new EspecialidadeDaoHibernate();
		
		// cadastre as especialidades antes para poder recuperalas
		especialidades.add(especDao.recuperarPeloId(1));
		especialidades.add(especDao.recuperarPeloId(2));
		especialidades.add(especDao.recuperarPeloId(3));

		Endereco endereco = new Endereco();
		endereco.setBairro("Centro");
		endereco.setCep("56306-290");
		endereco.setCidade("Petrolina");
		endereco.setComplemento("Apt. 102-B");
		endereco.setLogradouro("Rua João Zito de Barros");
		endereco.setNumero("100");
		endereco.setUf("PE");

		Contato contato = new Contato();
		contato.setAtivo(true);
		
		// campo com restrinção unique no banco (não aceita valores iguais)
		contato.setEmail("ronan.ti@hotmail.com");
		
		contato.setNome("Ronan Almeida");
		contato.setSexo("Masculino");

		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(1989, Calendar.JULY, 04);

		contato.setNascimento(dataNascimento.getTime());
		contato.setEndereco(endereco);
		contato.setEspecialidades(especialidades);

		ArrayList<Telefone> telefones = new ArrayList<Telefone>();
		telefones.add(new Telefone("(74) 8837-3268", contato));
		telefones.add(new Telefone("(87) 9939-3467", contato));
		telefones.add(new Telefone("(89) 8104-5354", contato));

		contato.setTelefones(telefones);

		ContatoDao contatoDao = new ContatoDaoHibernate();
		contatoDao.salvar(contato);

	}

}
