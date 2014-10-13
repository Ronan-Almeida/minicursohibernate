package br.com.agenda.main;

import br.com.agenda.dao.ContatoDao;
import br.com.agenda.dao.ContatoDaoHibernate;

public class InformacoesDoContato {

	static void quebraLinha(){
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		
		/* Altere a propriedade
		 * <property name="hibernate.show_sql">true</property>)
		 * para
		 * <property name="hibernate.show_sql">false</property>)
		 * no arquivo hibernate.cfg.xml para o hibernate não mostrar o sql gerado
		 * assim facilida a leitura das informações no console
		 */
	
		ContatoDao contatoDao = new ContatoDaoHibernate();
		
		// listando os dados principais de um contato
		System.out.println("Nome: " + contatoDao.recuperarPeloId(1).getNome());
		System.out.println("Sexo: " + contatoDao.recuperarPeloId(1).getSexo());
		System.out.println("Nascimento: " + contatoDao.recuperarPeloId(1).getNascimento());
		System.out.println("Email: " + contatoDao.recuperarPeloId(1).getEmail());
		System.out.println("Status: " + (contatoDao.recuperarPeloId(1).getAtivo() ? "Ativo" : "Inativo"));

		quebraLinha();
		
		System.out.println("Endereco de "+contatoDao.recuperarPeloId(1).getNome());
		System.out.println(contatoDao.recuperarPeloId(1).getEndereco().getLogradouro()+" "+
				contatoDao.recuperarPeloId(1).getEndereco().getNumero());
		System.out.println(contatoDao.recuperarPeloId(1).getEndereco().getComplemento());
		System.out.println(contatoDao.recuperarPeloId(1).getEndereco().getBairro());
		System.out.println(contatoDao.recuperarPeloId(1).getEndereco().getCidade()+
				" - "+contatoDao.recuperarPeloId(1).getEndereco().getUf());
		quebraLinha();
		
		// listando o nome e o email de todos os contatos cadastrados
		for (int i = 0; i < contatoDao.listarTudo().size(); i++) {
			System.out.println("Nome: " + contatoDao.listarTudo().get(i).getNome());
			System.out.println("E-mail: " + contatoDao.listarTudo().get(i).getEmail());
		}
		
		quebraLinha();
		
		// listando o nome e os telefones de um contato
		System.out.println("Nome: " + contatoDao.recuperarPeloId(1).getNome());
		for (int i = 0; i < contatoDao.recuperarPeloId(1).getTelefones().size(); i++) {
			System.out.println("Telefone "+(i+1)+": " + contatoDao.recuperarPeloId(1).getTelefones().get(i).getNumero());
		}
		
		quebraLinha();
		
		// listando o nome e as especialidades de um contato
		System.out.println("Nome: " + contatoDao.recuperarPeloId(1).getNome());
		for (int i = 0; i < contatoDao.recuperarPeloId(1).getEspecialidades().size(); i++) {
			System.out.println("Especialidade "+(i+1)+": " + contatoDao.recuperarPeloId(1).getEspecialidades().get(i).getNome());
		}

	}

}
