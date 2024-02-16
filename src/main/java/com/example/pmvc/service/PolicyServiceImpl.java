package com.example.pmvc.service;

import com.example.pmvc.dao.CoverageDaoImpl;
import com.example.pmvc.dao.PolicyDaoImpl;
import com.example.pmvc.entity.Coverage;
import com.example.pmvc.entity.Policy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    PolicyDaoImpl policyDao;
    @Autowired
    CoverageDaoImpl coverageDao;

    @Transactional
    @Override
    public void insert(Policy policy) {
        policyDao.insert(policy);
    }

    @Transactional
    @Override
    public Policy update(Policy policy) {
        return policyDao.update(policy);
    }

    @Override
    public Policy findid(int id) {
        return policyDao.findbyid(id);
    }

    @Transactional
    @Override
    public void delete(int id) {
        policyDao.delete(id);
    }

    @Override
    public List<Policy> findpolicy() {
        return policyDao.findall();
    }

    @Transactional
    @Override
    public void insert(Coverage coverage) {
        coverageDao.insert(coverage);
    }

    @Override
    public Coverage findbyid(int id) {
        return coverageDao.findbyid(id);
    }

    @Transactional
    @Override
    public Coverage update(Coverage coverage) {
        return coverageDao.update(coverage);
    }

    @Override
    public List<Coverage> findall() {
        return coverageDao.findall();
    }
}
