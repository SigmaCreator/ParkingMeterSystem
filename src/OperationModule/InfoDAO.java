package OperationModule;

import ExceptionModule.NonExistentInformationException;

public interface InfoDAO{
    
    /*@ pure @*/
    public Object get(String label) throws NonExistentInformationException;

}