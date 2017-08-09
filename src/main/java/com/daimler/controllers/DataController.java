package com.daimler.controllers;

import com.daimler.aync.pool.FetchDataAsyncTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@EnableAutoConfiguration
public class DataController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String DEFAULT_START_DATE = "20170619";

    @Autowired
    private FetchDataAsyncTask task;

    @GetMapping("/{date}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void parse(@PathVariable String date) throws IOException, ParseException, InterruptedException {
        Calendar startDate = getCalendar(DEFAULT_START_DATE);
        Calendar endDate = getCalendar(date);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

        while (!endDate.before(startDate)) {
            logger.info("startDate: " + df.format(startDate.getTime()) + " endDate: " + df.format(endDate.getTime()));
            task.doTask1(df.format(startDate.getTime()));
            startDate.add(Calendar.DATE, 1);
        }
    }

    private Calendar getCalendar(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = dateFormat.parse(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}