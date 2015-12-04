package com.crosser.brian.shakennotstirred.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name = "Store")
public class StoreModel {

    @Element(name ="Storename")
    public String storename;

    @Element(name ="Address")
    public String address;

    @Element(name ="City")
    public String city;

    @Element(name ="State")
    public String state;

    @Element(name ="Zip")
    public String zip;

    @Element(name ="Phone")
    public String phone;

    @Element(name ="StoreId")
    public String storeId;

    public StoreModel() {}

    public String getStoreId() {
        return storeId;
    }

    public String getStorename(){
        return storename;
    }

    public String getAddress(){
        return address;
    }

    public String getCity(){
        return city;
    }

    public String getState(){ return state; }

    public String getZip() { return zip; }

    public String getPhone() { return phone; }

    public void setStoreId(int storeID) { this.storeId = storeId; }

    public void setStorename(String storename) { this.storename = storename; }

    public void setAddress(String address) { this.address = address; }

    public void setCity(String city) { this.city = city; }

    public void setState(String state) { this.state = state; }

    public void setZip(String zip) { this.zip = zip; }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
