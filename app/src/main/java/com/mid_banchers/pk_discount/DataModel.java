package com.mid_banchers.pk_discount;

import java.util.ArrayList;

public class DataModel {

    private String articleName;
    private String articleNo;
    private double brandId;
    private String category;
    private String color;
    private boolean hot_deals;
    private String image;
    private ArrayList<String> link;
    private ArrayList<Double> price;
  //  private double product;
    private String size;
    private String style;
    private boolean trending;
    private String type;
   // private double views;

    public DataModel() {
    }

    public DataModel(String articleName, String articleNo, double brandId, String category, String color, boolean hot_deals, String image, ArrayList<String> link, ArrayList<Double> price, String size, String style, boolean trending, String type) {
        this.articleName = articleName;
        this.articleNo = articleNo;
        this.brandId = brandId;
        this.category = category;
        this.color = color;
        this.hot_deals = hot_deals;
        this.image = image;
        this.link = link;
        this.price = price;
        this.size = size;
        this.style = style;
        this.trending = trending;
        this.type = type;
    }

    public String getArticleName() {
        return articleName;
    }

    public String getArticleNo() {
        return articleNo;
    }

    public double getBrandId() {
        return brandId;
    }

    public String getCategory() {
        return category;
    }

    public String getColor() {
        return color;
    }

    public boolean isHot_deals() {
        return hot_deals;
    }

    public String getImage() {
        return image;
    }

    public ArrayList<String> getLink() {
        return link;
    }

    public ArrayList<Double> getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public String getStyle() {
        return style;
    }

    public boolean isTrending() {
        return trending;
    }

    public String getType() {
        return type;
    }
}
