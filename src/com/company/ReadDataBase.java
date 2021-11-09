package com.company;

import java.sql.*;
import java.util.Formatter;
import java.util.HashMap;

public class ReadDataBase {
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;

//    public void connectionToDatabase() throws SQLException {
//        String query = "select * from towers where cellid = 2241 and lac = 45005";
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://0.tcp.ngrok.io:15791/cell", "ro1", "a2188e43a3688dffcba3c958b0bcc416");
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(query);
//            while (rs.next()){
//                System.out.printf("lat - %s, lon - %s\n", rs.getString(8), rs.getString(9));
//                //System.out.println(rs.getString(8));
//
//            }
//
//        }catch (SQLException | ClassNotFoundException e){
//            e.printStackTrace();
//        }
//
//    }
    public HashMap<String, Double> connectionToDatabase(int lac, int cellid) throws SQLException {
        Formatter query = new Formatter();
        query.format("select * from towers where cellid = %s and lac = %s and mcc = 250 and mnc = 1", cellid, lac);

        //String query = "select * from towers where cellid = ? and lac = ?";
        HashMap<String, Double> Coordinates = new HashMap<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://0.tcp.ngrok.io:15791/cell", "ro1", "a2188e43a3688dffcba3c958b0bcc416");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(String.valueOf(query));
            while (rs.next()){
                Coordinates.put("lat", Double.valueOf(rs.getString(8)));
                Coordinates.put("lon", Double.valueOf(rs.getString(9)));


                //System.out.printf("lat - %s, lon - %s\n", rs.getString(8), rs.getString(9));
                //System.out.println(rs.getString(8));
                return Coordinates;
            }

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return Coordinates;
    }

}
