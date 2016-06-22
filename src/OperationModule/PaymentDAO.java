
package OperationModule;

public interface PaymentDAO {
    /*@ pure @*/ void addPayment(Object[] info, int fee, int change);
}
