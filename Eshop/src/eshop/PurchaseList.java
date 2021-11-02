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
class PurchaseList {
    private String dealer,name,company,model,bill,quantity,price,tax,netprice;
    
    public PurchaseList(String dealer,String bill,String name,String company,String model,String quantity,String price,String tax,String netprice){
        this.dealer=dealer;
        this.bill=bill;
        this.name=name;
        this.company=company;
        this.model=model;
        this.quantity=quantity;
        this.price=price;
        this.tax=tax;
        this.netprice=netprice;
    }
    public String getdealer(){
        return dealer;
    }
    public String getbill(){
        return bill;
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
    public String getquantity(){
        return quantity;
    }
    public String getprice(){
        return price;
    }
    public String gettax(){
        return tax;
    }
    public String getnetprice(){
        return netprice;
    }
    
}
