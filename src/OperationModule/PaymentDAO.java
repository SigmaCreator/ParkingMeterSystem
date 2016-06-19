
package OperationModule;

public interface PaymentDAO {
    void addPayment(Object[] info, double fee, double change);
}
