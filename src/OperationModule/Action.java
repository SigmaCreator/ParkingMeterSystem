package OperationModule;

import ExceptionModule.InsufficientMoneyException;
import ExceptionModule.NoThatSWrongException;

public class Action {
    private Ticket ticket;
    private Payment payment;
    private Information information;
    
    public Action(){
        ticket = null;
        payment = new Payment();
        information = new Information();
    }

    public Object createTicket(Object time, Object serialNumber, Integer[] id, String address) throws NoThatSWrongException{
        ticket = new Ticket(time, (int[]) serialNumber, id, address);
        return ticket.print();
    }
    
    public Payment getPayment() {
        return payment;
    }

    public Information getInformation() {
        return information;
    }

    public int getFee(Object time) {
        Object incrementTime = information.getIncrement();
        int incrementFee = information.getIncrementFee();
        return payment.getFee(time, incrementTime, incrementFee);
    }

    public int getChange(Object money, int fee) throws InsufficientMoneyException {
        return payment.getChange(money,fee);
    }
    
    
}
