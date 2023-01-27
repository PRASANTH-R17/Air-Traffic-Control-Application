import java.util.*;

class Runway extends Thread{
    String runwayID; 
    int time;              
    boolean status;
    
    public Runway(){
        runwayID="null";
        time=0;
        status=true;
        
    }
    public void run(){
        try{ Thread.sleep(1000*(time+15));} catch(Exception e){};  // add 15 sec for touchdown
        status=true;
        return;
    }
}