package com.example.rekrutacjasuncode.Dao;

import com.example.rekrutacjasuncode.Entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ColumnInterface extends JpaRepository<Data, Long> {

}
