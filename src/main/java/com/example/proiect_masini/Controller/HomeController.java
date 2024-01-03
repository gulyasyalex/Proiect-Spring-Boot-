//package com.example.proiect_masini;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.sql.*;
//import java.util.ArrayList;
//
//@RestController
//public class HomeController {
//    @GetMapping(path="/rest")
//    public ArrayList<String> homePage(){
//
//        String url = "jdbc:mysql://localhost:3306/proiect_masini";
//        String sql = "select * from utilizator";
//
//        try {
//            Connection connection = DriverManager.getConnection(url, "root", "root");
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            ArrayList<String> arrayList = new ArrayList<String>();
//            while (rs.next()){
//                System.out.println(rs.getInt(1));
//                arrayList.add(rs.getString(2));
//            }
//            return arrayList;
//        }catch ( SQLException e ){
//            e.printStackTrace();
//        }
//        return new ArrayList<>();
//    }
//
//    @GetMapping(path="/admin1")
//    public String admin(){
//        return "<h1> Welcome Admin </h1>";
//    }
//}
