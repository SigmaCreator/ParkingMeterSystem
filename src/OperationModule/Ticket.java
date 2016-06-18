package OperationModule;

import ExceptionModule.NoThatSWrongException;
import ResourceModule.Time;

import java.util.Calendar;

public class Ticket { //OK!
    Integer[] id;
    int[] serialNum;
    String address;
    Time emission;
    Time expiration;
    Calendar calendar;
    
    public Ticket(Object[] info, Integer[] id, String address) throws NoThatSWrongException{
        calendar = Calendar.getInstance();
        this.id = id;
        this.address = address;
        serialNum = (int[]) info[0];
        emission = new Time(calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE));
        expiration = new Time(0,0);
        expiration.add(emission);
        expiration.add((Time) info[1]);
    }
    
    public String create(Object[] info, Integer[] id, String address) throws NoThatSWrongException{
            Ticket ticket = new Ticket(info,id,address);
            return ticket.toString();
    }
    
    public String print() {
        
        StringBuffer ticket = null;
        
        StringBuffer aux = null;
        
        for(Integer i : id) aux.append(i);
        
        ticket.append("____________________________________________________\n");
        
        ticket.append("| ID do Parquímetro :").append(aux).append("\n");
        
        ticket.append("| Endereço do Parquímetro :").append(address).append("\n");
        
        aux = null;
        
        for(int i : serialNum)  aux.append(i);
        
        ticket.append("| Número Serial do Ticket: ").append(aux).append("\n");
        
        ticket.append("| Horário de emissão :").append(emission.toString()).append("\n");
        
        ticket.append("| Horário de validade :").append(expiration.toString()).append("\n");
        
        ticket.append("____________________________________________________\n");
        
        return ticket.toString();
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(Integer i : id) sb.append(i);
        sb.append(";").append(address).append(";");
        for(int i : serialNum) sb.append(i);
        sb.append(";").append(emission.toString()).append(";");
        sb.append(expiration.toString()).append(";");
        
        //id;address;serial;emission;expiration;
        return sb.toString();
    }
}
