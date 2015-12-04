package com.crosser.brian.shakennotstirred.Models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "ArrayOfStore")
public class StoreResultModel {

    @ElementList(inline = true)
    ArrayList<StoreModel> searchStoresResults;


//    @Root(name = "ArrayOfStore")
//    ArrayList<StoreModel> searchStoresResults;

    public ArrayList<StoreModel> getSearchStoresResults(){
        return searchStoresResults;
    }

    public void setSearchStoresResults(ArrayList<StoreModel> searchStoresResults){
        this.searchStoresResults = searchStoresResults;
    }
}
