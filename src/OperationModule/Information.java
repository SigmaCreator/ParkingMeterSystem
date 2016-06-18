package OperationModule;

import ResourceModule.Time;

class Information { //OK!
    
    private static Information instance;
    
    private Time startHour; //SH
    private Time finishHour; //FH
    private Time minTime;   //MinT
    private Time maxTime;    //MaxT
    private Time increment;  //IC
    private int  incrementFee;  //ICF
    
    protected Information(){
        startHour    = null;
        finishHour   = null;
        minTime      = null; 
        maxTime      = null;  
        increment    = null;
        incrementFee = 0;
    }
    
    public static Information getInstance(){
        if(instance == null)
            instance = new Information();
        
        return instance;
    }

    public Object defineAction(Object[] info) {
        if( (int) info[0] == 1 ){ //getter
            switch( (int) info[1] ){
                case 0: return getStartHour();
                case 1: return getFinishHour();
                case 2: return getMinTime();
                case 3: return getMaxTime();
                case 4: return getIncrement();
                case 5: return getIncrementFee();
                default: return null;
            }
        }
        else if( (int) info[0] == 2){ //setter
            switch( (int) info[1] ){
                case 0: setStartHour(info[2]); 
                        return true;
                        
                case 1: setFinishHour(info[2]);
                        return true;
                        
                case 2: setMinTime(info[2]);
                        return true;
                        
                case 3: setMaxTime(info[2]);
                        return true;
                        
                case 4: setIncrement(info[2]);
                        return true;
                        
                case 5: setIncrementFee((int)info[2]);
                
                default: return false;
            }
        }
        
        return null;
    }
    
    public Time getStartHour() {
        return startHour;
    }

    public void setStartHour(Object startHour) {
        if(startHour == null)
            throw new NullPointerException("Hora de Início está nula");
        this.startHour = (Time) startHour;
    }

    public Time getFinishHour() {
        return finishHour;
    }

    public void setFinishHour(Object finishHour) {
        if(finishHour == null)
            throw new NullPointerException("Hora de Término está nula");
        this.finishHour = (Time) finishHour;
    }

    public Time getMinTime() {
        return minTime;
    }

    public void setMinTime(Object minTime) {
        if(minTime == null)
            throw new NullPointerException("Tempo mínimo está nulo");
        this.minTime = (Time) minTime;
    }

    public Time getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Object maxTime) {
        if(maxTime == null)
            throw new NullPointerException("Tempo máximo está nulo");
        this.maxTime = (Time) maxTime;
    }

    public Time getIncrement() {
        return increment;
    }

    public void setIncrement(Object increment) {
        if(increment == null)
            throw new NullPointerException("Incremento está nulo");
        this.increment = (Time) increment;
    }
    
    public int getIncrementFee() {
        return incrementFee;
    }
    
    public void setIncrementFee(int incrementFee) {
        if(incrementFee == 0 || incrementFee < 0)
            throw new NullPointerException("Taxa de incremento está nula ou é menor que zero");
        this.incrementFee = incrementFee;
    }

}
