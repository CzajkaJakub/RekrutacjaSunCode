package com.example.rekrutacjasuncode.Service;

import com.example.rekrutacjasuncode.Entity.Data;

import java.util.List;

public interface DataService {
    List<Data> findAll();
    Data findById(Long theId);

}
