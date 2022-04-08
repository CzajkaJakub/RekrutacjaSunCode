package com.example.rekrutacjasuncode.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "tabela_testowa")
public class Data {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "kolumna1", length = 256)
    private String kolumna1;

    @Column(name = "kolumna2", length = 256)
    private String kolumna2;

    @Column(name = "kolumna3", length = 256)
    private String kolumna3;

    @Column(name = "kolumna4")
    private Long kolumna4;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Data data = (Data) o;
        return id != null && Objects.equals(id, data.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
