package OperationModule;

import ResourceModule.Logger;
import UpdateModule.LogUpdater;
import ExceptionModule.IDLengthIsNotEnoughException;
import ExceptionModule.NonExistentActionException;

public class ParkingMeter {
    private Integer[]  id;
    private String address;
    private Action action;
    private Logger logger;
    private LogUpdater logUpdater;

    public ParkingMeter(Logger logger) { 
        if(logger == null)
            throw new NullPointerException("Logger está nulo"); 
        action = new Action(); 
        this.logger = logger;
        
    }

    public Integer[] getID() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Logger getLogger() {
        return logger;
    }
    
    public Boolean setID(Integer[] id) throws IDLengthIsNotEnoughException {
        if(id == null)
            throw new NullPointerException("ID está nulo");
        if( id.length < 5 )
            throw new IDLengthIsNotEnoughException("ID possui menos de 5 digitos");
        this.id = id;
        return true;
    }
    
    public void setAddress(String address) {
        if(address == null)
            throw new NullPointerException("Endereço está nulo");
        this.address = address; 
    }

    public Object act(int act, Object[] info) throws Exception{
        if(info == null)
            throw new NullPointerException("Informações estão nulas");
        
        for(Object o : info)
            if(o == null)
                throw new NullPointerException("Faltam informações");
        
        // info[0] = int[] serialNum (Ticket) , int defineAction (Payment,Information)
        // info[1] = Time totalIncrementTime (Ticket,Payment), int defineField (Information)
        // info[2] = X (Ticket), int[] serialNum || Money[] value (Payment), ????? || X (Information)
        // info[3] = X (Ticket,Information), int funds || X (Payment)
        Object result = new Object();
        try{
        switch(act){
            case 1: result = action.createTicket(info, id, address); //OK
                    break;
                
            case 2: int fee = action.getFee(info[1]);
                    int change;
                    
                    if( (int) info[0] == 1 )
                        change = action.getChange(info[2],fee);
                    else 
                        change = 0;
                    
                    result = action.getPayment().defineAction(info,fee,change);
                    break;
                
            case 3: result = action.getInformation().defineAction(info); //OK
                    break;
                
            default: throw new NonExistentActionException("Ação não existente");
        }
        }catch(Exception e){
            if( result != null ) logger.update(act,result);
            else logger.update(act,e.getMessage());
        }
        
        sendLog();
        
        return result;
    }
    
    public void sendLog(){
        logUpdater.sendLog(id,logger);
    }
    
    
}
