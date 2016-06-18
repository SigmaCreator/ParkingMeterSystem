package OperationModule;

class InformationController { //OK
    
    private Information information;
    private InformationModifier informationModifier;
    
    public InformationController(){
        information = Information.getInstance();
        informationModifier = new InformationModifier(information);
    }
    
    public Information getInformationInstance(){ return information; }
    
    public InformationModifier getInformationModifierInstance(){ return informationModifier; }

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
    
    private Object getStartHour(){
        return informationModifier.getStartHour();
    } // 0
    
    private void setStartHour(Object startHour){
        informationModifier.setStartHour(startHour);
    } //0
    
    private Object getFinishHour() {
        return informationModifier.getFinishHour();
    } // 1
    
    private void setFinishHour(Object finishHour) {
        informationModifier.setFinishHour(finishHour);
    } // 1
    
    private Object getMinTime() {
        return informationModifier.getMinTime();
    } // 2
    
    private void setMinTime(Object minTime) {
        informationModifier.setMinTime(minTime);
    } // 2
    
    private Object getMaxTime() {
        return informationModifier.getMaxTime();
    } // 3

    private void setMaxTime(Object maxTime) {
        informationModifier.setMaxTime(maxTime);
    } // 3

    private Object getIncrement() {
        return informationModifier.getIncrement();
    } // 4

    private void setIncrement(Object increment) {
        informationModifier.setIncrement(increment);
    } // 4
    
    private int getIncrementFee() {
        return informationModifier.getIncrementFee();
    } // 5
    
    private void setIncrementFee(int incrementFee) {
        informationModifier.setIncrementFee(incrementFee);
    } // 5
}
