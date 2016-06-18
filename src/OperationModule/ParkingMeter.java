package OperationModule;

import ResourceModule.Logger;
import ExceptionModule.IDLengthIsNotEnoughException;

public class ParkingMeter {
    private Integer[]  id;
    private String address;
    private Action action;
    private Logger logger;

    public ParkingMeter(Logger logger) { 
        if(logger == null)
            throw new NullPointerException("Logger está nulo"); 
        action = new Action(); 
        this.logger = logger;
        
    }

    public Integer[] getID() {
        return id;
    }
    
    public Boolean setID(Integer[] id) throws IDLengthIsNotEnoughException {
        if(id == null)
            throw new NullPointerException("ID está nulo");
        if( id.length < 5 )
            throw new IDLengthIsNotEnoughException("ID possui menos de 5 digitos");
        this.id = id;
        return true;
    }

    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        if(address == null)
            throw new NullPointerException("Endereço está nulo");
        this.address = address; 
    }

    public Logger getLogger() {
        return logger;
    }

    public Object[] act(Object[] info) throws Exception {
        if(info == null)  throw new NullPointerException("Informações estão nulas");
        
        for(Object o : info) if(o == null) throw new NullPointerException("Faltam informações");
        
        Object[] result  = new Object[2];
        StringBuilder log = new StringBuilder();
        
        try{
            
            Object definePaymentType   = info[0];
            Object totalIncrementTime  = info[1];
            Object serialNumberOrValue = info[2];
            Object fundsOrNothing      = info[3];
            Object ticketSerialNumber  = info[4];
                
            int fee = action.getFee(totalIncrementTime);
            int change;
                    
            if( (int) definePaymentType == 1 )
                change = action.getChange(serialNumberOrValue,fee);
            else 
                change = 0;
                    
            result[0] = action.getPayment().defineAction(info,fee,change);
                    
            if( (int) definePaymentType == 1 )
                log.append("Pagamento em dinheiro \n");
            else {
                log.append("Pagamento em cartão \n");
                log.append((String) result[0]);
            }    
                    
            result[1] = action.createTicket(totalIncrementTime,ticketSerialNumber,id,address);
                    
            log.append("\n Informações do Ticket: \n");
            log.append(((Ticket) result[1]).print());
                  
        } catch(Exception e) { 
            logger.update(e); 
        }
        
        logger.update(log.toString());
                
        return result;
    }
    
    
}
