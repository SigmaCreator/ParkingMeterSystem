package ResourceModule;

import ExceptionModule.InexistentCoinValueException;

public class Money {
    int coin;
    int quantity;
    
    public Money(int coin, int quantity) throws InexistentCoinValueException{
       if( coin != 5  && coin != 10 && coin != 25 && coin != 50 && coin != 100 )
            throw new InexistentCoinValueException("Valor de moeda inválido");
       this.coin = coin;
       this.quantity = quantity;
    }
    
    public int getCoin(){ return coin; }
    
    public int getQuantity(){ return quantity; }
    
    public void add(int quantity){ this.quantity = this.quantity + quantity; }
    
    public void sub(int quantity){ this.quantity = this.quantity - quantity; }
    
    
}
