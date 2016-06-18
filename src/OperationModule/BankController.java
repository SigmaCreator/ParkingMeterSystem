package OperationModule;

class BankController { //OK
    BankModifier bankModifier;
    Bank bank;
    
    public BankController(){ bankModifier = new BankModifier(bank); bank = new Bank(); }

    public Object[] deposit(Object[] money,int change){
        return bankModifier.deposit(money,change);
    }
    
    public Object deposit(int funds){
        return bankModifier.deposit(funds);
    }

    public Object getFunds(){
        return bankModifier.getFunds();
    }

    public Object allMoney() {
        return bankModifier.allMoney();
    }
}
  
