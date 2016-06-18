package OperationModule;

import ResourceModule.Time;
import ResourceModule.Money;

import ExceptionModule.InsufficientMoneyException;

class Payment { //OK
    BankController bankController;
    CardController cardController;
    
    public Payment(){ 
        bankController = new BankController(); 
        cardController = new CardController();
    }
    
    public Object[] defineAction(Object[] info, int fee, int change) throws Exception {
        // 1 - pay with money
        // 2 - pay with card 
        // 3 - check funds
        Object[] result;
        
        switch((int) info[0]){
            case 1:  result = bankController.deposit( (Object[]) info[2] , change );
                     break;
            
            case 2:  result = new Object[2];
                     result[0] = "Informações do Cartão: \n" + cardController.setCard( (int[]) info[2] , (int) info[3] );
                     result[1] = "Valor pago: " + fee + "\n" + "Saldo do cartão após pagamento: " + cardController.getFunds();
                     cardController.subFunds(fee);
                     bankController.deposit(fee);
                     break;
                
            case 3:  result = new Object[1];
                     result[0] = bankController.getFunds();
                     break;
            
            case 4:  result = new Object[1];
                     result[0] = bankController.allMoney();
                     break;
            
            default: result = null;
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
