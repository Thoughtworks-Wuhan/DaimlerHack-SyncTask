
package com.daimler.controllers.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import static com.daimler.Utils.CSV.replaceCommaWithSpace;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "emission_standard",
        "service_item",
        "wap_share_icon",
        "bottom_tips",
        "domain",
        "show_status",
        "road_haul",
        "new_price",
        "loan_amount",
        "deal_price",
        "buy_car_gifts",
        "price",
        "title",
        "bottom_icon",
        "car_source_status",
        "puid",
        "offer_price_info",
        "seller",
        "gearbox",
        "use_date",
        "emission_standard_desc",
        "highlight_config_item",
        "insurance_date",
        "subtitle",
        "phone",
        "air_displacement",
        "seller_description",
        "describe_list",
        "clue_id_str",
        "imageList",
        "is_pay",
        "monthly_payment",
        "follow_num",
        "evaluate_items",
        "emissions_standards_url",
        "promote_price",
        "transfer_num",
        "hege_icon",
        "report_url",
        "recommend",
        "is_heat_analysis",
        "heat_analysis",
        "evaluator",
        "audit_date",
        "strong_insurance_date",
        "license",
        "wap_url",
        "gender",
        "seller_job",
        "loan_url",
        "clue_id",
        "not_zhibao",
        "evaluator_desc",
        "show_config",
        "evaluate_job",
        "loanInfo",
        "city_id",
        "is_collection",
        "service_desc",
        "service",
        "district_name",
        "service_charge",
        "evaluate_tips_desc",
        "evaluate_time",
        "car_hot_params",
        "thumb_img",
        "card_city",
        "evaluator_image",
        "first_amount",
        "imageCategoryList"
})
public class Detail {

    @JsonProperty("emission_standard")
    public String emissionStandard;
    @JsonProperty("service_item")
    public List<ServiceItem> serviceItem = null;
    @JsonProperty("wap_share_icon")
    public String wapShareIcon;
    @JsonProperty("bottom_tips")
    public String bottomTips;
    @JsonProperty("domain")
    public String domain;
    @JsonProperty("show_status")
    public Long showStatus;
    @JsonProperty("road_haul")
    public String roadHaul;
    @JsonProperty("new_price")
    public String newPrice;
    @JsonProperty("loan_amount")
    public Long loanAmount;
    @JsonProperty("deal_price")
    public Long dealPrice;
    @JsonProperty("buy_car_gifts")
    public BuyCarGifts buyCarGifts = null;
    @JsonProperty("price")
    public String price;
    @JsonProperty("title")
    public String title;
    @JsonProperty("bottom_icon")
    public String bottomIcon;
    @JsonProperty("car_source_status")
    public String carSourceStatus;
    @JsonProperty("puid")
    public String puid;
    @JsonProperty("offer_price_info")
    public OfferPriceInfo offerPriceInfo;
    @JsonProperty("seller")
    public String seller;
    @JsonProperty("gearbox")
    public String gearbox;
    @JsonProperty("use_date")
    public String useDate;
    @JsonProperty("emission_standard_desc")
    public String emissionStandardDesc;
    @JsonProperty("highlight_config_item")
    public List<HighlightConfigItem> highlightConfigItem = null;
    @JsonProperty("insurance_date")
    public String insuranceDate;
    @JsonProperty("subtitle")
    public String subtitle;
    @JsonProperty("phone")
    public String phone;
    @JsonProperty("air_displacement")
    public String airDisplacement;
    @JsonProperty("seller_description")
    public String sellerDescription;
    @JsonProperty("describe_list")
    public DescribeList describeList;
    @JsonProperty("clue_id_str")
    public String clueIdStr;
    @JsonProperty("imageList")
    public List<ImageList> imageList = null;
    @JsonProperty("is_pay")
    public Long isPay;
    @JsonProperty("monthly_payment")
    public Long monthlyPayment;
    @JsonProperty("follow_num")
    public Long followNum;
    @JsonProperty("evaluate_items")
    public List<EvaluateItem> evaluateItems = null;
    @JsonProperty("emissions_standards_url")
    public String emissionsStandardsUrl;
    @JsonProperty("promote_price")
    public Long promotePrice;
    @JsonProperty("transfer_num")
    public String transferNum;
    @JsonProperty("hege_icon")
    public String hegeIcon;
    @JsonProperty("report_url")
    public String reportUrl;
    @JsonProperty("recommend")
    public List<Recommend> recommend = null;
    @JsonProperty("is_heat_analysis")
    public Long isHeatAnalysis;
    @JsonProperty("heat_analysis")
    public HeatAnalysis heatAnalysis;
    @JsonProperty("evaluator")
    public String evaluator;
    @JsonProperty("audit_date")
    public String auditDate;
    @JsonProperty("strong_insurance_date")
    public String strongInsuranceDate;
    @JsonProperty("license")
    public String license;
    @JsonProperty("wap_url")
    public String wapUrl;
    @JsonProperty("gender")
    public String gender;
    @JsonProperty("seller_job")
    public String sellerJob;
    @JsonProperty("loan_url")
    public String loanUrl;
    @JsonProperty("clue_id")
    public String clueId;
    @JsonProperty("not_zhibao")
    public Long notZhibao;
    @JsonProperty("evaluator_desc")
    public String evaluatorDesc;
    @JsonProperty("show_config")
    public Long showConfig;
    @JsonProperty("evaluate_job")
    public String evaluateJob;
    @JsonProperty("loanInfo")
    public String loanInfo;
    @JsonProperty("city_id")
    public String cityId;
    @JsonProperty("is_collection")
    public Long isCollection;
    @JsonProperty("service_desc")
    public List<ServiceDesc> serviceDesc = null;
    @JsonProperty("service")
    public Service service;
    @JsonProperty("district_name")
    public String districtName;
    @JsonProperty("service_charge")
    public ServiceCharge serviceCharge;
    @JsonProperty("evaluate_tips_desc")
    public String evaluateTipsDesc;
    @JsonProperty("evaluate_time")
    public String evaluateTime;
    @JsonProperty("car_hot_params")
    public List<CarHotParam> carHotParams = null;
    @JsonProperty("thumb_img")
    public String thumbImg;
    @JsonProperty("card_city")
    public String cardCity;
    @JsonProperty("evaluator_image")
    public String evaluatorImage;
    @JsonProperty("first_amount")
    public String firstAmount;
    @JsonProperty("imageCategoryList")
    public List<ImageCategoryList> imageCategoryList = null;
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

    public String csvLine() {
        StringBuilder sb = new StringBuilder();
        sb.append(replaceCommaWithSpace(roadHaul));
        sb.append('|');
        sb.append(replaceCommaWithSpace(newPrice));
        sb.append('|');
        sb.append(replaceCommaWithSpace(price));
        sb.append('|');
        sb.append(replaceCommaWithSpace(title));
        sb.append('|');
        sb.append(month(useDate));
        sb.append('|');
        sb.append(replaceCommaWithSpace(insuranceDate));
        sb.append('|');
        sb.append(replaceCommaWithSpace(gearbox));
        return sb.toString();
    }

    public Integer month(String useDate) {
        if (useDate != null) {
            Pattern pattern = Pattern.compile("([1-9])年([1-9]+)个月");

            Matcher matcher = pattern.matcher(useDate);
            if (matcher.matches()) {
                return Integer.parseInt(matcher.group(1)) * 12 + Integer.parseInt(matcher.group(2));
            }
        }
        return null;
    }
}
