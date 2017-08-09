package com.daimler.aync.pool;

import com.daimler.controllers.model.Vehicle;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

import static com.daimler.Utils.CSV.generateCSVFile;

@Component
public class FetchDataAsyncTask {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async("myTaskAsyncPool")
    public void doTask1(String date) throws InterruptedException, IOException {
        logger.info("Task " + date + " started.");
        parseDatainDate(date);
    }

    private void parseDatainDate(String date) throws IOException {

        String fileName = "data/" + date +".txt";
        generateCSVFile(fileName);

        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);

        URL url = new URL("http://tli-test.oss-cn-shanghai.aliyuncs.com/" + date + ".json.gz");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Accept-Encoding", "gzip");

        try {
            GZIPInputStream stream = new GZIPInputStream(con.getInputStream());
            Scanner sc = new Scanner(stream);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
            while (sc.hasNextLine()) {
                String vehicleJsonString = sc.nextLine();
                if (null == vehicleJsonString || vehicleJsonString.isEmpty()) {
//                    System.out.println("line " + i + " is empty");
                    continue;
                }
                Vehicle vehicle = objectMapper.readValue(vehicleJsonString, Vehicle.class);
                out.println(vehicle.detail.csvLine());
            }
            logger.info("write " + date + " csv done!");
        } catch (FileNotFoundException exception) {
            logger.error("write " + date + " failed, file not found");
        }
        out.close();
    }
}