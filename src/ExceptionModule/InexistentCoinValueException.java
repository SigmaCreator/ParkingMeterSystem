
package ExceptionModule;

public class InexistentCoinValueException extends RuntimeException {

    public InexistentCoinValueException(String s) {
        super(s);
    }
    
}
