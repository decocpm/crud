package br.com.crud.rest.dao;

import br.com.crud.rest.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractDAO<PK extends Serializable, T> {

    private Class clazz;
    private Session session;

    public AbstractDAO(){
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    protected Session getSession(){
        if(this.session == null || !this.session.isOpen()){
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            this.session = sessionFactory.getCurrentSession();
        }
        return this.session;
    }

    protected T findById(PK id) throws Exception {
        Transaction transaction = null;

        Object object;

        try {
            transaction = getSession().beginTransaction();
            CriteriaBuilder cb = getSession().getCriteriaBuilder();
            object = getSession().get(this.clazz, id);
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Exceção capturada na transação:");
            e.printStackTrace(); //TODO log
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }

        return (T) object;
    }

    protected void saveOrUpdate(T entity) throws Exception{
        Transaction transaction = null;

        try {
            transaction = getSession().beginTransaction();
            getSession().saveOrUpdate(entity);
            transaction.commit();
            System.out.println("Transação executada com sucesso"); //TODO log
        } catch (Exception e) {
            System.err.println("Exceção captura na transação:");
            e.printStackTrace(); //TODO log
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            getSession().close();
        }
    }

    protected void delete(T entity) throws Exception {
        Transaction transaction = null;

        try {
            transaction = getSession().beginTransaction();
            getSession().delete(entity);
            transaction.commit();
            System.out.println("Transação executada com sucesso"); //TODO log
        } catch (Exception e) {
            System.err.println("Exceção capturada na transação:");
            e.printStackTrace(); //TODO log
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    protected List<T> list(CriteriaQuery query) throws Exception {
        Transaction transaction = null;

        List<T> resultList;

        try {
            transaction = getSession().beginTransaction();
            resultList = getSession().createQuery(query).getResultList();
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Exceção capturada na transação:");
            e.printStackTrace(); //TODO log
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }

        return resultList;
    }
}
