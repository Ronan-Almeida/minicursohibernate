
package br.com.agenda.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.agenda.entidade.Contato;
import br.com.agenda.util.HibernateUtil;

public class ContatoDaoHibernate implements ContatoDao {

    public void salvar(Contato contato) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(contato);
        t.commit();
        session.close(); 
    }
    
    public void atualizar(Contato contato) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(contato);
        t.commit();
        session.close(); 
    }
    
    public Contato recuperarPeloId(int idContato) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Contato) session.load(Contato.class, idContato);
    }
    
    public List<Contato> listarTudo() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Contato> lista = session.createQuery("from Contato").list();
        t.commit();
        session.close(); 
        return lista;        
    }
    
    public void excluir(Contato contato) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(contato);
        t.commit();
        session.close(); 
    }

}
