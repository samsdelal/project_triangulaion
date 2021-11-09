package com.company;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;

public class LBSGeoAPI {

    public void getCoordinates() throws FileNotFoundException, SQLException {
        ReadJSON nes = new ReadJSON();
        //System.out.println(nes.getJson());
        HashMap<Integer, HashMap<Integer, HashMap<String, Integer>>> jj =  nes.getJson_1();
        HashMap<Integer, HashMap<Integer, HashMap<String, Integer>>> jj_2 =  nes.getJson_2();

        //System.out.println(jj);
        ReadDataBase get = new ReadDataBase();
//        get.connectionToDatabase(45005, 10795);
        for(int i: jj.keySet()){
            //System.out.println(jj.get(i));
            double lon = 0;
            double lat = 0;
            double dbm = 0;
            for(int powerDbm: (jj.get(i)).keySet()){

                double powerInDdmb = jj.get(i).get(powerDbm).get("power");

                dbm += powerInDdmb;

            }


            for(int gg: (jj.get(i)).keySet()){
                int cellID = jj.get(i).get(gg).get("cellid");
                int LAC = jj.get(i).get(gg).get("lac");
                HashMap<String, Double> connect = get.connectionToDatabase(LAC, cellID);
                //System.out.println(connect);
                int powerInDdmb = jj.get(i).get(gg).get("power");
                double powerCof = powerInDdmb/dbm;
                lon += connect.get("lon") * powerCof;
                lat += connect.get("lat") * powerCof;
            }

            int countCells = jj.get(i).size();
            double lonitude = lon;
            double latitude = lat;
            HashMap<String, Double> send_final = new HashMap<>();
            send_final.put("lon", lonitude);
            send_final.put("lat", latitude);
//            System.out.println(send_final);
            String result_lon = String.format("%.7f", lonitude);
            String result_lat = String.format("%.7f", latitude);
            System.out.printf("Широта - %s, Долгота - %s +- 10 метров\n", result_lat, result_lon);


        }
        for(int i: jj_2.keySet()){
            //System.out.println(jj_2.get(i));
            double lon = 0;
            double lat = 0;
            double dbm = 0;
            for(int powerDbm: (jj_2.get(i)).keySet()){

                double powerInDdmb = jj_2.get(i).get(powerDbm).get("power");
                //System.out.println(powerInDdmb);
                dbm += powerInDdmb;

            }
            //System.out.println(dbm);

            for(int gg: (jj_2.get(i)).keySet()){
                int cellID = jj_2.get(i).get(gg).get("cellid");
                int LAC = jj_2.get(i).get(gg).get("lac");
                HashMap<String, Double> connect = get.connectionToDatabase(LAC, cellID);
                //System.out.println(connect);
                int powerInDdmb = jj_2.get(i).get(gg).get("power");
                double powerCof = powerInDdmb/dbm;
                lon += connect.get("lon") * powerCof;
                lat += connect.get("lat") * powerCof;
            }

            int countCells = jj_2.get(i).size();
            double lonitude = lon;
            double latitude = lat;
            HashMap<String, Double> send_final = new HashMap<>();
            send_final.put("lon", lonitude);
            send_final.put("lat", latitude);
//            System.out.println(send_final);
            String result_lon = String.format("%.7f", lonitude);
            String result_lat = String.format("%.7f", latitude);
            System.out.printf("Широта - %s, Долгота - %s +- 300 метров\n", result_lat, result_lon);
        }

    }

}
