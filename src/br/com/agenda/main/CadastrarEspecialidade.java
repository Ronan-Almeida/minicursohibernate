package br.com.agenda.main;

import br.com.agenda.dao.EspecialidadeDao;
import br.com.agenda.dao.EspecialidadeDaoHibernate;
import br.com.agenda.entidade.Especialidade;

public class CadastrarEspecialidade {

	public static void main(String[] args) throws Exception {
		
		/* O campo nome da especialidade no banco está com
		 * restrinção unique ou seja não aceita valores iguais
		 */

		Especialidade especialidade1 = new Especialidade();
		especialidade1.setNome("Banco de dados Oracle");
		especialidade1.setDetalhes("Conhece tudo de banco de dados oracle");

		Especialidade especialidade2 = new Especialidade();
		especialidade2.setNome("Banco de dados SQL Server");
		especialidade2.setDetalhes("Conhece tudo de banco de dados SQL Server");

		Especialidade especialidade3 = new Especialidade();
		especialidade3.setNome("Banco de dados PostgreSQL");
		especialidade3.setDetalhes("Conhece tudo de banco de dados PostgreSQL");

		Especialidade especialidade4 = new Especialidade();
		especialidade4.setNome("Banco de dados MySQL");
		especialidade4.setDetalhes("Conhece tudo de banco de dados MySQL");

		EspecialidadeDao especDao = new EspecialidadeDaoHibernate();
		especDao.salvar(especialidade1);
		especDao.salvar(especialidade2);
		especDao.salvar(especialidade3);
		especDao.salvar(especialidade4);

	}

}
