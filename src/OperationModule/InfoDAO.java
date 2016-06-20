package OperationModule;

import ExceptionModule.NonExistentInformationException;

public interface InfoDAO{
    
    public Object get(String label) throws NonExistentInformationException;

}