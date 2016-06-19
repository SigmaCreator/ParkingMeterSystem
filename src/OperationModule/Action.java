package OperationModule;

import ExceptionModule.InsufficientMoneyException;
import ExceptionModule.NoThatSWrongException;

public class Action {
    private Ticket ticket;
    private Payment payment;
    private Information information;
    
    //@ensures ticket == null
    //@ensures payment == new Payment()
    //@ensures information == new Information()
    public Action(){
        ticket = null;
        payment = new Payment();
        information = new Information();
    }

    public Object createTicket(Object time, Object serialNumber, Integer[] id, String address) throws NoThatSWrongException{
        ticket = new Ticket(time, (int[]) serialNumber, id, address);
        return ticket.print();
    }
    
    /*@ pure @*/
    public Payment getPayment() {
        return payment;
    }

    /*@ pure @*/
    public Information getInformation() {
        return information;
    }

    //@ensures incrementTime == information.getIncrement()
    //@ensures incrementFee == information.getIncrementFee()
    //@ensures \result == payment.getFee(time, incrementTime, incrementFee)
    public int getFee(Object time) {
        Object incrementTime = information.getIncrement();
        int incrementFee = information.getIncrementFee();
        return payment.getFee(time, incrementTime, incrementFee);
    }

    //@ensures \result == payment.getChange(money,fee)
    public int getChange(Object money, int fee) throws InsufficientMoneyException {
        return payment.getChange(money,fee);
    }
    
    /*@ pure @*/
    public void updateDAO(Object[] o, double fee, double change){
        ticket.updateDAO();
        payment.updateDAO(o, fee, change);
    }
    
}
