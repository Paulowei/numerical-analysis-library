package com.moderneinstein.logical.numerical;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.Map;
import java.util.Vector;
import java.util.LinkedList;
import java.lang.Thread;
import java.util.Random;
import java.lang.NullPointerException;
import java.util.ArrayList;

import java.util.Set;
import java.util.TreeSet;
import java.lang.Object;
import java.lang.CloneNotSupportedException;
import java.lang.Cloneable;
import java.util.List;
import java.lang.Integer;
import java.sql.Date;
import java.util.TreeSet;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.Serializable;
//import java.   ;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.io.OutputStream;
import java.io.FileOutputStream;

public  class Manipulate {
    public static Functional functional = new Functional();
    public static String variable  = new String("s") ;
   // public static PrintStream default = new PrintStream(new File("Default.java")) ; 
   public static  char  upper  =  '^' ;  
    public static  char lower = 'v' ;   
    public static String intro = new String("The value of  The function is ...  ") ;  
    public static char LINES = '\n' ;   
    public  static char PLUS = '+' ; 
    public static List<Pair<Double, Integer>> createFunction(double[] parity, int[] powers) {
        List<Pair<Double, Integer>> function = new LinkedList<Pair<Double, Integer>>();
        if (powers == null || parity == null) {
            return function;
        }
        if (parity.length != powers.length) {
            return function;
        }
        double value = 0.0;
        Pair<Double, Integer> pairVal = new Pair<Double, Integer>();
        int power = 0;
        int length = parity.length;
        for (int n = 0; n < length; n++) {
            value = parity[n];
            power = powers[n];
            pairVal = new Pair<Double, Integer>(value, power);
            function.add(pairVal);
        }
        sort(function);
        return function;
    }

    public static void consider(int keyDigit,double value ,Map<Integer,Double> itemMap){
         if (itemMap.containsKey(keyDigit)) {
             double respond = itemMap.getOrDefault(keyDigit, 0.0) ;
            itemMap.replace(Integer.valueOf(keyDigit), Double.valueOf(value + respond)) ;
       } else {
            itemMap.putIfAbsent(Integer.valueOf(keyDigit), Double.valueOf(value));
        }
    }
    /*  String reply = new String();
        double value = 0.0;
        int keyDigit = 0; */
    public static void createFunction(Map<Integer, Double> itemMap, List<Pair<Double, Integer>> function,InputStream river,PrintStream stream) {
        InputStreamReader reader = new InputStreamReader(river);
        BufferedReader buffered = new BufferedReader(reader);
        stream.println("Enter A . to Quit");
        String terminal = new String(".");
        try {
            while (true) {
                stream.println("Enter the Corresponding power of the term ;");
                String reply = buffered.readLine();
                int keyDigit = Integer.parseInt(reply);
                stream.println("Enter the Corresponding value of the term");
                 reply = buffered.readLine();
               double value = Double.parseDouble(reply);
               consider( keyDigit,value,itemMap ) ; 
                stream.println("Enter a . to quit");
                reply = buffered.readLine();
                if (reply.equals(terminal)) {
                    break;
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        Functional.flatten(itemMap, function);
    }
 
        /**
         * 
         *    double value = 0.0;
        int power = 0;
         * @param query
         * @param function
         * @param meander
         */  
        //      Pair<Double, Integer> paired = new Pair<Double, Integer>();
    public static void printFunction(String query, List<Pair<Double, Integer>> function,PrintStream meander) {
        if (query == null || function == null) {
            return; }
        int width = function.size();
        meander.append(new String("The value of the function is : "));
        meander.print(new String("\n"));
        for (int m = 0; m < width; m++) {
            Pair<Double, Integer> paired = function.get(m);
            double  value = paired.first;
            int power = paired.second;
            meander.print(value);    meander.print(query + new String("^"));     meander.print(power);
            if (m != width - 1) {
                meander.print(new String("+ "));  }    }
        meander.print(new String("\n"));
        meander.print(new String("\n")); 
    }
  /*
   *      double power = 0.0;
        double product = 0.0;
   */  
  //         Pair<Double, Integer> pairVal = new Pair<Double, Integer>();
    public static double compute(double variable, List<Pair<Double, Integer>> function) {
        double total = 0.0;
        int length = function.size();
        for (int m = 0; m < length; m++) {
            Pair<Double, Integer> pairVal = function.get(m);
            double second = pairVal.second;
          double  first = pairVal.first;
            double power = Math.pow(variable, second);
           double product = power * first;
            total = total + product;
        }
        return total;
        }   
          /*
   *   int second = 0;
        double first = 0.0;
   */   
        //ON^2  Bubble Sort algorithm ;   
        //             pairVal = function.get(c);  
        //    Pair<Double, Integer> pairVal = new Pair<Double, Integer>();
    public static void sort(List<Pair<Double, Integer>> function) {
        int length = function.size();
        TreeMap<Integer, Double> mapper = new TreeMap<Integer, Double>();
        Functional.insertMap(mapper, function);
        function.clear();
        Functional.flatten(mapper, function);
        for (int c = 1; c < function.size(); c++) {
            for (int m = 0; m < c; m++) {
                if (function.get(m).second < function.get(c).second) {
                    Pair<Double,Integer> pairVal = function.get(m);
                    function.set(m, function.get(c));
                    function.set(c, pairVal);
                }
            }
        }
    }  
    public static void appendString(String content,String[] container){
        if(content==null){return ; }
        String amends = container[0].concat(content) ;
        container[0] = amends ;
    }   
    public static String functionToString (String varied,List<Pair<Double,Integer>>  brace){
        StringBuilder collect = new StringBuilder() ;
        int  breadth  = brace.size() ;  
        collect.append(intro) ;  
        collect.append(String.valueOf(LINES)) ; 
        for(int dc=0;dc<breadth;dc++){
             Pair<Double,Integer> parts = brace.get (dc) ; 
            collect.append(Double.toString(parts.first))  ;  
            collect.append(varied)   ; 
            collect.append(Character.toString(upper)) ;  
            collect.append(Integer.toString(parts.second)) ; 
            if(dc<breadth-1){collect.append(Character.toString(PLUS)) ; }
        }  
        collect.append(String.valueOf(LINES)) ; 
        return  collect.toString( )   ;   
    }  
    //         String  version =   collect.toString() ; 
}
