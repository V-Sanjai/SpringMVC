package com.example.pmvc.dao;

import com.example.pmvc.entity.Coverage;

import java.util.List;

public interface CoverageDao {
    public void insert(Coverage coverage);
    public Coverage findbyid(int id);
    public Coverage update(Coverage coverage);
    public List<Coverage> findall();
}
