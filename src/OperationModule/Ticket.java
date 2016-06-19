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
    TicketDAO ticketDAO;
    
    //@ensures ticketDAO == new TicketDAODerby();
    //@ensures calendar == Calendar.getInstance();
    //@ensures this.id == id;
    //@ensures this.address == address;
    //@ensures serialNum == serialNumber;
    //@ensures emission == new Time(calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE));
    //@ensures expiration == 
    public Ticket(Object totalIncrement, int[] serialNumber, Integer[] id, String address) throws NoThatSWrongException{
        ticketDAO = new TicketDAODerby();
        calendar = Calendar.getInstance();
        this.id = id;
        this.address = address;
        serialNum = serialNumber;
        emission = new Time(calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE));
        expiration = new Time(0,0);
        expiration.add(emission);
        expiration.add((Time) totalIncrement);
    }
    
    /*@ pure @*/
    public void updateDAO(){
        ticketDAO.add(this);
    }
    
    //@ensures \result == ticket.toString()
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
    
    //@ensures \result == sb.toString()
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
