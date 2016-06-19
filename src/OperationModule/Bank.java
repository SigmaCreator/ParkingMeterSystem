package OperationModule;

import PersistenceModule.BankDAODerby;
import ResourceModule.Money;

public class Bank { // OK
    private Money[] funds;
    private int cardFunds;
    private BankDAO bankDAO;
    
    //@ensures funds == new Money[5];
    //@ensures funds[0] == new Money(100,0);
    //@ensures funds[1] == new Money(50,0);
    //@ensures funds[2] == new Money(25,0);
    //@ensures funds[3] == new Money(10,0);
    //@ensures funds[4] == new Money(5,0);
    //@ensures cardFunds == 0;
    //@ensures bankDAO == new BankDAODerby();
    public Bank(){ 
        funds = new Money[5];
        funds[0] = new Money(100,0);
        funds[1] = new Money(50,0);
        funds[2] = new Money(25,0);
        funds[3] = new Money(10,0);
        funds[4] = new Money(5,0);
        
        cardFunds = 0;
        
        bankDAO = new BankDAODerby();
    }
    
    //@ensures \result == result
    public Object[] deposit(Object[] money, int change) {
        
        Object[] result = new Object[3];
        
        Money aux;
        for(Object o : money){
            aux = (Money) o;
            for(Money m : funds){
                if( m.getCoin() == aux.getCoin() ) m.add(aux.getQuantity());
            }
        }
        
        double sum = 0;
        
        for(Money m : (Money[]) money)
            sum = sum + m.getCoin() * m.getQuantity();
        
        result[0] = "Dinheiro colocado: " + sum / 100.0;
        
        Object result2 = debit(change);
        
        sum = 0;
        
        for(Money m : (Money[]) result2)
            sum = sum + m.getCoin() * m.getQuantity();
        
        result[1] = "Troco: " + sum;
        
        result[2] = result2;
        
        return result;
        
    } // Depósito com dinheiro
    
    //@ensures aux >= 0 || aux <= change
    //@ensures \result = debit
    private Money[] debit(int change){
        int aux = change;
        Money[] debit = new Money[5];
        
        debit[0] = new Money(100,0);
        debit[1] = new Money(50,0);
        debit[2] = new Money(25,0);
        debit[3] = new Money(10,0);
        debit[4] = new Money(5,0);
        
        int x = 0;
        
         while ( funds[x].getCoin() < aux ) {             
            if ( aux == 0 || x >= funds.length ) {
                break;
            }
            
            if ( funds[x].getCoin() > aux || funds[x].getQuantity() == 0 ) {
                x++;
                continue;
            }    
            
            funds[x].sub(1);
            debit[x].add(1);
            aux = aux - funds[x].getCoin();
        }
         
        return debit;
    } // Debita do banco o valor de troco

    //@ensures getCardFunds() == \old(getCardFunds) + funds
    public void deposit(int funds) {
        cardFunds = cardFunds + funds;
    } // Depósito com cartão

    /*@ pure @*/
    public Object getFunds() {
        return funds;
    }  // Retorna todas as moedas existentes no parquímetro
    
    /*@ pure @*/
    public int getCardFunds(){
        return cardFunds;
    }
    
    /*@ pure @*/
    public Object allMoney() {
        int total = 0;
        
        for(Money m : funds)
            total = total + m.getCoin() * m.getQuantity();
        
        total = total + cardFunds;
        
        return total;
    } // Retorna todo dinheiro arrecadado
    
    //@ensures \result == s.toString()
    public String print(){
        StringBuilder s = new StringBuilder();
        
        for(Money m : funds) {
            s.append("Quantidade de moedas de ");
            s.append(m.getCoin());
            s.append(" : ");
            s.append(m.getQuantity());
            s.append("\n");
        }
        
            s.append("Total arrecadado por pagamento em cartão: ");
            s.append(cardFunds);
            s.append("\n");
            s.append("Total arrecadado: ");
            s.append((int) allMoney());
            s.append("\n");
        
        return s.toString();
    }
    
    /*@ pure @*/
    public String toString() {
        StringBuffer sb = new StringBuffer();
        String label;
        for(Money m: funds){
            label = "M"+m.getCoin();
            sb.append(label).append(":").append(m.getQuantity()).append("\n");   
        }
        sb.append("C:").append(cardFunds);
        sb.append("\nT:").append((int)allMoney());
        return sb.toString();
    }
    
    /*@ pure @*/
    public void updateDAO(){
        bankDAO.update(this);
    }
    
}
