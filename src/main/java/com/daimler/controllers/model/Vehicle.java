
package com.daimler.controllers.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "detail",
    "hot_params",
    "road_haul",
    "city_name",
    "image_list",
    "clue_id",
    "thumb_img",
    "msrp",
    "title",
    "new_post",
    "price",
    "puid",
    "first_pay",
    "car_city_name",
    "license_date"
})
public class Vehicle {

    @JsonProperty("detail")
    public Detail detail;
    @JsonProperty("hot_params")
    public List<HotParam> hotParams = null;
    @JsonProperty("road_haul")
    public String roadHaul;
    @JsonProperty("city_name")
    public String cityName;
    @JsonProperty("image_list")
    public List<String> imageList = null;
    @JsonProperty("clue_id")
    public Long clueId;
    @JsonProperty("thumb_img")
    public String thumbImg;
    @JsonProperty("msrp")
    public String msrp;
    @JsonProperty("title")
    public String title;
    @JsonProperty("new_post")
    public String newPost;
    @JsonProperty("price")
    public String price;
    @JsonProperty("puid")
    public Long puid;
    @JsonProperty("first_pay")
    public String firstPay;
    @JsonProperty("car_city_name")
    public String carCityName;
    @JsonProperty("license_date")
    public String licenseDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
