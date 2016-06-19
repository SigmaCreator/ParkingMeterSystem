/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionModule;

/**
 *
 * @author Pedro
 */
public class InvalidLoggerException extends Exception{
    String msg;
    public InvalidLoggerException(String message){
        msg = message;
    }
}
