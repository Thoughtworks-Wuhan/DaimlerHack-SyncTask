package com.daimler.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class CSV {

    public static void generateCSVFile(String fileName) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(fileName));
        StringBuilder sb = new StringBuilder();
        sb.append("road_haul");
        sb.append(',');
        sb.append("new_price");
        sb.append(',');
//        sb.append("title");
//        sb.append(',');
//        sb.append("use_date");
//        sb.append(',');
//        sb.append("insurance_date");
//        sb.append(',');
//        sb.append("gear_box");
//        sb.append(',');
        sb.append("price");
        sb.append('\n');
        pw.close();
    }

    public static String replaceCommaWithSpace(String field) {
        if (field != null) {
            return field.replace(',', ' ').replace("\n", " ");
        }
        return field;
    }

}