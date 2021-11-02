/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eshop;

/**
 *
 * @author acer
 */
class User {
    private int itemcode,tax,price;
    private String name,company,model;
    
    public User(int itemcode,String name,String company,String model,int tax,int price){
        this.itemcode=itemcode;
        this.name=name;
        this.company=company;
        this.model=model;
        this.tax=tax;
        this.price=price;
    }
    public int getitemcode(){
        return itemcode;
    }
    public String getname(){
        return name;
    }
    public String getcompany(){
        return company;
    }
    public String getmodel(){
        return model;
    }
    public int gettax(){
        return tax;
    }
    public int getprice(){
        return price;
    }
   
}
