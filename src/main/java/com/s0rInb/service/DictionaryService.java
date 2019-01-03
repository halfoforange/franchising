package com.s0rInb.service;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.s0rInb.entity.dictionary.Dictionary;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("dictionaryService")
@Transactional
public class DictionaryService {
    private String SELECT_FROM = "SELECT d from ";
    private String WHERE_NAME = " d WHERE lower(d.name) LIKE :q ORDER BY d.name asc";
    private String WHERE_ID = " d WHERE d.id =:id";
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public Dictionary findById(String dictionaryEntity, Long id) {
        Query query = em.createQuery(SELECT_FROM + dictionaryEntity + WHERE_ID);
        query.setParameter("id", id);
        return (Dictionary) query.getSingleResult();
    }

    @Transactional(readOnly = true)
    public List<Dictionary> search(String dictionaryEntity, String q) {
        Query query = em.createQuery(SELECT_FROM + dictionaryEntity + WHERE_NAME);
        query.setParameter("q", "%" + q + "%");
        return query.getResultList();
    }
}
