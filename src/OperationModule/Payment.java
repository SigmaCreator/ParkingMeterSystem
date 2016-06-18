package OperationModule;

import ResourceModule.Time;
import ResourceModule.Money;

import ExceptionModule.InsufficientMoneyException;
import ExceptionModule.NonExistentActionException;

class Payment { //OK
    Bank bank;
    Card card;
    
    public Payment(){ 
        bank = new Bank(); 
        card = null;
    }
    
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
    
    public int getFee(Object time, Object incrementTime, int incrementFee) {
        int minutes = ((Time) time).getTimeInMinutes();
        int incrementMinutes = ((Time) incrementTime).getTimeInMinutes();
        int fee = (minutes / incrementMinutes) * incrementFee;
        return fee;
    }

    public int getChange(Object money, int fee) throws InsufficientMoneyException {
        int value = 0;
        
        for(Money m : ((Money[]) money))
            value = value + m.getCoin() * m.getQuantity();
        
        if(value < fee)
            throw new InsufficientMoneyException("Valor insuficiente");
        
        int change = value - fee;
        
        return change;
    }
    
}
