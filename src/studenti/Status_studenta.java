package studenti;

public enum Status_studenta{
    //this will call enum constructor with one String argument
    B("B"), S("S");
 
    private String status;
 
    public String getStatus(){
        return this.status;
    }
 
    // enum constructor - can not be public or protected
    Status_studenta(String status){
        this.status = status;
    }
    
    @Override
    public String toString() {
    	return getStatus();
    }
}