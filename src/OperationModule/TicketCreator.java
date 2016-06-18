package OperationModule;

import ExceptionModule.NoThatSWrongException;

public class TicketCreator { //OK!
    
    public String create(Object[] info, Integer[] id, String address) throws NoThatSWrongException{
            Ticket ticket = new Ticket(info,id,address);
            return ticket.toString();
    }
   
}
