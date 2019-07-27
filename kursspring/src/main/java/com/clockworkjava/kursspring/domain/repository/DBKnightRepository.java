package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

//@Repository  nie może być, bo już jest w MainConfig

public class DBKnightRepository implements KnightRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void createKnight(String name, int age){
        Knight knight = new Knight(name, age);
        em.persist(knight);
    }

    @Override
    @Transactional
    public void createKnight(Knight knight){
        em.persist(knight);
    }

    @Override
    public Collection<Knight> getAllKnights(){
        List<Knight> allKnights = em.createQuery("from Knight", Knight.class).getResultList();
        return allKnights;
    }

    @Override
    public Optional<Knight> getKnight(String name){
//        Knight knightByName = em.createQuery("from Knight k where k.name = :name", Knight.class)
//                .setParameter("name", name).getSingleResult();
        List result = em.createQuery("from Knight where name = :name", Knight.class)
                .setParameter("name", name)
                .getResultList();
        if(!result.isEmpty()){
            Optional.ofNullable(result.get(0));
        }
        return Optional.empty();
    }

    @Override
    public Knight getKnightById(Integer id){
        return em.find(Knight.class, id);
    }

    @Override
    @Transactional
    public void updateKnight(Knight knight){
        em.merge(knight);
    }

    @Override
    @Transactional
    public void deleteKnight(Integer id){
        em.remove(id);
    }

}
