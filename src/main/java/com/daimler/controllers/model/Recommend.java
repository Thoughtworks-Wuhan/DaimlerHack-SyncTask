
package com.daimler.controllers.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clue_id",
    "thumb_img",
    "price",
    "title",
    "puid",
    "road_haul",
    "msrp",
    "gearbox",
    "license_date"
})
public class Recommend {

    @JsonProperty("clue_id")
    public String clueId;
    @JsonProperty("thumb_img")
    public String thumbImg;
    @JsonProperty("price")
    public String price;
    @JsonProperty("title")
    public String title;
    @JsonProperty("puid")
    public String puid;
    @JsonProperty("road_haul")
    public String roadHaul;
    @JsonProperty("msrp")
    public String msrp;
    @JsonProperty("gearbox")
    public String gearbox;
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
