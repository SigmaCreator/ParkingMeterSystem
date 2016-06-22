package ResourceModule;

import java.util.Calendar;

public class Logger {
    StringBuffer log;
    Calendar calendar;
    
    public Logger(String ini){ log = new StringBuffer(ini); }

    //@requires error != null;
    public void update(Exception error) {
        calendar = Calendar.getInstance();
        log.append(System.lineSeparator());
        log.append("Log_Date:");
        log.append(calendar.get(Calendar.MONTH)+1);
        log.append("-");
        log.append(calendar.get(Calendar.DATE));
        log.append("-");
        log.append(calendar.get(Calendar.YEAR));
        log.append(" ");
        log.append(calendar.get(Calendar.HOUR)).append(":");
        log.append(calendar.get(Calendar.MINUTE)).append(":");
        log.append(calendar.get(Calendar.SECOND));
        log.append(System.lineSeparator());
        log.append("==============================");
        log.append(System.lineSeparator());
        log.append("Não foi possível realizar o pagamento");
        log.append(System.lineSeparator());
        log.append("Causa do erro:");
        log.append(error.getMessage());
        log.append(System.lineSeparator());
        
    }

    //@requires newLog != null;
    public void update(String newLog) {
        
        calendar = Calendar.getInstance();
        log.append(System.lineSeparator()).append("Log Date ");
        log.append(calendar.get(Calendar.MONTH)+1);
        log.append("-");
        log.append(calendar.get(Calendar.DATE));
        log.append("-");
        log.append(calendar.get(Calendar.YEAR));
        log.append(" ");
        log.append(calendar.get(Calendar.HOUR)).append(":");
        log.append(calendar.get(Calendar.MINUTE)).append(":");
        log.append(calendar.get(Calendar.SECOND));
        log.append(System.lineSeparator());
        log.append("==============================");
        log.append(System.lineSeparator());
        log.append(newLog);
        
    }
    
    /*@ pure @*/
    public String toString(){
        return log.toString();
    }
    
}
