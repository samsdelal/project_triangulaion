package com.company;

import java.util.ArrayList;

class JsonFile{
    public double timestamp;
    public int mcc;
    public int mnc;
    public ArrayList<JsonFile> jsonFile;
    public ArrayList<Cell> cells;
}
class Cell{
    public int lac;
    public int cellid;
    public int power;

}



