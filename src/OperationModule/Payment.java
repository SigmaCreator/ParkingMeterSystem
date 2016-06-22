package OperationModule;

import ExceptionModule.InexistentCoinValueException;
import PersistenceModule.PaymentDAODerby;
import ResourceModule.Time;
import ResourceModule.Money;

import ExceptionModule.InsufficientMoneyException;
import ExceptionModule.NegativeCardFundsException;
import ExceptionModule.NonExistentActionException;
import ExceptionModule.NotEnoughCardFundsException;
import ExceptionModule.InvalidSerialNumberException;

class Payment { //OK
    Bank bank;
    Card card;
    PaymentDAO paymentDAO;
 
    //@ensures paymentDAO == new PaymentDAODerby();
    //@ensures bank == new Bank() ;
    //@ensures card == null;
    public Payment() throws InexistentCoinValueException{ 
        paymentDAO = new PaymentDAODerby();
        bank = new Bank(); 
        card = null;
    }
    
    //@requires coins != null;
    public int getPaidValue(Object coins, int change){
        int result=0;
        for(Money c: (Money[])coins)
            result+=c.getCoin()*c.getQuantity();
        return result-change;
    }
    
    
    
    //@requires info[0] == 1;
    //
    //@ensures bank.getFunds() == \old(bank.getFunds) + getPaidValue(info[2], change);
    
    //@also
    //@requires info[0] == 2;
    //
    //@ensures card == new Card((int[]) info[2] , (int) info[3]);
    //@ensures card.getFunds == \old(card.getFunds) - fee;
    //@ensures bank.getCardFunds == \old(bank.getCardFunds) + fee;
    //@also
    //@ensures signals (NonExistentActionException e) info[0] != 1 && info[0] != 2;
    public Object defineAction(Object[] info, int fee, int change) throws InvalidSerialNumberException, NotEnoughCardFundsException, NegativeCardFundsException {
        // 1 - pay with money
        // 2 - pay with card
        
        Object result = new Object();
        
        switch((int) info[0]){
            case 1: result = bank.deposit( (Object[]) info[2] , change );
                    break;
            
            case 2: card = new Card((Integer[]) info[2] , (int) info[3]);                  
                    result = "Número do Cartão: \n" + card.getSerialNum() + "\n Saldo: " + card.getFunds() + "; \n";
                    card.subFunds(fee);
                    bank.deposit(fee);
                    result = result + "Valor pago: " + fee + "\n" + "Saldo do cartão após pagamento: " + card.getFunds();
                    break;
            
            default: throw new NonExistentActionException("Ação não existente");
        }
   
        return result;
    }
    
    //@ensures \result = (((Time) time).getTimeInMinutes() / ((Time) incrementTime).getTimeInMinutes()) * incrementFee
    public int getFee(Object time, Object incrementTime, int incrementFee) {
        int minutes = ((Time) time).getTimeInMinutes();
        int incrementMinutes = ((Time) incrementTime).getTimeInMinutes();
        int fee = (minutes / incrementMinutes) * incrementFee;
        return fee;
    }

    //@ensures \result == change
    //@ensures signals (InsufficientMoneyException e) value < fee
    public int getChange(Object money, int fee) throws InsufficientMoneyException {
        int value = 0;
        
        for(Money m : ((Money[]) money))
            value = value + m.getCoin() * m.getQuantity();
        
        if(value < fee)
            throw new InsufficientMoneyException("Valor insuficiente");
        
        int change = value - fee;
        
        return change;
    }
    
    /*@ pure @*/
    public void updateDAO(Object[] o, int fee, int change){
        paymentDAO.addPayment(o, fee, change);
        if((int)o[0]!= 1)card.updateDAO(fee);
        bank.updateDAO();
    }
    
}
