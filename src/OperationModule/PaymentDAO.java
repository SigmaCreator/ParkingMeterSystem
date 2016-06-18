/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperationModule;

/**
 *
 * @author Pedro
 */
public interface PaymentDAO {
    void addPayment(Object[] info, double fee, double change);
}
