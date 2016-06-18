package ResourceModule;

public class Logger {
    StringBuffer log;
    
    public Logger(){ log = new StringBuffer(); }

    public void update(int act, String error) {
        log.append("==============================\n");
        
        String action = "";
        
        switch(act){
                case 1  : action = "Geramento de Ticket"; break;
                case 2  : action = "Pagamento"; break;
                case 3  : action = "Acessamento ao Banco de Informações"; break;
                default : action = "Ação inválida";
            }
        
        log.append("Não foi possível realizar a ação: " + action + "\n");
        
        log.append("Causa do erro:" + error + "\n");
        
    }

    public void update(int act, Object result) {
        log.append("==============================\n");
        
            switch(act){
                case 1  : log.append("Ação realizada: Geramento de Ticket \n"); 
                          log.append("Ticket gerado:\n");
                          log.append(result);                          
                          break;
                          
                case 2  : 
                          
                          log.append("Ação realizada: Pagamento \n");
                          log.append(((Object[]) result)[0]);
                          log.append(((Object[]) result)[1]);
                          break;
                          
                case 3  : log.append("Ação realizada: Acessamento ao Banco de Informações \n");
                          break;
                default : log.append("Ação realizada: Ação inválida \n");
            }
            
        log.append("==============================\n");


        
    }
    
    public String toString(){
        return log.toString();
    }
    
}
