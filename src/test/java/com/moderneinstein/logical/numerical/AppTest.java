package com.moderneinstein.logical.numerical ;

//import static org.junit.Assert.assertTrue;

//import org.junit.Test;

import org.junit.jupiter.api.Test ; 
import java.util.ArrayList  ; 
import java.util.Vector ; 
import java.util.Set ; 
import java.util.List ; 

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */   
     public static double[][][] nested = new double[][][]{new double[][]{new double[]{2,0},new double[]{1,1},new double[]{2,2},new double[]{1,3} }} ; 
     //, 
   //  new double[][]{new double[]{8.7,18.82091},new double[]{8.6,18.50515}, 
   // new double[]{8.3,17.56492},new double[]{8.1,16.94410}} 
    @Test
    public void shouldAnswerWithTrue()
    {
      //  assertTrue( true )  ;
    }   
    //  List<List<double[]>> frames = new ArrayList<List<double[]>>()  ;
    @Test
    public void trials7(){
            int width = nested.length ; 
            for (int cv=0;cv<width;cv++){
                List<double[]>  portion =  new Vector<double[]>() ;
                 for(int cf=0;cf<nested[cv].length;cf++){
                    portion.add(nested[cv][cf]) ;
                 } 
                Object object5 =  Interface.NewtonRaphson4(portion) ; 
                Object object4 = Interface.Interpolation4(portion) ; 
            }
        }
}
