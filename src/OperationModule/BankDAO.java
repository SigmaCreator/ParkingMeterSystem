package OperationModule;

public interface BankDAO {
    void update(Bank bank);
}





/*class BankModifier { // OK
    Bank bank;
    
    public BankModifier(Bank bank){
        this.bank = bank;
    }

    public Object[] deposit(Object[] money, int change) {
        bank.deposit(money,change);
        return null;
        
    }

    public Object deposit(int funds) {
        return bank.deposit(funds);
    }

    public Object getFunds() {
        return bank.getFunds();
    }

    public Object allMoney() {
        return bank.allMoney();
    }
    
}*/
