package com.example.pmvc.dao;

import com.example.pmvc.entity.Policy;

import java.util.List;

public interface PolicyDao {
    public void insert(Policy policy);

    public Policy update(Policy policy);
    public Policy findbyid(int id);
    public void delete(int id);
    public List<Policy> findall();
}
