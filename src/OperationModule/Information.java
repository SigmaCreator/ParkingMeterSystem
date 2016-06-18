package OperationModule;

import ResourceModule.Time;

class Information { //OK!
    
    private static Information instance;
    private InfoDAO infoDAO;
    
    private Time startHour;     //SH
    private Time finishHour;    //FH
    private Time minTime;       //MinT
    private Time maxTime;       //MaxT
    private Time increment;     //IC
    private int  incrementFee;  //ICF
    
    protected Information(){
        startHour    = null;
        finishHour   = null;
        minTime      = null; 
        maxTime      = null;  
        increment    = null;
        incrementFee = 0;
        infoDAO      = new InfoDAODerby();
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
        infoDAO.set("SH", this.startHour.toString());
    }

    public Time getFinishHour() {
        return finishHour;
    }

    public void setFinishHour(Object finishHour) {
        if(finishHour == null)
            throw new NullPointerException("Hora de Término está nula");
        this.finishHour = (Time) finishHour;
        infoDAO.set("FH", this.finishHour.toString());
    }

    public Time getMinTime() {
        return minTime;
    }

    public void setMinTime(Object minTime) {
        if(minTime == null)
            throw new NullPointerException("Tempo mínimo está nulo");
        this.minTime = (Time) minTime;
        infoDAO.set("MinT", this.minTime.toString());
    }

    public Time getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Object maxTime) {
        if(maxTime == null)
            throw new NullPointerException("Tempo máximo está nulo");
        this.maxTime = (Time) maxTime;
        infoDAO.set("MaxT", this.maxTime.toString());
    }

    public Time getIncrement() {
        return increment;
    }

    public void setIncrement(Object increment) {
        if(increment == null)
            throw new NullPointerException("Incremento está nulo");
        this.increment = (Time) increment;
        infoDAO.set("IC", this.increment.toString());
    }
    
    public int getIncrementFee() {
        return incrementFee;
    }
    
    public void setIncrementFee(int incrementFee) {
        if(incrementFee == 0 || incrementFee < 0)
            throw new NullPointerException("Taxa de incremento está nula ou é menor que zero");
        this.incrementFee = incrementFee;
        infoDAO.set("ICF", this.incrementFee);
    }
    
}
