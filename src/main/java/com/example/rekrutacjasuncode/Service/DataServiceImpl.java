package com.example.rekrutacjasuncode.Service;

import com.example.rekrutacjasuncode.Dao.ColumnInterface;
import com.example.rekrutacjasuncode.Dao.SearchType;
import com.example.rekrutacjasuncode.Entity.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class DataServiceImpl implements DataService{

    private final EntityManager entityManager;
    private final ColumnInterface columnInterface;

    @Autowired
    public DataServiceImpl(ColumnInterface columnInterface, EntityManager entityManager) {
        this.entityManager = entityManager;
        this.columnInterface = columnInterface;
    }

    @Override
    @Transactional
    public List<Data> getRows(String column, SearchType searchType) {
        String query = null;

        switch (searchType){
            case ALL:
                return findAll();
            case UNIQUE:
                query = "FROM Data WHERE " + column + " IN (SELECT " + column + " FROM Data GROUP BY " + column + " HAVING COUNT(*) = 1)";
                break;

            case COMMON:
                query = "FROM Data WHERE " + column + " IN (SELECT " + column + " FROM Data GROUP BY " + column + " HAVING COUNT(*) > 1)";
                break;
        }

        TypedQuery<Data> typedQuery = entityManager.createQuery(query, Data.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Data> findAll() {
        return columnInterface.findAll();
    }

}
