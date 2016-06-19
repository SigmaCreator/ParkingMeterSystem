
package OperationModule;

public interface PaymentDAO {
    /*@ pure @*/ void addPayment(Object[] info, double fee, double change);
}
