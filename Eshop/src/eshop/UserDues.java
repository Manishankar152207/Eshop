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
class UserDues {
    private int id,duesamt,day,month,year,creditamt;
    public UserDues(int id,int duesamt,int day,int month,int year,int creditamt){
        this.id=id;
        this.duesamt=duesamt;
        this.day=day;
        this.month=month;
        this.year=year;
        this.creditamt=creditamt;
    }
    public int getid(){
        return id;
    }
    public int getduesamt(){
        return duesamt;
    }
    public int getday(){
        return day;
    }
    public int getmonth(){
        return month;
    }
    public int getyear(){
        return year;
    }
    public int getcreditamt(){
        return creditamt;
    }
    
}
