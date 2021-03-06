
package com.daimler.controllers.model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.util.StringUtils;

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

    public int getUsedMonth() {
        return month(useDate);
    }

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
        sb.append(monthInsurance(insuranceDate));
        sb.append('|');
        sb.append(replaceAutoAndManual(replaceCommaWithSpace(gearbox)));
        sb.append('|');
        sb.append(brandIndex(replaceCommaWithSpace(title)));
        sb.append('|');
        sb.append(leveledPrice(newPrice));
        sb.append('|');
        sb.append(leveledPrice(price));
        return sb.toString();
    }

    public String leveledPrice(String price) {
        if (price != null) {
            return String.valueOf(Math.round(Double.parseDouble(price) / 0.5));
        }
        return "0";
    }


    public Integer brandIndex(String title) {
        if (title != null) {
            for (int i = 0; i < brandList.size(); i++) {
                if (title.contains(brandList.get(i))) {
                    return i+1;
                }
            }
        }
        return 0;
    }

    public Integer month(String useDate) {
        if (useDate != null) {
            Pattern pattern = Pattern.compile("([1-9])年([1-9]+)个月");

            Matcher matcher = pattern.matcher(useDate);
            if (matcher.matches()) {
                return Integer.parseInt(matcher.group(1)) * 12 + Integer.parseInt(matcher.group(2));
            }
        }
        return 0;
    }

    public Integer monthInsurance(String insuranceDate) {
        if (insuranceDate != null) {
            Pattern pattern = Pattern.compile("([0-9]+)年([0-9]+)月商业险到期");

            Matcher matcher = pattern.matcher(insuranceDate);
            if (matcher.matches()) {
                int year = Calendar.getInstance().get(Calendar.YEAR);
                int month = Calendar.getInstance().get(Calendar.MONTH);
                return (Integer.parseInt(matcher.group(1)) - year) * 12 + Integer
                        .parseInt(matcher.group(2)) - month;
            } else {
                return 0;
            }
        }
        return 0;
    }

    public Integer replaceAutoAndManual(String gearbox) {
        if(null == gearbox) {
            return 0;
        }
        if(gearbox.contains("自动")) {
            return 1;
        } else if(gearbox.contains("手动")) {
            return 2;
        }
        return 0;
    }

    private String s = "奥迪,AlPINA,宝马,奔驰,保时捷,宝沃,大众,KTM,罗伦士,MINI,Smart,泰卡特,威兹曼,西雅特,本田,丰田,雷克萨斯,铃木,马自达,讴歌,日产,斯巴鲁,三菱,五十铃," +
            "英菲尼迪," +
            "起亚," +
            "双龙," +
            "现代,别克,道奇,福特,Faraday Future,GMC,Jeep,凯迪拉克,克莱斯勒,林肯,赛麟,山姆,特斯拉,雪佛兰,星客特,标致,DS,雷诺,雪铁龙,阿斯顿马丁,宾利,捷豹,路虎,劳斯莱斯,路特斯,迈凯伦,摩根,阿尔法罗密欧,布加迪,菲亚特,法拉利,兰博基尼,玛莎拉蒂,帕加尼,依维柯,科尼塞克,沃尔沃,斯柯达,宝骏,比亚迪,奔腾,比速,北汽,长安,长城,昌河,成功,东风,飞驰,福迪,福汽,福田,广汽传祺,观致,哈弗,海马,汉腾,红旗,华泰,哈飞,海格,恒天,华凯,黄海,华颂,汇众,吉利,江淮,江铃,金杯,金龙,金旅,九龙,吉威,凯翼,开瑞,卡升,卡威,科瑞斯的,康迪,领克,陆风,力帆,莲花,猎豹,理念,陆地方舟,蓝海,雷丁,名爵,MG,纳智捷,奇瑞,启程,前途,庆铃,荣威,腾势,五菱,WEY,威麟,新凯,驭胜,野马,一汽,宇通,亚星,众泰,中华,知豆,之诺,中兴";
    private List<String> brandList = new ArrayList<String>(Arrays.asList(s.split(",")));

}
