package com.example.pmvc.dao;

import com.example.pmvc.entity.Policy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PolicyDaoImpl implements PolicyDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public void insert(Policy policy) {
        entityManager.persist(policy);
    }

    @Override
    public Policy update(Policy policy) {
        return entityManager.merge(policy);
    }

    @Override
    public Policy findbyid(int id) {
        return entityManager.find(Policy.class, id);
    }

    @Override
    public void delete(int id) {
        Policy policy = entityManager.find(Policy.class, id);
        entityManager.remove(policy);
    }

    @Override
    public List<Policy> findall() {
        TypedQuery<Policy> typedQuery = entityManager.createQuery("from Policy", Policy.class);
        List<Policy> list = typedQuery.getResultList();
        return list;
    }
}
