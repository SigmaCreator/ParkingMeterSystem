package OperationModule;

public interface TicketDAO {
    /*@ pure @*/ void add(Ticket t);
    /*@ pure @*/ Ticket[] getAll(String label);
}
