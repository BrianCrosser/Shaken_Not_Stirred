package com.crosser.brian.shakennotstirred.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Product_Commercial")
public class SupermarketModel {

    @Element(name ="ItemID")
    public String itemID;

    @Element(name ="Itemname")
    public String itemName;

    @Element(name ="ItemDescription")
    public String itemDescription;

    @Element(name ="ItemCategory")
    public String itemCategory;

    @Element(name ="ItemImage")
    public String itemImage;

    @Element(name ="AisleNumber")
    public String aisleNumber;

    @Element(name ="Pricing")
    public String pricing;

    public SupermarketModel() {}

    public String getItemId() {
        return itemID;
    }

    public String getItemName(){
        return itemName;
    }

    public String getItemCategory(){
        return itemCategory;
    }

    public String getItemImage(){
        return itemImage;
    }

    public String getItemDescription(){ return itemDescription; }

    public String getAisleNumber() { return aisleNumber; }

    public String getPricing() { return pricing; }


    public void setItemID(String itemID) { this.itemID = itemID; }

    public void setItemName(String itemName) { this.itemName = itemName; }

    public void setItemCategory(String itemCategory) { this.itemCategory = itemCategory; }

    public void setItemImage(String itemImage) { this.itemImage = itemImage; }

    public void setItemDescription(String itemDescription) { this.itemDescription = itemDescription; }

    public void setAisleNumber(String aisleNumber) { this.aisleNumber = aisleNumber; }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

}
