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

class Pair<N extends Object ,M extends Object > extends Object implements Cloneable{
    N first; 
    M second ; 
    public Pair(){
        this.first = null ; 
        this.second= null ;
    }
    
    @Override 
    public String toString(){
        String retVal = new String("[ ") ;
        retVal= retVal.concat(this.first.toString()) ;
        retVal = retVal.concat(new String(" : ")) ; 
        retVal= retVal.concat(this.second.toString()) ;
        retVal = retVal.concat(new String(" ]")) ;
        return retVal ;
    } 
    public Pair(N before,M after){
        this.first = before  ;
        this.second = after ; 
    }
    @Override
    public int hashCode(){
        int value = first.hashCode() ; 
        int digit = second.hashCode() ; 
        int retVal = value + digit ; 
        return retVal ;
    }
}
public  class Manipulate {
    public static Functional functional = new Functional();
    public static String variable  = new String("s") ;
   // public static PrintStream default = new PrintStream(new File("Default.java")) ;
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

    public static void createFunction(Map<Integer, Double> itemMap, List<Pair<Double, Integer>> function,InputStream river,PrintStream stream) {
        InputStreamReader reader = new InputStreamReader(river);
        BufferedReader buffered = new BufferedReader(reader);
        String reply = new String();
        double value = 0.0;
        int keyDigit = 0;
        stream.println("Enter A . to Quit");
        String terminal = new String(".");
        try {
            while (true) {
                stream.println("Enter the Corresponding power of the term ;");
                reply = buffered.readLine();
                keyDigit = Integer.parseInt(reply);
                stream.println("Enter the Corresponding value of the term");
                reply = buffered.readLine();
                value = Double.parseDouble(reply);
                if (itemMap.containsKey(keyDigit)) {
                    double respond = itemMap.getOrDefault(keyDigit, 0.0);
                    itemMap.replace(Integer.valueOf(keyDigit), Double.valueOf(value + respond));
                } else {
                    itemMap.putIfAbsent(Integer.valueOf(keyDigit), Double.valueOf(value));
                }
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

    public static void printFunction(String query, List<Pair<Double, Integer>> function,PrintStream meander) {
        if (query == null || function == null) {
            return;
        }
        Pair<Double, Integer> paired = new Pair<Double, Integer>();
        int width = function.size();
        double value = 0.0;
        int power = 0;
        meander.append(new String("The value of the function is : "));
        meander.print(new String("\n"));
        for (int m = 0; m < width; m++) {
            paired = function.get(m);
            value = paired.first;
            power = paired.second;
            meander.print(value);
            meander.print(query + new String("^"));
            meander.print(power);
            if (m != width - 1) {
                meander.print(new String("+ "));
            }
        }
        meander.print(new String("\n"));
        meander.print(new String("\n")); 
    }

    public static double compute(double variable, List<Pair<Double, Integer>> function) {
        double power = 0.0;
        double product = 0.0;
        double total = 0.0;
        int second = 0;
        double first = 0.0;
        Pair<Double, Integer> pairVal = new Pair<Double, Integer>();
        int length = function.size();
        for (int m = 0; m < length; m++) {
            pairVal = function.get(m);
            second = pairVal.second;
            first = pairVal.first;
            power = Math.pow(variable, second);
            product = power * first;
            total = total + product;
        }
        return total;
    }

    public static void sort(List<Pair<Double, Integer>> function) {
        int length = function.size();
        TreeMap<Integer, Double> mapper = new TreeMap<Integer, Double>();
        Pair<Double, Integer> pairVal = new Pair<Double, Integer>();
        Functional.insertMap(mapper, function);
        function.clear();
        Functional.flatten(mapper, function);
        for (int c = 1; c < function.size(); c++) {
            pairVal = function.get(c);
            for (int m = 0; m < c; m++) {
                if (function.get(m).second < function.get(c).second) {
                    pairVal = function.get(m);
                    function.set(m, function.get(c));
                    function.set(c, pairVal);
                }
            }
        }
    }
}
