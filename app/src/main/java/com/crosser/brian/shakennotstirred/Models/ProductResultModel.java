package com.crosser.brian.shakennotstirred.Models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;


@Root(name = "ArrayOfProduct_Commercial")
public class ProductResultModel {

    @ElementList(inline = true)
    ArrayList<SupermarketModel> searchItemResults;

    public ArrayList<SupermarketModel> getSearchItemResults(){
        return searchItemResults;
    }

    public void setSearchItemResults(ArrayList<SupermarketModel> searchItemResults){
        this.searchItemResults = searchItemResults;
    }
}
