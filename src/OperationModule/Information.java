package OperationModule;

import ResourceModule.Time;

class Information { //OK!
    
    private static Information instance;
    
    private Time startHour;
    private Time finishHour;
    private Time minTime;   
    private Time maxTime;    
    private Time increment;
    private int  incrementFee;

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
