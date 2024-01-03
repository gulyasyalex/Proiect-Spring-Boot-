package com.example.proiect_masini.Repository;

import com.example.proiect_masini.Model.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilizatorRepository extends JpaRepository<Utilizator,Long> {
    Utilizator findByUtilizator(String utilizator);

    @Override
    <S extends Utilizator> List<S> saveAllAndFlush(Iterable<S> entities);
}
