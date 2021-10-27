package com.company;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, SQLException {
	    LBSGeoAPI lbsg = new LBSGeoAPI();
        lbsg.getCoordinates();
        ReadDataBase get = new ReadDataBase();
        get.connectionToDatabase(45005, 10795);
    }
}
