package OperationModule;

import ExceptionModule.InsufficientMoneyException;

public class Action {
    private Ticket ticket;
    private Payment payment;
    private Information information;
    
    public Action(){
        ticket = null;
        payment = new Payment();
        information = new Information();
    }

    public Object createTicket(Ticket t){
        ticket = t;
        return ticket;
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
