package OperationModule;

import PersistenceModule.PaymentDAODerby;
import ResourceModule.Time;
import ResourceModule.Money;

import ExceptionModule.InsufficientMoneyException;
import ExceptionModule.NonExistentActionException;

class Payment { //OK
    Bank bank;
    Card card;
    PaymentDAO paymentDAO;
 
    //@ensures paymentDAO == new PaymentDAODerby()
    //@ensures bank == new Bank() 
    //@ensures card == null
    public Payment(){ 
        paymentDAO = new PaymentDAODerby();
        bank = new Bank(); 
        card = null;
    }
    
    //@requires info[0] == 1
    //
    //@ensures bank.getFunds == \old(bank.getFundas) + 
    //@ensures \result == result
    //@also
    //@requires info[0] == 2
    //
    //@ensures card == new Card((int[]) info[2] , (int) info[3])
    //@ensures card.getFunds == \old(card.getFunds) - fee
    //@ensures bank.getCardFunds == \old(bank.getCardFunds) + fee
    //@ensures \result = result
    public Object defineAction(Object[] info, int fee, int change) throws Exception {
        // 1 - pay with money
        // 2 - pay with card 
        // 3 - check funds
        
        Object result = new Object();
        
        switch((int) info[0]){
            case 1: result = bank.deposit( (Object[]) info[2] , change );
                    break;
            
            case 2: card = new Card((int[]) info[2] , (int) info[3]);                  
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

    //@requires value > fee
    //
    //@ensures \result == change
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
