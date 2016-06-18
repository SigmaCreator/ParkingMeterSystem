package OperationModule;

class InformationModifier { //OK
    
    private Information information;

    InformationModifier(Information information) {
        this.information = information;
    }
    
    public Object getStartHour(){
        return information.getStartHour();
    }
    
    public void setStartHour(Object startHour){
        information.setStartHour(startHour);
    }
    
    public Object getFinishHour() {
        return information.getFinishHour();
    }
    
    public void setFinishHour(Object finishHour) {
        information.setFinishHour(finishHour);
    }
    
    public Object getMinTime() {
        return information.getMinTime();
    }
    
    public void setMinTime(Object minTime) {
        information.setMinTime(minTime);
    }
    
    public Object getMaxTime() {
        return information.getMaxTime();
    }

    public void setMaxTime(Object maxTime) {
        information.setMaxTime(maxTime);
    }

    public Object getIncrement() {
        return information.getIncrement();
    }

    public void setIncrement(Object increment) {
        information.setIncrement(increment);
    }
    
    public int getIncrementFee() {
        return information.getIncrementFee();
    }
    
    public void setIncrementFee(int incrementFee) {
        information.setIncrementFee(incrementFee);
    }

    
        
}
