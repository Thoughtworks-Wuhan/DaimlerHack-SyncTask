package com.daimler.controllers;

import com.daimler.controllers.model.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

import static com.daimler.Utils.CSV.generateCSVFile;

@Controller
@EnableAutoConfiguration
public class DataController {
    @GetMapping("/{date}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void parse(@PathVariable String date) throws IOException {
        URL url = new URL("http://tli-test.oss-cn-shanghai.aliyuncs.com/" + date + ".json.gz");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Accept-Encoding", "gzip");

        GZIPInputStream stream = new GZIPInputStream(con.getInputStream());
        Scanner sc=new Scanner(stream);
        String fileName = "test.csv";
        generateCSVFile(fileName);
        int i = 0;
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        while(sc.hasNextLine() && i < 1){
            String vehicleJsonString = sc.nextLine();
            Vehicle vehicle = new ObjectMapper().readValue(vehicleJsonString, Vehicle.class);
            out.println(vehicle.detail.csvLine());
            i++;
        }
        out.close();
    }
}