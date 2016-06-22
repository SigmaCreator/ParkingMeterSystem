/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResourceModule;

import ExceptionModule.NoThatSWrongException;

public class Time {
    private int hour;
    private int minute;
    
    public Time(int hour, int minute) throws NoThatSWrongException{
        if(hour < 0 || minute < 0)
            throw new NoThatSWrongException("Tempo inválido");
        this.hour = hour;
        this.minute = minute;
    }
    
    /*@ pure @*/
    public int getMinute(){ return minute; }
    
    /*@ pure @*/
    public int getHour(){ return hour; }
    
    //@ensures \result == getHour()*60 + getMinute();
    public int getTimeInMinutes(){ return hour * 60 + minute; }
    
    //@requires time != null;
    //@ensures (\old(getMinute())+time.getMinute())/60 > 0 ==> getMinute() == (\old(getMinute())+time.getMinute())%60;
    //@ensures \old(getMinute())/60 <=0 ==> getMinute() == \old(getMinute())+time.getMinute();
    //@ensures (\old(getMinute())+time.getMinute())/60 > 0 ==> getHour() == \old(getHour())+\old(getMinute())/60 +time.getHour();
    //@ensures \old(getMinute())/60 <=0 ==> getHour() == \old(getHour())+time.getHour();
    public void add(Time time){
        minute = minute + time.getMinute();
        int newHour = (minute / 60);
        if( newHour > 0 ){ 
            hour = hour + newHour; 
            minute = (minute % 60);
        }
        hour = hour + time.getHour();
    }
    
    //@requires time != null
    //@ensures time.getMinute()/60 >0 ==> getHour() == \old(getHour())-time.getHour()-time.getMinute()/60;
    //@ensures time.getMinute()/60 <= 0 ==> getHour() == \old(getHour())-time.getHour();
    //@ensures time.getMinute()/60 >0 ==> getMinute() == \old(getMinute()) - (time.getMinute() %60);
    public void sub(Time time){
        hour = hour - time.getHour();
        int newHour = (time.getMinute() / 60) ;
        if( newHour > 0 ){
            hour = hour - newHour;
            minute = minute - (time.getMinute() % 60);
        }
    }
    
    /*@ pure @*/
    public String toString(){
        StringBuffer time = new StringBuffer();
        
        time.append(hour + "h");
        
        time.append(minute + "min");
        
        return time.toString();
    }
}
