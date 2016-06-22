package OperationModule;

import PersistenceModule.LoggerDAODerby;
import ResourceModule.Logger;
import ExceptionModule.InvalidIDException;

public class ParkingMeter {
    private Integer[]  id;
    private String address;
    private Action action;
    private Logger logger;
    private LoggerDAO logDAO;

    //@ensures logger == new Logger("ID: "+Arrays.toString(id) +"\nEndereço: "+address+"\n");
    //@ensures logDAO == new LoggerDAODerby();
    public ParkingMeter(Integer[] id, String address) {
        this.address = address;
        this.id = id;
        String idString="";
        for(int i : id)
            idString+=i;
        logger = new Logger("ID:"+idString +"\nEndereço: "+address+"\n");
        logDAO = new LoggerDAODerby();
        action = new Action();
    }

    /*@ pure @*/
    public Integer[] getID() {
        return id;
    }

    //@ensures getId() == id;
    //@ensures signals (NullPointerException e) id == null;
    //@ensures signals (InvalidIDException e) id.length < 5;
    public void setID(Integer[] id) throws InvalidIDException {
        if(id == null)
            throw new NullPointerException("ID está nulo");
        if( id.length < 5 )
            throw new InvalidIDException("ID possui menos de 5 digitos");
        for(Integer i : id)
            if( i > 9 || i < 0 )
                throw new InvalidIDException("Dígito do ID inválido: " + i);
        
        this.id = id;
    }

    /*@ pure @*/
    public String getAddress() {
        return address;
    }

    //@ensures getAddress() == address;
    //@ensures signals (NullPointerException e) address == null;
    public void setAddress(String address) {
        if(address == null)
            throw new NullPointerException("Endereço está nulo");
        this.address = address;
    }

    /*@ pure @*/
    public Logger getLogger() {
        return logger;
    }

    //@ensures signals (NullPointerException e) info == null;
    //@ensures signals (NullPointerException e) 
    
    //@ensures result[0] == action.getPayment().defineAction(info,fee,change)
    //@ensures result[1] == action.createTicket(totalIncrementTime,ticketSerialNumber,id,address)
    //@ensures \result == result
    public Object[] act(Object[] info) throws Exception {
        if(info == null)  throw new NullPointerException("Informações estão nulas");
        
        for(Object o : info) if(o == null) throw new NullPointerException("Faltam informações");
        
        Object[] result  = new Object[2];
        StringBuffer log = new StringBuffer();
        
        
        try{
            
            Object definePaymentType   = info[0];
            Object totalIncrementTime  = info[1];
            Object serialNumberOrValue = info[2];
            Object fundsOrNothing      = info[3];
            Object ticketSerialNumber  = info[4];
                
            int fee = action.getFee(totalIncrementTime);
            
            log.append(System.lineSeparator());
            log.append("Tarifa:").append(fee);
            log.append(System.lineSeparator());
            int change=0, paid=0;
            
            if( (int) definePaymentType == 1 ){
                change = action.getChange(serialNumberOrValue,fee);
                paid = action.getPaidValue(info[2], change);
            }else {
                change = 0;
                paid = fee;
            }
            result[0] = action.getPayment().defineAction(info,fee,change);
                    
            if( (int) definePaymentType == 1 ){
                log.append("Pagamento em dinheiro");
                log.append(System.lineSeparator());
            }else {
                log.append("Pagamento em cartão");
                    
                log.append(System.lineSeparator());
                log.append((String) result[0]);
                    
                log.append(System.lineSeparator());
            }    
            
            log.append("Valor arrecadado:").append(paid);
                    
            result[1] = action.createTicket(totalIncrementTime,ticketSerialNumber,id,address);
            
            log.append(System.lineSeparator());
            log.append("Informações do Ticket:");
            
            log.append(System.lineSeparator());
            log.append(result[1]);
            action.updateDAO(info, fee, change);
        } catch(Throwable e) { 
            logger.update((Exception) e);
            logDAO.addLog(logger);
            throw e;
        }
        
        logger.update(log.toString());
        logDAO.addLog(logger);
        
        return result;
    }
}
