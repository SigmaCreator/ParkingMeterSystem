package ResourceModule;

import ExceptionModule.InexistentCoinValueException;

public class Money {
    private int coin;
    private int quantity;
    
    //@ensures signal (InexistentCoinValueException e) ( coin != 5  && coin != 10 && coin != 25 && coin != 50 && coin != 100 ); 
    //@also
    //@ensures this.coin = coin;
    //@ensures this.quantity = quantity;
    public Money(int coin, int quantity) throws InexistentCoinValueException{
       if( coin != 5  && coin != 10 && coin != 25 && coin != 50 && coin != 100 )
            throw new InexistentCoinValueException("Valor de moeda inválido");
       this.coin = coin;
       this.quantity = quantity;
    }
    
    /*@ pure @*/
    public int getCoin(){ return coin; }
    
    /*@ pure @*/
    public int getQuantity(){ return quantity; }
    
    //@ensures getQuantity() == \old(getQuantity()) + quantity;
    public void add(int quantity){ this.quantity = this.quantity + quantity; }
    
    //@ensures getQuantity() == \old(getQuantity()) - quantity;
    public void sub(int quantity){ this.quantity = this.quantity - quantity; }
    
    
}
