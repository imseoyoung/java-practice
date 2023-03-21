package com.sylim.practice.examUp7;

import java.util.Properties;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader fr = new FileReader("gradle.properties");
        Properties prop = new Properties();
        prop.load(fr);
        
        String str = prop.getProperty("android.useAndroidX");
        
        System.out.println(str);
        
        fr.close();
    }
}