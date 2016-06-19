package OperationModule;

import ExceptionModule.NoThatSWrongException;
import ResourceModule.Time;

import java.util.Calendar;

public class Ticket { //OK!
    private Integer[] id;
    private int[] serialNum;
    private String address;
    private Time emission;
    private Time expiration;
    private Calendar calendar;
    private TicketDAO ticketDAO;
    
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
    
    public void updateDAO(){
        ticketDAO.add(this);
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
