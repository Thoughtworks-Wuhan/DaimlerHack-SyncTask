package com.daimler.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class CSV {
    public static String replaceCommaWithSpace(String field) {
        if (field != null) {
            return field.replace(',', ' ').replace("\n", " ");
        }
        return field;
    }

}