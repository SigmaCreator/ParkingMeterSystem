package OperationModule;

import PersistenceModule.InfoDAODerby;
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
    
    //@ensures startHour    == null
    //@ensures finishHour   == null
    //@ensures minTime      == null
    //@ensures maxTime      == null 
    //@ensures increment    == null
    //@ensures incrementFee == 0
    //@ensures infoDAO      == new InfoDAODerby()
    protected Information(){
        startHour    = null;
        finishHour   = null;
        minTime      = null; 
        maxTime      = null;  
        increment    = null;
        incrementFee = 0;
        infoDAO      = new InfoDAODerby();
    }
    
    /*@ pure @*/
    public static Information getInstance(){
        if(instance == null)
            instance = new Information();
        
        return instance;
    }
    
    /*@ pure @*/
    public Time getStartHour() {
        return startHour;
    }

    //@requires startHour != null
    //
    //@ensures getStartHour() == (Time) startHour
    public void setStartHour(Object startHour) {
        if(startHour == null)
            throw new NullPointerException("Hora de Início está nula");
        this.startHour = (Time) startHour;
        infoDAO.set("SH", this.startHour.toString());
    }

    /*@ pure @*/
    public Time getFinishHour() {
        return finishHour;
    }

    //@requires finishHour != null
    //
    //@ensures getFinishHour() == (Time) finishHour
    public void setFinishHour(Object finishHour) {
        if(finishHour == null)
            throw new NullPointerException("Hora de Término está nula");
        this.finishHour = (Time) finishHour;
        infoDAO.set("FH", this.finishHour.toString());
    }

    /*@ pure @*/
    public Time getMinTime() {
        return minTime;
    }

    //@requires minTime != null
    //
    //@ensures getMinTime() == (Time) minTime
    public void setMinTime(Object minTime) {
        if(minTime == null)
            throw new NullPointerException("Tempo mínimo está nulo");
        this.minTime = (Time) minTime;
        infoDAO.set("MinT", this.minTime.toString());
    }

    /*@ pure @*/
    public Time getMaxTime() {
        return maxTime;
    }

    //@requires maxTime != null
    //
    //@ensures getMaxTime() == (Time) maxTime
    public void setMaxTime(Object maxTime) {
        if(maxTime == null)
            throw new NullPointerException("Tempo máximo está nulo");
        this.maxTime = (Time) maxTime;
        infoDAO.set("MaxT", this.maxTime.toString());
    }

    /*@ pure @*/
    public Time getIncrement() {
        return increment;
    }

    //@requires increment != null
    //
    //@ensures getIncrement() == (Time) increment
    public void setIncrement(Object increment) {
        if(increment == null)
            throw new NullPointerException("Incremento está nulo");
        this.increment = (Time) increment;
        infoDAO.set("IC", this.increment.toString());
    }
    
    /*@ pure @*/
    public int getIncrementFee() {
        return incrementFee;
    }
    
    //@requires incrementFee != null
    //
    //@ensures getIncrementFee() = incrementFee
    public void setIncrementFee(int incrementFee) {
        if(incrementFee == 0 || incrementFee < 0)
            throw new NullPointerException("Taxa de incremento está nula ou é menor que zero");
        this.incrementFee = incrementFee;
        infoDAO.set("ICF", this.incrementFee);
    }
    
}
