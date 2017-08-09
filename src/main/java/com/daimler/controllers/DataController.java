package com.daimler.controllers;

import com.daimler.controllers.model.Vehicle;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
    public void parse(@PathVariable String date, HttpServletResponse response) throws IOException {
        URL url = new URL("http://tli-test.oss-cn-shanghai.aliyuncs.com/" + date + ".json.gz");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Accept-Encoding", "gzip");

        GZIPInputStream stream = new GZIPInputStream(con.getInputStream());
        Scanner sc = new Scanner(stream);
        String fileName = date + ".txt";
//        generateCSVFile(fileName);
        int i = 0;
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        while (sc.hasNextLine()) {
            String vehicleJsonString = sc.nextLine();
            if (null == vehicleJsonString || vehicleJsonString.isEmpty()) {
                System.out.println("line " + i + " is empty");
                continue;
            }
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
            Vehicle vehicle = objectMapper.readValue(vehicleJsonString, Vehicle.class);
            out.println(vehicle.detail.csvLine());
            i++;
        }
        out.close();
        System.out.println("write csv done!");
        try {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition",
                    "attachment;fileName=" + fileName);// 设置文件名
            InputStream myStream = new FileInputStream(fileName);
            IOUtils.copy(myStream, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}