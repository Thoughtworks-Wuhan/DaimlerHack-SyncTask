package com.daimler.controllers.model;

/**
 * Created by JacksonGenerator on 8/6/17.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class BuyCarGifts {
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("content")
    private List<String> content;
}