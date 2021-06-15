package com.mid_banchers.pk_discount;

public class DataModelBrand {

    String brandName;
    Double id;
    String image;

    public DataModelBrand() {
    }

    public DataModelBrand(String brandName, Double id, String image) {
        this.brandName = brandName;
        this.id = id;
        this.image = image;
    }

    public String getBrandName() {
        return brandName;
    }

    public Double getId() {
        return id;
    }

    public String getImage() {
        return image;
    }
}
