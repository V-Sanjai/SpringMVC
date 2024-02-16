package com.example.pmvc.service;

import com.example.pmvc.entity.Coverage;
import com.example.pmvc.entity.Policy;

import java.util.List;

public interface PolicyService {
    public void insert(Policy policy);

    public Policy update(Policy policy);
    public Policy findid(int id);
    public void delete(int id);
    public List<Policy> findpolicy();
    public void insert(Coverage coverage);
    public Coverage findbyid(int id);
    public Coverage update(Coverage coverage);
    public List<Coverage> findall();
}
