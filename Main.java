/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static int totaltime(int maxweight,int weight,int maxtimetohalt){
        int totaltime=0;
        if(weight > (maxweight/100)*75){  //if weight 75 don't reduce any %
            totaltime=maxtimetohalt;
            //System.out.println("<75%");
            //System.out.println("total time - "+totaltime);
            
        }
        
        else if( ( (maxweight/100)*50 <= weight) && weight <= (maxweight/100)*75 ){  //if weight 50<w<75 -10% in maxweight
            totaltime = Math.abs( ( (maxtimetohalt/100)*10 )-maxtimetohalt );
            //System.out.println("<75%");
            //System.out.println("total time - "+totaltime);
            
        }
        
        else if( (weight<(maxweight/100)*50) ){                            //if weight 50<w<75 -20% in maxweight
            totaltime = Math.abs( ( (maxtimetohalt/100)*20 )-maxtimetohalt );
            //System.out.println("<75%");
            //System.out.println("total time - "+totaltime);
            
        }
        
        //System.out.println("total seconds (+10 sec) - "+(totaltime+10));    
        return (totaltime+10);
    }
    
    public static Runway findrunway(ArrayList<Runway> runWays,int totaltime){
        
        Runway currentrunway=null;
        for(Runway r:runWays)
            if(r.time>=totaltime && r.status==true)
            {
                currentrunway=r;
                break;
            }
        return currentrunway;
    }
    
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    ArrayList<Runway> runWays = new ArrayList<Runway>();
	    Runway r1=new Runway(); // Create Object for Separate Runway
	    Runway r2=new Runway();
	    Runway r3=new Runway();
	    Runway r4=new Runway();
	    
	    r1.runwayID="Runway one";
	    r1.time=40;
	    
	    r2.runwayID="Runway two";
	    r2.time=60;
	    
	    r3.runwayID="Runway three";
	    r3.time=80;
	    
	    r4.runwayID="Runway four";
	    r4.time=90;
	    
	    runWays.add(r1);
	    runWays.add(r2);
	    runWays.add(r3);
	    runWays.add(r4);
	    
	   //for(Runway r:runWays){
	        //System.out.println("Runway ID : "+r.runwayID+"   Time for Takeoff and Landing : "+r.time+"  Status :"+r.status);}
	   
	   while(true){  
	   System.out.println("1. Take off\n2. Landing \n3. Emergency Landing \n4. Show Runway");
	   int option=sc.nextInt();
	   
	   switch(option){
	       
	       case 1: case 2: case 3:{
	           sc.nextLine();
	           System.out.println("Enter name of flight");
	           String flightname=sc.nextLine();
	           flightname=flightname.toLowerCase();  //flight name convert to lowercase
	           
	           System.out.println("Enter weight of flight(in tons)");
	           int weight=sc.nextInt(); //current weight of the flight
	           
	           int maxweight=0;  //max weight to each flight
	           int maxtimetohalt=0;   //max time to half for each flight
	           int totaltime=0; // total timetaken flight occupied a runway
	           
	           if(flightname.equals("atr"))  // atr flight
	           {
	               maxweight=12;  //max weight of the flight
	               maxtimetohalt=30;
	               totaltime=totaltime(maxweight,weight,maxtimetohalt); // # important #
                }
                
                if(flightname.equals("airbus")) // Airbus flight
	           {
	               maxweight=20;  
	               maxtimetohalt=40;
	               totaltime=totaltime(maxweight,weight,maxtimetohalt); 
                }
                
                if(flightname.equals("boeing")) // boeing flight
	           {
	               maxweight=40;  
	               maxtimetohalt=50;
	               totaltime=totaltime(maxweight,weight,maxtimetohalt); 
                }
                
                if(flightname.equals("cargo")) //cargo flight
	           {
	               maxweight=100;  
	               maxtimetohalt=60;
	               totaltime=totaltime(maxweight,weight,maxtimetohalt); 
                }
                
            
                
               Runway currentrunway=findrunway(runWays,totaltime);  // # important #
               
               if(currentrunway==null)
               {
                    System.out.println("Runway Not Available -- Try after sometimes");
                    break;
               }
               currentrunway.time=totaltime;
               currentrunway.status=false;
               try{currentrunway.start();}catch(Exception e){}
               
               System.out.println("----------------------------------------------------------------------------------");
               if(option==1)
                    System.out.println("Take off Approved for "+flightname+" with "+weight+" tons of weight in "+currentrunway.runwayID);
               
               else if(option==2)
                    System.out.println("Landing Approved for "+flightname+" with "+weight+" tons of weight in "+currentrunway.runwayID);
               
               else if(option==3)
                     System.out.println("Emergency Landing Approved for "+flightname+" with "+weight+" tons of weight in "+currentrunway.runwayID);
        
               
               System.out.println("Touch down will happen in 15 sec");
               System.out.println("the plane with stop after "+totaltime+ " sec of touch down");
               System.out.println("run way one will be ready for next request in "+(totaltime+15)+" sec (+15 seconds)");
               System.out.println("----------------------------------------------------------------------------------");
               break;
               
               
	           
	                
	        }//case 01
	         case 4:
	             System.out.println();
	             System.out.println("----------------------------------------");
	             for(Runway r: runWays)
	             {
	                if(r.status==true)
	                    System.out.println(r.runwayID+" is free");
	                else
	                    System.out.println(r.runwayID+" is busy");
	             } //for loop
	             System.out.println("----------------------------------------");
	             System.out.println();
	             break;
	             
	          //case 03
	         
	       
	   }//switch
	   
	   } //while
	   
	        
	    
	    
	    
	    
	    
	    
	    
	}
}
