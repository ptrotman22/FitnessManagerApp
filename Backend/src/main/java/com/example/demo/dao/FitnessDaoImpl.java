package com.example.demo.dao;

import com.example.demo.entity.Fitness;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class FitnessDaoImpl implements FitnessDAO {

    private EntityManager entityManager;

    @Autowired
    public FitnessDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Fitness> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Fitness> myQuery = currentSession.createQuery("from account");
        List<Fitness> theFitness = myQuery.getResultList();
        return theFitness;
    }

    @Override
    @Transactional
    public Fitness findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Fitness theFitness = currentSession.get(Fitness.class, theId);
        return theFitness;
    }

    @Override
    @Transactional
    public Fitness findInfoByEmail(String username){
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Fitness> theQuery = currentSession.createQuery("FROM account WHERE username=:username");
        theQuery.setParameter("username", username);
        List<Fitness> temp = theQuery.getResultList();
        return temp.get(0);
    }

    @Override
    @Transactional
    public void save(Fitness theFitness) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theFitness);

    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Fitness> theQuery = currentSession.createQuery("delete from account where id=:ID");
        theQuery.setParameter("ID", theId);
        theQuery.executeUpdate();
    }
}
