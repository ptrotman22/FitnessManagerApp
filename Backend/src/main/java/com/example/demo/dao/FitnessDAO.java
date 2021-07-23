package com.example.demo.dao;

import com.example.demo.entity.Fitness;
import java.util.List;

public interface FitnessDAO {
    //DAO Methods
    List<Fitness> findAll();
    Fitness findById(int theId);
    Fitness findInfoByEmail(String email);
    void save(Fitness theEmployee);
    void deleteById(int theId);
}
