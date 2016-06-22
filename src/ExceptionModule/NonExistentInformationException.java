package ExceptionModule;

public class NonExistentInformationException extends RuntimeException {

    public NonExistentInformationException(String s) {
        super(s);
    }
    
}
