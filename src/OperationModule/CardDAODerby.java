package OperationModule;

import ExceptionModule.NegativeCardFundsException;
import ExceptionModule.NotEnoughCardFundsException;
import ExceptionModule.SerialNumberLengthIsNotEnough;

class CardDAODerby implements CardDAO { //OK

    Card card;

    public CardDAODerby() {
    }

    public String setCard(int[] serialNum, int funds) throws SerialNumberLengthIsNotEnough, NegativeCardFundsException {
        card = new Card(serialNum, funds);
        return card.toString();
    }

    public int getFunds() {
        return card.getFunds();
    }

    public int[] getSerialNum() {
        return card.getSerialNum();
    }

    public Boolean setSerialNum(int[] serialNum) {
        return card.setSerialNum(serialNum);
    }

    public Boolean addFunds(int value) {
        return card.addFunds(value);
    }

    public void subFunds(int value) throws NotEnoughCardFundsException {
        card.subFunds(value);
    }

}
