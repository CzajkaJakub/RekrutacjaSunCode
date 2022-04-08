package com.example.rekrutacjasuncode.Service;

import com.example.rekrutacjasuncode.Dao.ColumnInterface;
import com.example.rekrutacjasuncode.Entity.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService{

    private final ColumnInterface columnInterface;

    @Autowired
    public DataServiceImpl(ColumnInterface columnInterface) {
        this.columnInterface = columnInterface;
    }


    @Override
    public List<Data> findAll() {
        return columnInterface.findAll();
    }

    @Override
    public Data findById(Long theId) {
        return columnInterface.getById(theId);
    }
}
