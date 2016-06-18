package OperationModule;

import ResourceModule.Money;

class Bank { // OK
    Money[] funds;
    int cardFunds;
    
    public Bank(){ 
        funds = new Money[5];
        funds[0] = new Money(100,0);
        funds[1] = new Money(50,0);
        funds[2] = new Money(25,0);
        funds[3] = new Money(10,0);
        funds[4] = new Money(5,0);
        
        cardFunds = 0;
        
    }
    
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

    public void deposit(int funds) {
        cardFunds = cardFunds + funds;
    } // Depósito com cartão

    public Object getFunds() {
        return funds;
    }  // Retorna todas as moedas existentes no parquímetro

    public Object allMoney() {
        int total = 0;
        
        for(Money m : funds)
            total = total + m.getCoin() * m.getQuantity();
        
        total = total + cardFunds;
        
        return total;
    } // Retorna todo dinheiro arrecadado
    
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
    
    // public String toString() {}
    
    
}
