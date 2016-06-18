package OperationModule;

import ExceptionModule.SerialNumberLengthIsNotEnough;

public interface CardDAO{
      public void addCard(Card c, int fee) throws SerialNumberLengthIsNotEnough;
}

