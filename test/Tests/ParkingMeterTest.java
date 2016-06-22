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
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class ParkingMeterTest{

     private ParkingMeter park;

     @Before
     public void setUp(){
          park = new ParkingMeter();
     }

     //Testes com setID

     @Test(expected = NullPointerException.class)
     public void testSetIDNull() throws InvalidIDException{
          park.setID(null);
     }

     @Test(expected = InvalidIDException.class)
     public void testSetIDInvalid() throws InvalidIDException{
          Integer[] id = new Integer[4];
          park.setID(id);
     }

     @Test(expected = InvalidIDException.class)
     public void testSetIDNumTooBig() throws InvalidIDException{
          Integer[] id = new Integer[5];
          id[0] = 35;
          park.setID(id);
     }

     @Test(expected = InvalidIDException.class)
     public void testSetIDNumTooSmall() throws InvalidIDException{
          Integer[] id = new Integer[5];
          id[0] = -5;
          park.setID(id);
     }

     @Test
     public void testSetIDwork() throws InvalidIDException{
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
     public void testActNullArray() throws Exception{
          park.act(null);
     }

     @Test(expected = NullPointerException.class)
     public void testActNullPosition() throws Exception{
          Object[] info = new Object[5];
          for(int i = 0; i < 5; i++){
               info[i] = i;
          }
          info[3] = null;
          park.act(info);
     }

     @Test
     public void testPayWithMoneywork() throws Exception{
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
     public void testAction() throws Exception{
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
     public void testChange() throws Exception{
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
     public void testSerialNumLengthTooShort() throws Exception{
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
     public void testSerialNumLengthTooBig() throws Exception{
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
     public void testSubFunds() throws Exception{
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
     public void testFundsNegative() throws Exception{
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

     //@Test(expected =  )
     public void testTicketNumInvalid() throws Exception{
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
     public void testInvalidCoin() throws Exception{
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
     
     @Test(expected = NoThatSWrongException.class)
     public void testNegativeHour() throws Exception{
          Object[] info = new Object[5];
          info[0] = 1;
          info[1] = new Time(-5,0);
          info[2] = new Money(100,1);
          info[3] = 0;
          Integer[] vet = {1,2,3,4,5};
          info[4] = vet;
          park.act(info);
     }

     @Test(expected = NoThatSWrongException.class)
     public void testNegativeMinute() throws Exception{
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
