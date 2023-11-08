package com.moderneinstein.logical.numerical ;

import java.util.Arrays ; 
import java.util.TreeMap ;
import java.util.Map  ; 
import java.util.Vector ; 
import java.util.ArrayList ; 
import java.util.List ;
import java.lang.Integer ;
import java.io.File ;
import java.io.Serializable ; 
import java.io.OutputStream ;
import java.io.PrintStream ;

/* public static Functional functional = new Functional(); 
    public static Manipulate manipulate = new Manipulate();  */

public class Interpolation{
   
    public static Double[][] tests = new Double[][]{new Double[]{8.7,18.82091},new Double[]{8.6,18.50515}, 
    new Double[]{8.3,17.56492},new Double[]{8.1,16.94410}} ;       
    public static String called= new String("R") ;
    public static File file4 = new File("Interpolation.txt") ;
    public static PrintStream freads = System.out ;  
	// 			 List<Pair<Double,Integer>> temp = new Vector<Pair<Double,Integer>>(); 
	public static List<Pair<Double,Integer>> lagrange(List<Double[]> values,String[] buffers){
       	 printValues(values,buffers) ;    
			List<Pair<Double,Integer>> product = new Vector<Pair<Double,Integer>>() ; 
		List<Double> listed = new ArrayList<Double>(); 
		for(int n=0;n<values.size();n++){	
			Double[] content = values.get(n) ; 
			listed.add(content[0]) ;	}
		   for(int v=0 ;v<values.size();v++){
			Double[] content = values.get(v) ; 
			 List<Pair<Double,Integer>> temp  =  polynomial(listed,v,buffers) ;
			for(int s=0;s<temp.size();s++){
				temp.get(s).first = temp.get(s).first*content[1]; }
			product = Functional.summation(product,temp) ; 
			Manipulate.appendString (Manipulate.functionToString(called,product),buffers) ;
 			}
        Manipulate.sort(product) ;
		return product ;  
		}  
		// Manipulate.printFunction(new  String(called),product ,freads ) ; 
		// 		List<Pair<Double,Integer>> replica  =  new Vector<Pair<Double,Integer>>()  ; 
	public static List<Pair<Double,Integer>> polynomial(List<Double> values,int point,String[] cross){
			List<Pair<Double,Integer>> numerator = Manipulate.createFunction(new double[]{1.0},new int[]{0}) ; 
			Double denominator =1.0 ; 
			Double value =values.get(point)  ; 
			TreeMap<Integer,Double> treeMap= new TreeMap<Integer,Double>() ; 
			for(int d=0 ;d<values.size();d++){	
				double digit = values.get(d) ; 
	 			if(d==point){    	continue ;	}
				List<Pair<Double,Integer>> replica = Manipulate.createFunction(new double[]{1.0,digit*-1},new int[]{1,0}) ;
				numerator= Functional.multiply(numerator,replica) ; 
				Functional.insertMap(treeMap,numerator) ;
				Functional.flatten(treeMap, numerator ) ;
				denominator = denominator*((double)(value-digit)) ;	
               Manipulate.appendString(Manipulate.functionToString(called,numerator),cross) ;
                }
		for(int n=0;n<numerator.size();n++){
			Pair<Double,Integer> fred = numerator.get(n) ; 
			fred.first  = fred.first/denominator ; 	}
            Manipulate.appendString(Manipulate.functionToString( called,numerator),cross) ;
		return numerator ; 
		}
        public static void printValues(List<Double[]> values,String[] cores){
            Double[] content = new Double[2] ; 
            int height = values.size() ;  
			StringBuilder builder = new StringBuilder()  ; 
            builder.append("\n The values provides were :  \n") ;
            builder.append(new String("[ \n")) ; 
            for(int c=0;c<values.size();c++){
                content = values.get(c) ; 
                builder.append(new String("[ ")) ;
                builder.append(Double.toString(content[0]) )  ; 
                builder.append(new String(" , " )) ;
                builder.append(String.valueOf(content[1])) ;
                builder.append(new String(" ]\n")) ;
            }
           builder.append(new String(" ] \n")) ;  
		   Manipulate.appendString(builder.toString(),cores)  ;
        } 
			// 		   Manipulate.appendString(Manipulate.functionToString( ),cores)  ;
        /*
         * newPair.first = newPair.first-other  ; 
				listed.add(newPair) ; 
                sort(listed) ;
                                System.out.append(new String("\n")) ;
                 //   Manipulate.printFunction(new String(called),temp,)  ;
         */
    
}