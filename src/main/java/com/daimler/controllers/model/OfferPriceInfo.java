
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
    "car_list_url",
    "per_price_low",
    "perPriceLowOorigin",
    "title",
    "historical_record_url",
    "perPriceTopOorigin",
    "level",
    "per_price_top",
    "desc",
    "seller_price"
})
public class OfferPriceInfo {

    @JsonProperty("car_list_url")
    public String carListUrl;
    @JsonProperty("per_price_low")
    public String perPriceLow;
    @JsonProperty("perPriceLowOorigin")
    public Long perPriceLowOorigin;
    @JsonProperty("title")
    public String title;
    @JsonProperty("historical_record_url")
    public String historicalRecordUrl;
    @JsonProperty("perPriceTopOorigin")
    public Long perPriceTopOorigin;
    @JsonProperty("level")
    public Long level;
    @JsonProperty("per_price_top")
    public String perPriceTop;
    @JsonProperty("desc")
    public String desc;
    @JsonProperty("seller_price")
    public String sellerPrice;
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
