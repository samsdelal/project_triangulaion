package src.com.company;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Formatter;
import java.util.HashMap;

public class LBSGeoAPI {

    public void getCoordinates() throws FileNotFoundException, SQLException {
        ReadJSON nes = new ReadJSON();
        HashMap<Integer, HashMap<Integer, HashMap<String, Integer>>> jj =  nes.getJson_1();
        HashMap<Integer, HashMap<Integer, HashMap<String, Integer>>> jj_2 =  nes.getJson_2();

        ReadDataBase get = new ReadDataBase();
        for(int i: jj.keySet()){
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
            String result_lon = String.format("%.7f", lonitude);
            String result_lat = String.format("%.7f", latitude);
            System.out.printf("╔ Широта - %s\n╠ Долгота - %s\n╠ Погрешность +- 10 метров\n╚ Ссылка для просмотра - %s\n", result_lat, result_lon,  getLink(result_lat, result_lon));


        }
        for(int i: jj_2.keySet()){
            double lon = 0;
            double lat = 0;
            double dbm = 0;
            for(int powerDbm: (jj_2.get(i)).keySet()){

                double powerInDdmb = jj_2.get(i).get(powerDbm).get("power");
                dbm += powerInDdmb;

            }

            for(int gg: (jj_2.get(i)).keySet()){
                int cellID = jj_2.get(i).get(gg).get("cellid");
                int LAC = jj_2.get(i).get(gg).get("lac");
                HashMap<String, Double> connect = get.connectionToDatabase(LAC, cellID);
                int powerInDdmb = jj_2.get(i).get(gg).get("power");
                double powerCof = powerInDdmb/dbm;
                lon += connect.get("lon") * powerCof;
                lat += connect.get("lat") * powerCof;
            }

            double lonitude = lon;
            double latitude = lat;
            HashMap<String, Double> send_final = new HashMap<>();
            send_final.put("lon", lonitude);
            send_final.put("lat", latitude);
            String result_lon = String.format("%.7f", lonitude);
            String result_lat = String.format("%.7f", latitude);
            System.out.printf("╔ Широта - %s\n╠ Долгота - %s\n╠ Погрешность +- 300 метров\n╚ Ссылка для просмотра - %s\n", result_lat, result_lon,  getLink(result_lat, result_lon));
        }

    }
    private static Formatter getLink(String Lac, String Lat){
        String lac = Lac.replace(",", ".");
        String lat = Lat.replace(",", ".");
        Formatter format = new Formatter();
        format.format("https://geotree.ru/?lat=%s&lon=%s&z=16&mlat=%s&mlon=%s", lac, lat, lac, lat);
        return format;
    }

}
