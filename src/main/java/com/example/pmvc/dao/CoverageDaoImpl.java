package com.example.pmvc.dao;

import com.example.pmvc.entity.Coverage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CoverageDaoImpl implements  CoverageDao{
    @Autowired
    private EntityManager entityManager;
    @Override
    public void insert(Coverage coverage) {
        entityManager.persist(coverage);
    }

    @Override
    public Coverage findbyid(int id) {
        return entityManager.find(Coverage.class,id);
    }

    @Override
    public Coverage update(Coverage coverage) {
        return entityManager.merge(coverage);
    }

    @Override
    public List<Coverage> findall() {
        TypedQuery<Coverage>typedQuery=entityManager.createQuery("from Coverage", Coverage.class);
        List<Coverage>list=typedQuery.getResultList();
        return list;
    }
}
