package com.moderneinstein.logical.numerical ;

/**
 * Hello world!
 *
 */ 
 
 import java.util.ArrayList ; 
 import java.util.Vector ;
 import java.util.List ;   

 import org.junit.jupiter.api.Test ; 

//public class App 
public class ClassTest  { 

    public static double[][][] tests5 = new double[][][]{new double[][]{new double[]{2,0},new double[]{2,1},new double[]{2,2},new double[]{2,3}}} ;      

    /*   double trough = Math.pow (0.0,0.0) ; 
       // System.out.println(trough) ;  */
     @Test
    public void trials5(){ 
        for( int tc=0;tc<tests5.length;tc++){
        List<double[]> points = new ArrayList<double[]>( ) ;  
        for(int  fc=0;fc<tests5[tc].length ;fc++){
            points.add (tests5[tc][fc]) ; 
        }   
        Object object6 = Interface.NewtonRaphson4(points) ; 
        Object  object5 = Interface.Bisection4(points) ;   
      } 
       }      


    public static void main( String[] args )
    {
       //    System.out.println( "Hello World!" );
    }
}
