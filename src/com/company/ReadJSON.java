package com.company;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class ReadJSON {
//    public HashMap<Integer, HashMap<Integer, HashMap<String, Integer>>> getJson() throws FileNotFoundException {
//
//        Gson g = new Gson();
//        BufferedReader br = new BufferedReader(new FileReader("/Users/boriskuznecov/IdeaProjects/project_triangulaion/src/com/company/first.json"));
//
//        JsonFile[] jsonf = g.fromJson(br, JsonFile[].class);
//        HashMap<Integer, HashMap<Integer, HashMap<String, Integer>>> json_file = new HashMap<>();
//        for (int i = 0; i < jsonf.length; i++) {
//            //System.out.printf("timestamp -%s, mcc -%s, mnc -%s data:\n", jsonf[i].timestamp, jsonf[i].mcc, jsonf[i].mnc);
////            for(Cell ds: jsonf[i].cells){
////                int power = (int) (10*Math.log(ds.power*0.000001));
////                System.out.printf("power - %sdb, cellid - %s, lac - %s\n", power, ds.cellid, ds.lac);
////            }
//            HashMap<Integer, HashMap<String, Integer>> cel_ = new HashMap<>();
////            json_file.put(i, cel_);
//            int time = 0;
//            ArrayList<Integer> check = new ArrayList<>();
//            for (Cell ds : jsonf[i].cells) {
//                check.add(ds.power);
//                int power = (int) (10 * Math.log(ds.power * 0.0001));
//                HashMap<String, Integer> CeL = new HashMap<>();
//                CeL.put("lac", ds.lac);
//                CeL.put("cellid", ds.cellid);
//                CeL.put("power", power);
//                cel_.put(time, CeL);
//                time += 1;
//            }
////            System.out.println(Collections.sort(check));
//            json_file.put(i, cel_);
//
//
//        }
//        return json_file;
//    }

    public HashMap<Integer, HashMap<Integer, HashMap<String, Integer>>> getJson_1() throws FileNotFoundException {
//
//        Gson g = new Gson();
//        BufferedReader br = new BufferedReader(new FileReader("/Users/boriskuznecov/IdeaProjects/project_triangulaion/src/com/company/first.json"));
//
//        JsonFile[] jsonf = g.fromJson(br, JsonFile[].class);
//        HashMap<Integer, HashMap<Integer, HashMap<String, Integer>>> json_file = new HashMap<>();
//        for (int i = 0; i < jsonf.length; i++) {
//            //System.out.printf("timestamp -%s, mcc -%s, mnc -%s data:\n", jsonf[i].timestamp, jsonf[i].mcc, jsonf[i].mnc);
////            for(Cell ds: jsonf[i].cells){
////                int power = (int) (10*Math.log(ds.power*0.000001));
////                System.out.printf("power - %sdb, cellid - %s, lac - %s\n", power, ds.cellid, ds.lac);
////            }
//            HashMap<Integer, HashMap<String, Integer>> cel_ = new HashMap<>();
////            json_file.put(i, cel_);
//            int time = 0;
//            ArrayList<Integer> check = new ArrayList<>();
//            for (Cell ds : jsonf[i].cells) {
//                check.add(ds.power);
//            }
//            for (Cell ds : jsonf[i].cells) {
//                if(dq.sort_array(check).contains(ds.power)){
//                    int power = (int) (10 * Math.log(ds.power * 0.0001));
//                    HashMap<String, Integer> CeL = new HashMap<>();
//                    CeL.put("lac", ds.lac);
//                    CeL.put("cellid", ds.cellid);
//                    CeL.put("power", power);
//                    cel_.put(time, CeL);
//                    time += 1;
//                }
//            }
//
//            json_file.put(i, cel_);
//
//
//        }
//        return json_file;
//    }
        Gson g = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("/Users/boriskuznecov/IdeaProjects/project_triangulaion/src/com/company/first.json"));

        JsonFile[] jsonf = g.fromJson(br, JsonFile[].class);
        HashMap<Integer, HashMap<Integer, HashMap<String, Integer>>> json_file = new HashMap<>();
        for (int i = 0; i < jsonf.length; i++) {
            //System.out.printf("timestamp -%s, mcc -%s, mnc -%s data:\n", jsonf[i].timestamp, jsonf[i].mcc, jsonf[i].mnc);
            //            for(Cell ds: jsonf[i].cells){
            //                int power = (int) (10*Math.log(ds.power*0.000001));
            //                System.out.printf("power - %sdb, cellid - %s, lac - %s\n", power, ds.cellid, ds.lac);
            //            }
            HashMap<Integer, HashMap<String, Integer>> cel_ = new HashMap<>();
            //            json_file.put(i, cel_);
            int time = 0;
            for (Cell ds : jsonf[i].cells) {

                int power =  (byte) ds.power;
                //System.out.println(power);
                HashMap<String, Integer> CeL = new HashMap<>();
                CeL.put("lac", ds.lac);
                CeL.put("cellid", ds.cellid);
                CeL.put("power", power);
                cel_.put(time, CeL);
                time += 1;

            }

            json_file.put(i, cel_);


        }
        return json_file;
    }

    public HashMap<Integer, HashMap<Integer, HashMap<String, Integer>>> getJson_2() throws FileNotFoundException {

        Gson g = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("/Users/boriskuznecov/IdeaProjects/project_triangulaion/src/com/company/second.json"));

        JsonFile[] jsonf = g.fromJson(br, JsonFile[].class);
        HashMap<Integer, HashMap<Integer, HashMap<String, Integer>>> json_file = new HashMap<>();
        for (int i = 0; i < jsonf.length; i++) {
            //System.out.printf("timestamp -%s, mcc -%s, mnc -%s data:\n", jsonf[i].timestamp, jsonf[i].mcc, jsonf[i].mnc);
//            for(Cell ds: jsonf[i].cells){
//                int power = (int) (10*Math.log(ds.power*0.000001));
//                System.out.printf("power - %sdb, cellid - %s, lac - %s\n", power, ds.cellid, ds.lac);
//            }
            HashMap<Integer, HashMap<String, Integer>> cel_ = new HashMap<>();
//            json_file.put(i, cel_);
            int time = 0;
            for (Cell ds : jsonf[i].cells) {

                byte power = (byte) ds.power;
                System.out.println(power);
                HashMap<String, Integer> CeL = new HashMap<>();
                CeL.put("lac", ds.lac);
                CeL.put("cellid", ds.cellid);
                CeL.put("power", (int) power);
                cel_.put(time, CeL);
                time += 1;

            }

            json_file.put(i, cel_);


        }
        return json_file;
    }
}
