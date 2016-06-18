package OperationModule;

interface TicketDAO {
    void add(Ticket t);
    Ticket[] getAll(String label);
}
