package ResourceModule;

import java.util.Calendar;

public class Logger {
    StringBuffer log;
    Calendar calendar;
    
    public Logger(String ini){ log = new StringBuffer(ini); }

    public void update(Exception error) {
        
        calendar = Calendar.getInstance();
        log.append("Log_Date:");
        log.append(calendar.get(Calendar.MONTH));
        log.append("-");
        log.append(calendar.get(Calendar.DATE));
        log.append("-");
        log.append(calendar.get(Calendar.YEAR));
        log.append(" ");
        log.append(calendar.get(Calendar.HOUR)).append(":");
        log.append(calendar.get(Calendar.MINUTE)).append(":");
        log.append(calendar.get(Calendar.SECOND));
        log.append("\n");
        log.append("==============================\n");
        log.append("Não foi possível realizar o pagamento \n");
        log.append("Causa do erro:" + error.getMessage() + "\n");
        
    }

    public void update(String newLog) {
        
        calendar = Calendar.getInstance();
        log.append("\nLog Date ");
        log.append(calendar.getTime().toString());
        log.append("\n");
        log.append("==============================\n");
        log.append(newLog);
        
    }
    
    public String toString(){
        return log.toString();
    }
    
}
