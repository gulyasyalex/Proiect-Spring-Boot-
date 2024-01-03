package com.example.proiect_masini.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Masina {
    @Id
    @Column(name="numarinmatriculare")
    private String numarInmatriculare;
    @Column(name="id_utilizator")
    private Long id_utilizator;
    private String marca;
    private String modelul;
    private String culoarea;
    private Integer anul_fabricatiei;
    private Integer capacitatea_cilindrica;
    private String tipul_de_combustibil;
    private Integer puterea;
    private Integer cuplul;
    private Integer volumul_portbagajului;
    private Integer pretul;

    public Masina(){}
    public Masina(String numarInmatriculare, Long id_utilizator, String marca,
                  String modelul, String culoarea, Integer anul_fabricatiei,
                  Integer capacitatea_cilindrica, String tipul_de_combustibil,
                  Integer puterea, Integer cuplul, Integer volumul_portbagajului,
                  Integer pretul) {
        this.numarInmatriculare = numarInmatriculare;
        this.id_utilizator = id_utilizator;
        this.marca = marca;
        this.modelul = modelul;
        this.culoarea = culoarea;
        this.anul_fabricatiei = anul_fabricatiei;
        this.capacitatea_cilindrica = capacitatea_cilindrica;
        this.tipul_de_combustibil = tipul_de_combustibil;
        this.puterea = puterea;
        this.cuplul = cuplul;
        this.volumul_portbagajului = volumul_portbagajului;
        this.pretul = pretul;
    }

    public String getNumarInmatriculare() {
        return numarInmatriculare;
    }

    public void setNumarInmatriculare(String numarInmatriculare) {
        this.numarInmatriculare = numarInmatriculare;
    }

    public Long getId_utilizator() {
        return id_utilizator;
    }

    public void setId_utilizator(Long id_utilizator) {
        this.id_utilizator = id_utilizator;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelul() {
        return modelul;
    }

    public void setModelul(String modelul) {
        this.modelul = modelul;
    }

    public String getCuloarea() {
        return culoarea;
    }

    public void setCuloarea(String culoarea) {
        this.culoarea = culoarea;
    }

    public Integer getAnul_fabricatiei() {
        return anul_fabricatiei;
    }

    public void setAnul_fabricatiei(Integer anul_fabricatiei) {
        this.anul_fabricatiei = anul_fabricatiei;
    }

    public Integer getCapacitatea_cilindrica() {
        return capacitatea_cilindrica;
    }

    public void setCapacitatea_cilindrica(Integer capacitatea_cilindrica) {
        this.capacitatea_cilindrica = capacitatea_cilindrica;
    }

    public String getTipul_de_combustibil() {
        return tipul_de_combustibil;
    }

    public void setTipul_de_combustibil(String tipul_de_combustibil) {
        this.tipul_de_combustibil = tipul_de_combustibil;
    }

    public Integer getPuterea() {
        return puterea;
    }

    public void setPuterea(Integer puterea) {
        this.puterea = puterea;
    }

    public Integer getCuplul() {
        return cuplul;
    }

    public void setCuplul(Integer cuplul) {
        this.cuplul = cuplul;
    }

    public Integer getVolumul_portbagajului() {
        return volumul_portbagajului;
    }

    public void setVolumul_portbagajului(Integer volumul_portbagajului) {
        this.volumul_portbagajului = volumul_portbagajului;
    }

    public Integer getPretul() {
        return pretul;
    }

    public void setPretul(Integer pretul) {
        this.pretul = pretul;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "nr_inmatriculare=" + numarInmatriculare +
                ", id_utilizator=" + id_utilizator +
                ", marca='" + marca + '\'' +
                ", modelul='" + modelul + '\'' +
                ", culoarea='" + culoarea + '\'' +
                ", anul_fabricatiei=" + anul_fabricatiei +
                ", capacitatea_cilindrica=" + capacitatea_cilindrica +
                ", tipul_de_combustibil='" + tipul_de_combustibil + '\'' +
                ", puterea=" + puterea +
                ", cuplul=" + cuplul +
                ", volumul_portbagajului=" + volumul_portbagajului +
                ", pretul=" + pretul +
                '}';
    }
}
