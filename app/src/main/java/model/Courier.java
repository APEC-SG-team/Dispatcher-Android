package model;

/**
 * Created by winhtaikaung on 19/5/17.
 */

public class Courier {
    private String name;
    private String from;
    private String to;
    private String etmDelivaryDate;
    private String imgUrl;

    public Courier(String name,String from,String to,String etmDelivaryDate,String imgUrl){
        this.name = name;
        this.from = from;
        this.to = to;
        this.etmDelivaryDate = etmDelivaryDate;
        this.imgUrl = imgUrl;
    }

    public Courier(String name,String from,String to,String etmDelivaryDate){
        this.name = name;
        this.from = from;
        this.to = to;
        this.etmDelivaryDate = etmDelivaryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getEtmDelivaryDate() {
        return etmDelivaryDate;
    }

    public void setEtmDelivaryDate(String etmDelivaryDate) {
        this.etmDelivaryDate = etmDelivaryDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
