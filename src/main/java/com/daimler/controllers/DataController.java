package com.daimler.controllers;

import com.daimler.aync.pool.FetchDataAsyncTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class DataController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FetchDataAsyncTask task;

    @GetMapping("/load/{date}")
    @ResponseBody Map<String, String> parseRawDataFile(
            @PathVariable String date,
            @RequestParam(value="start", required=false, defaultValue="20170619") String strStartDate,
            @RequestParam(value="loadToDB", required=false, defaultValue="false") String loadToDB
    )throws IOException, ParseException, InterruptedException {
        Map<String, String> result = new HashMap<String, String>();
        Calendar startDate = getCalendar(strStartDate);
        Calendar endDate = getCalendar(date);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

        while (!endDate.before(startDate)) {
            logger.info("startDate: " + df.format(startDate.getTime()) + " endDate: " + df.format(endDate.getTime()));
            task.doTask1(df.format(startDate.getTime()), loadToDB);
            startDate.add(Calendar.DATE, 1);
        }

        result.put("message", "start tread to load data from  " + startDate + " to " + date);

        return result;
    }

    private Calendar getCalendar(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = dateFormat.parse(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}