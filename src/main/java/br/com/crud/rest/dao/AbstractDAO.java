package br.com.crud.rest.dao;

import br.com.crud.rest.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDAO<T> {

    private Class clazz;
    private Session session;

    public AbstractDAO(){
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    protected Session getSession(){
        if(this.session == null || !this.session.isOpen()){
            this.session = HibernateUtil.getSession();
        }
        return this.session;
    }
    public void insertOrUpdate(T t){
        getSession().beginTransaction();
        getSession().saveOrUpdate(t);
        getSession().close();
    }
    public void delete(T t){
        getSession().beginTransaction();
        getSession().delete(t);
        getSession().close();
    }
}
