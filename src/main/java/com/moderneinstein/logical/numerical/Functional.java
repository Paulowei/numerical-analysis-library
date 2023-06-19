package com.moderneinstein.logical.numerical ;

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
import java.util.HashMap ;


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

public  class Functional {
    public static Manipulate manipulate = new Manipulate();
    public static String variable = new String("s");

    public static List<Pair<Double, Integer>> differentiate(List<Pair<Double, Integer>> value) {
        LinkedList<Pair<Double, Integer>> function = new LinkedList<Pair<Double, Integer>>();
        Pair<Double, Integer> oldPair = new Pair<Double, Integer>();
        Pair<Double, Integer> newPair = new Pair<Double, Integer>();
        int length = value.size();
        for (int n = 0; n < length; n++) {
            oldPair = value.get(n);
            newPair = new Pair<Double, Integer>();
            if (oldPair.second == 0) {
                continue;
            }
            newPair.first = oldPair.first * oldPair.second;
            newPair.second = oldPair.second - 1;
            function.addLast(newPair);
        }
        return function  ;    }

    public static List<Pair<Double, Integer>> integrate(List<Pair<Double, Integer>> function) {
        LinkedList<Pair<Double, Integer>> integral = new LinkedList<Pair<Double, Integer>>();
        Pair<Double, Integer> oldPair = new Pair<Double, Integer>();
        Pair<Double, Integer> newPair = new Pair<Double, Integer>();
        int length = function.size();
        for (int m = 0; m < length; m++) {
            oldPair = function.get(m);
            newPair = new Pair<Double, Integer>();
            if (oldPair.second == -1) {
                continue;
            }
            newPair.second = oldPair.second + 1;
            newPair.first = oldPair.first / (oldPair.second + 1);
            integral.addLast(newPair);
        }
        return integral;    }

    public static void flatten(Map<Integer, Double> digitMap, List<Pair<Double, Integer>> function) {
        function.clear();
        Pair<Double, Integer> tempPair = new Pair<Double, Integer>();
        int length = digitMap.size();
        TreeSet<Integer> setValue = new TreeSet<Integer>(digitMap.keySet());
        Vector<Integer> vector = new Vector<Integer>(setValue);
        Integer iterand = 0;
        Double opposite = 0.0;
        for (int v = 0; v < length; v++) {
            iterand = vector.elementAt(v);
            opposite = digitMap.getOrDefault(iterand, 0.0);
            tempPair = new Pair<Double, Integer>(opposite, iterand);
            function.add(tempPair);
        }    }

    public static List<Pair<Double, Integer>> subtraction(List<Pair<Double, Integer>> funct1,
            List<Pair<Double, Integer>> funct2) {
        if (funct2 == null || funct2.size() == 0) {
            return funct1;
        }
        if (funct1 == null || funct1.size() == 0) {
            return funct2;
        }
        Map<Integer, Double> mappy = new HashMap<Integer, Double>();
        insertMap(mappy, funct1);
        Manipulate.sort(funct2);
        Pair<Double, Integer> newPair = new Pair<Double, Integer>();
        for (int v = 0; v < funct2.size(); v++) {
            Pair<Double, Integer> paired = funct2.get(v);
            // newPair = new Pair<Double,Integer>(paired.first,paired.second) ;
            if (!mappy.containsKey(paired.second)) {
                mappy.putIfAbsent(paired.second, (paired.first) * (-1.0));
            } else {
                Double other = mappy.get(paired.second);
                mappy.replace(paired.second, other - paired.first);
            }
        }
        List<Pair<Double, Integer>> listed = new ArrayList<Pair<Double, Integer>>();
        flatten(mappy, listed);
        return listed;
    }

    /*
     * newPair.first = newPair.first-other ;
     * listed.add(newPair) ;
     * sort(listed) ;
     */
    public static void insertMap(Map<Integer, Double> mapper, List<Pair<Double, Integer>> function) {
        mapper.clear();
        int length = function.size();
        // TreeMap<Integer,Double> mapper = new TreeMap<Integer,Double>();
        Pair<Double, Integer> pairVal = new Pair<Double, Integer>();
        for (int v = 0; v < length; v++) {
            pairVal = function.get(v);
            if (pairVal == null) {
                continue;
            }
            double value1 = pairVal.first;
            int value2 = pairVal.second;
            if (mapper.containsKey(value2)) {
                double other = mapper.getOrDefault(value2, 0.0);
                mapper.replace(value2, other + value1);
            } else {
                mapper.putIfAbsent(value2, value1);
            }
        }
    }

    public static List<Pair<Double, Integer>> summation(List<Pair<Double, Integer>> funct1,
            List<Pair<Double, Integer>> funct2) {
        Map<Integer, Double> mappy = new TreeMap<Integer, Double>();
        // insertMap(mappy, funct1 ) ;
        insertMap(mappy, funct2);
        Manipulate.sort(funct1);
        List<Pair<Double, Integer>> function = new LinkedList<Pair<Double, Integer>>();
        Pair<Double, Integer> parity = new Pair<Double, Integer>();
        for (int a = 0; a < funct1.size(); a++) {
            Pair<Double, Integer> serial = funct1.get(a);
            Double double1 = serial.first;
            Integer integer1 = serial.second;
            if (mappy.containsKey(integer1)) {
                Double other = mappy.get(integer1);
                mappy.replace(integer1, double1 + other);
            } else {
                mappy.putIfAbsent(integer1, double1);
            }
        }
        flatten(mappy, function);
        return function;
    }

    public static List<Pair<Double, Integer>> multiply(List<Pair<Double, Integer>> funct1,
            List<Pair<Double, Integer>> funct2) {
        Vector<Pair<Double, Integer>> product = new Vector<Pair<Double, Integer>>();
        if (funct1 == null || funct2 == null) {
            return product;  }
        if (funct1.size() == 0) {
            return funct2;   }
        if (funct2.size() == 0) {
            return funct1 ;    }
        Pair<Double, Integer> interim = new Pair<Double, Integer>(0.0, 0);
        for (int c = 0; c < funct2.size(); c++) {
            Pair<Double, Integer> paired1 = funct2.get(c);
            for (int v = 0; v < funct1.size(); v++) {
                Pair<Double, Integer> paired2 = funct1.get(v);
                interim = new Pair<Double, Integer>(0.0, 0);
                interim.second = paired2.second + paired1.second;
                interim.first = paired1.first * paired2.first;
                product.addElement(interim);
            }   }
        TreeMap<Integer, Double> treeMap = new TreeMap<Integer, Double>();
        insertMap(treeMap, product);
        flatten(treeMap, product);
        return product;
    }
}