package studenti;

public enum Status_studenta{
    //this will call enum constructor with one String argument
    B("B"), S("S");
 
    private String status;
    private int vrednost;
    
    public String getStatus(){
        return this.status;
    }
 
    public int getVrednost() {
    	return this.vrednost;
    }
    
    
    // enum constructor - can not be public or protected
    Status_studenta(String status){
        this.status = status;
        if ("B".equalsIgnoreCase(status)) {
			vrednost = 1;
		}
        else {
        	vrednost = 0;
        }
    }
    
    @Override
    public String toString() {
    	return getStatus();
    }
}