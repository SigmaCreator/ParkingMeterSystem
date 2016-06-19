package OperationModule;

import ExceptionModule.NegativeCardFundsException;
import ExceptionModule.SerialNumberLengthIsNotEnough;
import ExceptionModule.NotEnoughCardFundsException;

class Card {    //OK
    private int[] serialNum;
    private int funds;
    private CardDAO cardDAO;

    //@requires seriaNum.length == 128
    //@requires funds >= 0
    //
    //@ensures this.serialNum == serialNum
    //@ensures this.funds == funds
    //2ensures cardDAO == new CardDAODerby()
    public Card(int[] serialNum, int funds) throws SerialNumberLengthIsNotEnough, NegativeCardFundsException {
        if( serialNum.length < 128 || serialNum.length > 128 )
            throw new SerialNumberLengthIsNotEnough("Número Serial inválido de cartão");
        
        if( funds < 0 )
            throw new NegativeCardFundsException("Cartão com saldo negativo");
        
        this.serialNum = serialNum;
        this.funds = funds;
        cardDAO = new CardDAODerby();
    }

    /*@ pure @*/
    public int getFunds() {
        return funds;
    }
    
    /*@ pure @*/
    public int[] getSerialNum() {
        return serialNum;
    }

    public void subFunds(int value) throws NotEnoughCardFundsException {
        
        if ( (funds - value) < 0 )
            throw new NotEnoughCardFundsException("Saldo insuficiente");
        
        funds = funds - value;
    }
    
    //@ensures \result == s.toString()
    public String print() {
        StringBuffer s = null;
        
        s.append("Número Serial do Cartão: ");
        
        for(int i : serialNum)
            s.append(i);
        
        s.append("\n");
        s.append("Saldo: ");
        s.append(funds);
        
        return s.toString();
    }
    
    /*@ pure @*/
    public String toString(){
        StringBuffer s = new StringBuffer();
        
        for(int i: serialNum)
           s.append(i);
        s.append(";");
        s.append(funds).append(";");
        return s.toString();
    }

    /*@ pure @*/
    public void updateDAO(double fee) {
        cardDAO.addCard(this, fee);
    }
    
}
