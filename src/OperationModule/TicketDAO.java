/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperationModule;

import ExceptionModule.NoThatSWrongException;

interface TicketDAO {
    void add(Ticket t);
    Ticket[] getAll(String label);
}
