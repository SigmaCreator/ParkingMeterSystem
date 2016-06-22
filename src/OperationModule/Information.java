package OperationModule;

import PersistenceModule.InfoDAODerby;
import ResourceModule.Time;

class Information { //OK!
    
    private static Information instance;
    private final InfoDAO infoDAO;
    
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
        infoDAO      = new InfoDAODerby();
        initialize();
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

    //@ensures 
    private void initialize() {
        String[] aux = ((String)infoDAO.get("SH")).split("h");
        startHour    = new Time(Integer.parseInt(aux[0]), Integer.parseInt(aux[1].substring(0, 2)));
        aux = ((String)infoDAO.get("FH")).split("h");
        finishHour   = new Time(Integer.parseInt(aux[0]), Integer.parseInt(aux[1].substring(0, 2)));
        aux =((String)infoDAO.get("MinT")).split("h");
        minTime      = new Time(Integer.parseInt(aux[0]), Integer.parseInt(aux[1].substring(0, 2)));
        aux = ((String)infoDAO.get("MaxT")).split("h");
        maxTime      = new Time(Integer.parseInt(aux[0]), Integer.parseInt(aux[1].substring(0, 2)));
        aux = ((String)infoDAO.get("IC")).split("h");
        increment    = new Time(Integer.parseInt(aux[0]), Integer.parseInt(aux[1].substring(0, 2)));
        int ic = Integer.parseInt((String)infoDAO.get("ICF"));
        incrementFee = ic;
    }

    /*@ pure @*/
    public Time getFinishHour() {
        return finishHour;
    }

    /*@ pure @*/
    public Time getMinTime() {
        return minTime;
    }

    /*@ pure @*/
    public Time getMaxTime() {
        return maxTime;
    }

    /*@ pure @*/
    public Time getIncrement() {
        return increment;
    }
    
    /*@ pure @*/
    public int getIncrementFee() {
        return incrementFee;
    }
    
}
