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
    
    public int getMinute(){ return minute; }
    
    public int getHour(){ return hour; }
    
    public int getTimeInMinutes(){ return hour * 60 + minute; }
    
    public void add(Time time){
        minute = minute + time.getMinute();
        int newHour = (minute / 60);
        if( newHour > 0 ){ 
            hour = hour + newHour; 
            minute = (minute % 60);
        }
        hour = hour + time.getHour();
    }
    
    public void sub(Time time){
        hour = hour - time.getHour();
        int newHour = (time.getMinute() / 60) ;
        if( newHour > 0 ){
            hour = hour - newHour;
            minute = minute - (time.getMinute() % 60);
        }
    }
    
    @Override
    public String toString(){
        StringBuffer time = new StringBuffer();
        
        time.append(hour + "h");
        
        time.append(minute + "min");
        
        return time.toString();
    }
}
