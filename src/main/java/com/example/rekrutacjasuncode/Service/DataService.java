package com.example.rekrutacjasuncode.Service;

import com.example.rekrutacjasuncode.Dao.SearchType;
import com.example.rekrutacjasuncode.Entity.Data;

import java.util.List;

public interface DataService {
    List<Data> getRows(String column, SearchType searchType);
    List<Data> findAll();
}
