package ResourceModule;

import java.util.Calendar;

public class Logger {
    StringBuffer log;
    Calendar calendar;
    
    public Logger(){ log = new StringBuffer(); }

    public void update(Exception error) {
        
        calendar = Calendar.getInstance();
        log.append("Log Date ");
        log.append(calendar.getTime().toString());
        log.append("\n");
        log.append("==============================\n");
        log.append("Não foi possível realizar o pagamento \n");
        log.append("Causa do erro:" + error.getMessage() + "\n");
        
    }

    public void update(String newLog) {
        
        calendar = Calendar.getInstance();
        log.append("Log Date ");
        log.append(calendar.getTime().toString());
        log.append("\n");
        log.append("==============================\n");
        log.append(newLog);
        
    }
    
    public String toString(){
        return log.toString();
    }
    
}
