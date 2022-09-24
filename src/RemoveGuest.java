public class RemoveGuest extends Guest{
    public void clearGuest(Guest g){

        if(guests.remove(g)){
            guests.remove(guests.indexOf(g)); 
        }  
    } 
    public void clearAllGuests(){
        guests.clear();
    }
    
}
