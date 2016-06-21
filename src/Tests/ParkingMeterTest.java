/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import ExceptionModule.InexistentCoinValueException;
import ExceptionModule.InsufficientMoneyException;
import ExceptionModule.InvalidIDException;
import ExceptionModule.NegativeCardFundsException;
import ExceptionModule.NoThatSWrongException;
import ExceptionModule.NonExistentActionException;
import ExceptionModule.NotEnoughCardFundsException;
import ExceptionModule.SerialNumberLengthIsNotEnough;
import OperationModule.ParkingMeter;
import ResourceModule.Money;
import ResourceModule.Time;

/**
 *
 * @author user
 */
public class ParkingMeterTest{

     private ParkingMeter park;

     @Before
     public void setUp(){
          park = new ParkingMeter();
     }

     //Testes com setID

     @Test(expected = NullPointerException.class)
     public void testSetIDNull(){
          park.setID(null);
     }

     @Test(expected = InvalidIDException.class)
     public void testSetIDInvalid(){
          Integer[] id = new Integer[4];
          park.setID(id);
     }

     @Test(expected = InvalidIDException.class)
     public void testSetIDNumTooBig(){
          Integer[] id = new Integer[5];
          id[0] = 35;
          park.setID(id);
     }

     @Test(expected = InvalidIDException.class)
     public void testSetIDNumTooSmall(){
          Integer[] id = new Integer[5];
          id[0] = -5;
          park.setID(id);
     }

     @Test
     public void testSetIDwork(){
          Integer[] id = new Integer[5];
          for(int i = 0; i < 5; i++){
               id[i] = i;
          }
          park.setID(id);
          assertTrue(park.getID() == id);
     }

     //Testes com setAddress

     @Test(expected = NullPointerException.class)
     public void testAddressNull(){
          park.setAddress(null);
     }

     @Test
     public void testAddresswork(){
          String address = "endereco";
          park.setAddress(address);
          assertTrue(park.getAddress() == address);
     }

     //Testes com act

     @Test(expected = NullPointerException.class)
     public void testActNullArray(){
          park.act(null);
     }

     @Test(expected = NullPointerException.class)
     public void testActNullPosition(){
          Object[] info = new Object[5];
          for(int i = 0; i < 5; i++){
               info[i] = i;
          }
          info[3] = null;
          park.act(info);
     }

     @Test
     public void testPayWithMoneywork(){
          Object[] info = new Object[5];
          info[0] = 1;
          info[1] = new Time(0,10);
          info[2] = new Money(100,1);
          info[3] = 0;
          Integer[] vet = {1,2,3,4,5};
          info[4] = vet;
          park.act(info);
     }

     //Testes de definePaymentType

     @Test(expected = NonExistentActionException.class)
     public void testAction(){
          Object[] info = new Object[5];
          info[0] = 3;
          info[1] = new Time(0,10);
          info[2] = new Money(100,1);
          info[3] = 0;
          Integer[] vet = {1,2,3,4,5};
          info[4] = vet;
          park.act(info);
     }

     //Testes de totalIncrementTime

     @Test
     public void testGetFee(){

     }

     //Testes de serialNumberOrValue

     @Test(expected = InsufficientMoneyException.class)
     public void testChange(){
          Object[] info = new Object[5];
          info[0] = 1;
          info[1] = new Time(0,50);
          info[2] = new Money(5,1);
          info[3] = 0;
          Integer[] vet = {1,2,3,4,5};
          info[4] = vet;
          park.act(info);
     }

     @Test(expected = SerialNumberLengthIsNotEnough.class)
     public void testSerialNumLengthTooShort(){
          Object[] info = new Object[5];
          info[0] = 2;
          info[1] = new Time(0,50);
          Integer[] x = new Integer[123];
          for(int i = 0; i < 123; i++)
               x[i] = i;
          info[2] = x;
          info[3] = 100;
          Integer[] vet = {1,2,3,4,5};
          info[4] = vet;
          park.act(info);
     }

     @Test(expected = SerialNumberLengthIsNotEnough.class)
     public void testSerialNumLengthTooBig(){
          Object[] info = new Object[5];
          info[0] = 2;
          info[1] = new Time(0,50);
          Integer[] x = new Integer[130];
          for(int i = 0; i < 130; i++)
               x[i] = i;
          info[2] = x;
          info[3] = 100;
          Integer[] vet = {1,2,3,4,5};
          info[4] = vet;
          park.act(info);
     }

     //Testes de fundsOrNothing

     @Test(expected = NotEnoughCardFundsException.class)
     public void testSubFunds(){
          Object[] info = new Object[5];
          info[0] = 2;
          info[1] = new Time(0,50);
          Integer[] x = new Integer[128];
          for(int i = 0; i < 128; i++)
               x[i] = i;
          info[2] = x;
          info[3] = 0;
          Integer[] vet = {1,2,3,4,5};
          info[4] = vet;
          park.act(info);
     }

     @Test(expected = NegativeCardFundsException.class)
     public void testFundsNegative(){
          Object[] info = new Object[5];
          info[0] = 2;
          info[1] = new Time(0,50);
          Integer[] x = new Integer[128];
          for(int i = 0; i < 128; i++)
               x[i] = i;
          info[2] = x;
          info[3] = -25;
          Integer[] vet = {1,2,3,4,5};
          info[4] = vet;
          park.act(info);
     }

     //Testes de ticketSerialNumber

     @Test(expected = )
     public void testTicketNumInvalid(){
          Object[] info = new Object[5];
          info[0] = 1;
          info[1] = new Time(0,10);
          info[2] = new Money(100,1);
          info[3] = 0;
          Integer[] vet = {1,2,3,4};
          info[4] = vet;
          park.act(info);
     }

     //Teste com Money

     @Test(expected = InexistentCoinValueException.class)
     public void testInvalidCoin(){
          Object[] info = new Object[5];
          info[0] = 1;
          info[1] = new Time(0,10);
          info[2] = new Money(12,1);
          info[3] = 0;
          Integer[] vet = {1,2,3,4,5};
          info[4] = vet;
          park.act(info);
     }

     //Teste com Time
     
     @Teste(expected = NoThatSWrongException.class)
     public void testNegativeHour(){
          Object[] info = new Object[5];
          info[0] = 1;
          info[1] = new Time(-5,0);
          info[2] = new Money(100,1);
          info[3] = 0;
          Integer[] vet = {1,2,3,4,5};
          info[4] = vet;
          park.act(info);
     }

     @Teste(expected = NoThatSWrongException.class)
     public void testNegativeMinute(){
          Object[] info = new Object[5];
          info[0] = 1;
          info[1] = new Time(0,-10);
          info[2] = new Money(100,1);
          info[3] = 0;
          Integer[] vet = {1,2,3,4,5};
          info[4] = vet;
          park.act(info);
     }



}
