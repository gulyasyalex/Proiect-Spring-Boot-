package com.example.proiect_masini.Model;

import com.example.proiect_masini.Model.Masina;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Utilizator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_utilizator;

    @OneToMany(targetEntity = Masina.class)
    @JoinColumn(name="id_utilizator")
    private Set<Masina> masini;
    private String nume;
    private String utilizator;
    private String parola;
    private String role;

    public Utilizator(Long id_utilizator, String nume, String utilizator, String parola, String role) {
        this.id_utilizator = id_utilizator;
        this.nume = nume;
        this.utilizator = utilizator;
        this.parola = parola;
        this.role = role;
    }

    public Utilizator(String nume, String utilizator, String parola, String role) {
        this.nume = nume;
        this.utilizator = utilizator;
        this.parola = parola;
        this.role = role;
    }

    public Utilizator() {}

    public Long getId_utilizator() {
        return id_utilizator;
    }

    public void setId_utilizator(Long id_utilizator) {
        this.id_utilizator = id_utilizator;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(String utilizator) {
        this.utilizator = utilizator;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilizator{" +
                "id_utilizator=" + id_utilizator +
                ", nume='" + nume + '\'' +
                ", utilizator='" + utilizator + '\'' +
                ", parola='" + parola + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
