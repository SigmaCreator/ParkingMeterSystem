package OperationModule;

import ExceptionModule.InsufficientMoneyException;

public class Action {
    private TicketCreator ticketCreator;
    private Payment payment;
    private InformationController informationController;
    
    public Action(){
        ticketCreator = new TicketCreator();
        payment = new Payment();
        informationController = new InformationController();
    }
    
    public TicketCreator getTicketCreator() {
        return ticketCreator;
    }

    public Payment getPayment() {
        return payment;
    }

    public InformationController getInformationDefiner() {
        return informationController;
    }

    public int getFee(Object time) {
        Object incrementTime = informationController.getInformationModifierInstance().getIncrement();
        int incrementFee = informationController.getInformationModifierInstance().getIncrementFee();
        return payment.getFee(time, incrementTime, incrementFee);
    }

    public int getChange(Object money, int fee) throws InsufficientMoneyException {
        return payment.getChange(money,fee);
    }
    
    
}
