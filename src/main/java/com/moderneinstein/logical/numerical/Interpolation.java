package com.moderneinstein.logical.numerical ;

import java.util.Arrays ; 
import java.util.TreeMap ;
import java.util.Map  ; 
import java.util.Vector ; 
import java.util.LinkedList ; 
import java.lang.Thread ; 
import java.util.Random; 
import java.lang.NullPointerException ; 
import java.util.ArrayList ; 

import java.util.LinkedList ; 
import java.util.Set ; 
import java.util.TreeSet   ; 
import java.util.Queue ; 
import java.util.Stack ; 
import java.util.HashMap ;

import java.lang.Object  ; 
import java.lang.CloneNotSupportedException ;
import java.lang.Cloneable ;
import java.util.List ;
import java.lang.Integer ;
import java.sql.Date ;
import java.util.TreeSet ;

import java.io.InputStream ; 
import java.io.InputStreamReader ;
import java.io.BufferedReader ; 
import java.io.File ;
import java.io.Serializable ; 
//import java.   ;
import java.util.Scanner ;
import java.io.PrintWriter  ; 
import java.io.IOException  ; 
import java.io.FileInputStream ; 
import java.io.FileOutputStream ; 
import java.io.FileWriter ; 
import java.io.OutputStream ;
import java.io.PrintStream ;
import java.io.FileNotFoundException  ; 
import java.io.OutputStreamWriter ; 
import java.io.PrintWriter ; 
import java.io.BufferedWriter ; 

public class Interpolation{
    public static Functional functional = new Functional(); 
    public static Manipulate manipulate = new Manipulate(); 
    public static Double[][] tests = new Double[][]{new Double[]{8.7,18.82091},new Double[]{8.6,18.50515}, 
    new Double[]{8.3,17.56492},new Double[]{8.1,16.94410}} ;       
    public static String called= new String("R") ;
    public static File file4 = new File("Interpolation.txt") ;
    public static PrintStream freads = System.out ;
	public static List<Pair<Double,Integer>> lagrange(List<Double[]> values){
        printValues(values) ;
			List<Pair<Double,Integer>> product = new Vector<Pair<Double,Integer>>() ; 
		Double[] content = new Double[]{} ; 
		List<Double> listed = new ArrayList<Double>(); 
		for(int n=0;n<values.size();n++){	
			content = values.get(n) ; 
			listed.add(content[0]) ;	}
			 List<Pair<Double,Integer>> temp = new Vector<Pair<Double,Integer>>(); 
		   for(int v=0 ;v<values.size();v++){
			content = values.get(v) ; 
			temp  =  polynomial(listed,v) ;
			for(int s=0;s<temp.size();s++){
				temp.get(s).first = temp.get(s).first*content[1]; }
			product = Functional.summation(product,temp) ; 
			Manipulate.printFunction(new  String(called),product ,freads ) ; 
			}
        Manipulate.sort(product) ;
		return product ; 
		}
	public static List<Pair<Double,Integer>> polynomial(List<Double> values,int point){
			List<Pair<Double,Integer>> numerator = Manipulate.createFunction(new double[]{1.0},new int[]{0}) ; 
			List<Pair<Double,Integer>> replica  =  new Vector<Pair<Double,Integer>>()  ; 
			Double digit = 0.0 ; 
			Double denominator =1.0 ; 
			Double value =values.get(point); 
			TreeMap<Integer,Double> treeMap= new TreeMap<Integer,Double>() ; 
			for(int d=0 ;d<values.size();d++){	
				digit = values.get(d) ; 
				if(d==point){
					continue ;	}
				replica = Manipulate.createFunction(new double[]{1.0,digit*-1},new int[]{1,0}) ;
				numerator= Functional.multiply(numerator,replica) ; 
				Functional.insertMap(treeMap,numerator) ;
				Functional.flatten(treeMap, numerator ) ;
				denominator = denominator*((double)(value-digit)) ;	
                Manipulate.printFunction(called,numerator,freads) ;
                }
		for(int n=0;n<numerator.size();n++){
			Pair<Double,Integer> fred = numerator.get(n) ; 
			fred.first  = fred.first/denominator ; 	}
            Manipulate.printFunction(new String(called),numerator,System.out) ;
		return numerator ; 
		}
        public static void printValues(List<Double[]> values){
            Double[] content = new Double[2] ; 
            int height = values.size() ; 
            freads.println("\n The values provides were :  \n") ;
            freads.append(new String("[ \n")) ; 
            for(int c=0;c<values.size();c++){
                content = values.get(c) ; 
                freads.append(new String("[ ")) ;
                freads.print(content[0]) ; 
                freads.append(new String(" , " )) ;
                freads.print(content[1]) ;
                freads.append(new String(" ]\n")) ;
            }
            freads.append(new String(" ] \n")) ;
        }
        /*
         * newPair.first = newPair.first-other  ; 
				listed.add(newPair) ; 
                sort(listed) ;
                                System.out.append(new String("\n")) ;
                 //   Manipulate.printFunction(new String(called),temp,)  ;
         */
    
}