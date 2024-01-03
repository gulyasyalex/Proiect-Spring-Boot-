package com.example.proiect_masini.Repository;


import com.example.proiect_masini.Model.Masina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface MasinaRepository extends JpaRepository<Masina,String> {
    List<Masina> findAll();


    @Override
    <S extends Masina> S saveAndFlush(S entity);
    @Query(value = "select m from Masina m where m.marca like coalesce(?1, m.marca)"+
            "  AND  m.culoarea like coalesce(?2, m.culoarea)" +
            "  AND m.tipul_de_combustibil like coalesce(?3, m.tipul_de_combustibil)")
    List<Masina> findAllByKeywords(String filter1, String filter2, String filter3);

    void delete(Masina masina);

    @Override
    void flush();

    Optional<Masina> findMasinaByNumarInmatriculare(String numarInmatriculare);
    /*
    String url = "jdbc:mysql://localhost:3306/proiect_masini";
    public default ArrayList<Masina> selectAll(){
            String sql = "select * from masini";
            try {
                Connection connection = DriverManager.getConnection(url, "root", "root");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(sql);
                ArrayList<Masina> arrayList = new ArrayList<Masina>();
                while (rs.next()){
                    Masina masina = new Masina(rs.getString(1),
                            rs.getInt(2),rs.getString(3),
                            rs.getString(4),rs.getString(5),
                            rs.getInt(6),rs.getInt(7),
                            rs.getString(8),rs.getInt(9),
                            rs.getInt(10),
                            rs.getInt(11),rs.getInt(12));
                    System.out.println(masina.toString());
                    arrayList.add(masina);
                }
                return arrayList;
            }catch ( SQLException e ){
                e.printStackTrace();
            }
            return new ArrayList<>();
        }
    public default void saveMasina(Masina masina){
        try {
            Connection connection = DriverManager.getConnection(url, "root", "root");
            String sql = "insert into masini values (?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1,masina.getNr_inmatriculare());
                ps.setInt(2,masina.getId_utilizator());
                ps.setString(3,masina.getMarca());
                ps.setString(4,masina.getMarca());
                ps.setString(5,masina.getCuloarea());
                ps.setInt(6, masina.getAnul_fabricatiei());
                ps.setInt(7, masina.getCapacitatea_cilindrica());
                ps.setString(8, masina.getTipul_de_combustibil());
                ps.setInt(9, masina.getPuterea());
                ps.setInt(10, masina.getCuplul());
                ps.setInt(11, masina.getVolumul_portbagajului());
                ps.setInt(12, masina.getPretul());
                int nr_randuri = ps.executeUpdate();
                System.out.println("\nNumar randuri afectate de adaugare=" + nr_randuri);
            } catch (SQLException e) {
                System.out.println(sql);
                e.printStackTrace();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public default void deleteMasina(String nr_inmatriculare){
        ArrayList<Masina> arrayMasini = selectAll();

        boolean found = false;
        for (Masina masina: arrayMasini){
            String nr_inmatriculareArray = masina.getNr_inmatriculare();
            if(nr_inmatriculareArray==nr_inmatriculare){
                found = true;
                break;
            }
        }
        if(found) {
            String sql = "delete from persoane where nr_inmatriculare=?";

            try {
                Connection connection = DriverManager.getConnection(url, "root", "root");
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, nr_inmatriculare);
                int nr_randuri = ps.executeUpdate();
                System.out.println("\nNumar randuri afectate de modificare=" + nr_randuri);
            } catch (SQLException e) {
                System.out.println(sql);
                e.printStackTrace();
            }
        }else{
            System.out.println("Nu a fost gasit pentru stergere");
        }
    }
     */

}
