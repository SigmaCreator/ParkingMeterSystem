package ResourceModule;

public class Money {
    int coin;
    int quantity;
    
    public Money(int coin, int quantity){
       this.coin = coin;
       this.quantity = quantity;
    }
    
    public int getCoin(){ return coin; }
    
    public int getQuantity(){ return quantity; }
    
    public void add(int quantity){ this.quantity = this.quantity + quantity; }
    
    public void sub(int quantity){ this.quantity = this.quantity - quantity; }
    
}
