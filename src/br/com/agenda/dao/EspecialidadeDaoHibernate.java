
package br.com.agenda.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.agenda.entidade.Especialidade;
import br.com.agenda.util.HibernateUtil;

public class EspecialidadeDaoHibernate implements EspecialidadeDao {

    public void salvar(Especialidade especialidade) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(especialidade);
        t.commit();
        session.close(); 
    }
    
    public void atualizar(Especialidade especialidade) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(especialidade);
        t.commit();
        session.close(); 
    }
    
    public Especialidade recuperarPeloId(int idEspecialidade) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Especialidade) session.load(Especialidade.class, idEspecialidade);
    }
    
    public List<Especialidade> listarTudo() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Especialidade> lista = session.createQuery("from Especialidade").list();
        t.commit();
        session.close(); 
        return lista;        
    }
    
    public void excluir(Especialidade especialidade) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(especialidade);
        t.commit();
        session.close(); 
    }

}
