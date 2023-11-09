package com.moderneinstein.logical.numerical;
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

public class NewtonRaphson extends Object implements Cloneable {

    public  static PrintStream  stream = new PrintStream(System.out) ; 
    public static PrintStream  current =  stream  ; 
    public static PrintStream   custom  ; 
    public static String fileName= new  String("NewtonRaphson.txt") ;  
    public static String types[] = new String[]{"x","y","z" }  ; 
    public static void flatten(Map<Integer,Double> digitMap,List<Pair<Double,Integer>> function){
        Pair<Double,Integer> tempPair = new Pair<Double,Integer>() ; 
        int length = digitMap.size() ; 
        TreeSet<Integer>  setValue =  new TreeSet<Integer>(digitMap.keySet()) ;
        Vector<Integer> vector = new Vector<Integer>(setValue) ;
        Integer iterand = 0 ;
        Double opposite = 0.0 ;
        for(int v=0;v<length;v++){
         iterand = vector.elementAt(v) ; 
        opposite = digitMap.getOrDefault(iterand,0.0) ;
        tempPair = new Pair<Double,Integer>(opposite,iterand) ; 
        function.add(tempPair) ;
        }      }   
           // double newVal = functVal ; 
           //  double otherVal = compute(starter,conjugate)  ; 
           // double functVal = 0.0 ;
           //    functVal = compute(starter,function) ;   
    public static double NewtonRaphson(double starter,double limit,int repititions,List<Pair<Double,Integer>> function,String[] buffer){
        Pair<Double,Integer> paired = new Pair<Double,Integer>() ; 
        List<Pair<Double,Integer>> conjugate = Functional.differentiate(function) ;
        Manipulate.appendString(new String("The starting value is : ")+starter+ new String("\n"),buffer) ;
        int lapse = 0 ; 
        Manipulate.appendString(Manipulate.functionToString(types[1],function ),buffer) ;
        while(true){
            double  functVal = Manipulate.compute(starter,function) ; 
            double otherVal = Manipulate.compute(starter,conjugate) ;
            if(Math.abs(functVal)<Math.abs(limit)){
                break ;      }
            double alter = functVal/otherVal ; 
            Manipulate.appendString(types[1]+ starter+new String("\n"),buffer ) ; 
            starter =  starter-alter ; 
            lapse = lapse+ 1; 
            if(lapse>repititions){
                break ; }    }
        Manipulate.appendString(" The Solution of the function is : \n",buffer)  ;
        Manipulate.appendString( Double.toString(starter)+new String("\n"),buffer)  ; 
            return starter;
    }
    //  Manipulate.printFunction(new String("z"),function ,stream) ;  
    //   Manipulate.appendString(new  String("X : ")+ starter+new String("\n"),buffer ) ; 
}
  //  @Override
  /* 
    public  Object clone(){
        try{
        Pair<N,M> pair = (Pair<N,M>)super.clone(); 
        pair.first = (N)(((Object)this.first).clone()) ; 
        pair.second = (M)this.second. clone() ; 
        pair.value = (Date)(value.clone()) ;
        Object retVal = (Objc{t)pair ; 
        }catch(CloneNotSupportedException){

        }
        return retVal ;
    }
    */
    /**
     * 
     * class Pair<N extends Object ,M extends Object > extends Object implements Cloneable{
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
     */  
    /*
     * 
     * public static void createFunction(Map<Integer,Double> itemMap,List<Pair<Double,Integer >> function){
        InputStream stream = System.in ; 
        InputStreamReader reader = new InputStreamReader(stream) ;
        BufferedReader buffered = new BufferedReader(reader) ; 
        String reply = new String() ; 
        double value  = 0.0  ;
        int keyDigit = 0 ; 
        System.out.println("Enter A . to Quit") ; 
        String terminal =  new String(".") ;
        try{
        while(true){
            System.out.println("Enter the Corresponding power of the term ;")  ;
            reply = buffered.readLine() ; 
            keyDigit = Integer.parseInt(reply) ; 
            System.out.println("Enter the Corresponding value of the term") ;
            reply  = buffered.readLine() ; 
            value = Double.parseDouble(reply) ;
            if(itemMap.containsKey(keyDigit)){
                double respond = itemMap.getOrDefault(keyDigit,0.0) ;
                itemMap.replace(Integer.valueOf(keyDigit),Double.valueOf(value+respond)) ;
            }else{
                itemMap.putIfAbsent(Integer.valueOf(keyDigit),Double.valueOf(value) ) ;
            }
            System.out.println("Enter a . to quit");
            reply =buffered.readLine() ; 
            if(reply.equals(terminal)){
                break ; 
            }
                 }
    }catch(IOException exception){
        exception.printStackTrace() ; 
    }
    flatten(itemMap,function) ; 
    }
    public static void main(String[] args){
        NewtonRaphson object = new NewtonRaphson() ;
        String strVal = object.getClass().getName() ; 
       // System.out.println(object.getClass().getName()) ; 
       String fileName = strVal.concat(new String(".txt")) ; 
       PrintStream temp  = System.out ;
        try{
        File file4 = new File(fileName) ;
        file4.createNewFile() ;
        InputStream input = new FileInputStream(file4) ;
        InputStreamReader streader= new InputStreamReader(input); 
        BufferedReader  reader = new BufferedReader(streader)  ;
        String value = new String("") ;
        String append = new String("") ;
        while(append!=null){
             append = reader.readLine() ;
             if(append==null){
                break ;
             }
            value = value.concat(append).concat(new String("\n")) ;
        }
       // value= value.concat("") ;
        reader.close() ;
        OutputStream stream = new FileOutputStream(file4) ;
        PrintStream print = new PrintStream(stream,false) ;
        System.setOut(print) ;
        System.out.print(value) ;
        }catch(IOException exception){
            System.out.println(exception.getMessage()) ;
            exception.printStackTrace()  ; 
        }
        System.out.println("\n" ) ;
        double[]  parity =  new double[3] ; 
        int[] powers = new int[3] ; 
        parity = new double[]{4,-7,1} ;
        powers = new int[]{0,1,3} ; 
        LinkedList<Pair<Double,Integer>>  function = 
        new LinkedList<Pair<Double,Integer>>() ; 
        Pair<Double,Integer> paired = 
        new Pair<Double,Integer>()  ;
        double starter = 2.0 ; 
        if(args.length>0){
            String value = args[0] ; 
            starter = Double.parseDouble(value) ; 
        }
        createFunction(parity,powers,function) ;
        double answer = NewtonRaphson(starter,0.002,15,function ) ;
        System.setOut(temp) ;
    //    printFunction(new String("x"),function) ;
        answer = NewtonRaphson(starter,0.002,15,function ) ;
        TreeMap<Integer,Double> treeMap = new  TreeMap<Integer,Double>() ; 
        function.clear();
        createFunction(treeMap,function) ;
        printFunction(new String("t"),function) ; 
        answer = NewtonRaphson(starter,0.002,15,function ) ;
    }
     */   
    /**
     *    public static List<Pair<Double,Integer>> differentiate(List<Pair<Double,Integer>> value){
        LinkedList<Pair<Double,Integer>> function = new LinkedList<Pair<Double,Integer>>() ;
        Pair<Double,Integer> oldPair = new Pair<Double,Integer>(); 
        Pair<Double,Integer> newPair = new Pair<Double,Integer>( ) ;
        int length = value.size() ; 
        for(int n= 0;n<length;n++){
            oldPair = value.get(n)  ; 
            newPair = new Pair<Double,Integer>() ; 
            if(oldPair.second==0){
                continue ;
            }
            newPair.first  = oldPair.first*oldPair.second ;
            newPair.second = oldPair.second -1 ; 
            function.addLast(newPair ) ;
        }
        return  function ; 
    }
    public static List<Pair<Double,Integer>> integrate(List<Pair<Double,Integer>> function){
        LinkedList<Pair<Double,Integer>> integral = 
          new LinkedList<Pair<Double,Integer>>(); 
        Pair<Double,Integer> oldPair = new Pair<Double,Integer>() ; 
        Pair<Double,Integer> newPair = new Pair<Double,Integer>() ;
        int length = function.size(); 
        for(int m=0;m<length;m++){
            oldPair = function.get(m) ; 
            newPair = new Pair<Double,Integer>() ; 
            if(oldPair.second==-1){
                 continue ;
            }
            newPair.second = oldPair.second+1 ; 
            newPair.first = oldPair.first/(oldPair.second+1) ; 
            integral.addLast(newPair) ; 
        }
        return integral ; 
    }
    public static void sort(List<Pair<Double,Integer>> function){
        int length = function.size()   ; 
        TreeMap<Integer,Double> mapper = new TreeMap<Integer,Double>();
        Pair<Double,Integer> pairVal = new Pair<Double,Integer>( );
        for(int v=0;v<length;v++){
            pairVal = function.get(v) ;
            if(pairVal==null){
                continue ;
            }
            double value1 = pairVal.first ;
            int value2 = pairVal.second ; 
            if(mapper.containsKey(value2)){
                double other = mapper.getOrDefault(value2,0.0) ;
                mapper.replace(value2,other+value1) ;
            }else{
                mapper.putIfAbsent(value2,value1) ;
            }
        }
        function.clear() ; 
        flatten(mapper,function) ;
        for(int c=1;c<function.size();c++){
            pairVal = function.get(c) ; 
            for(int m=0;m<c;m++){
                if(function.get(m).second>function.get(c).second){
                    pairVal = function.get(m) ;
                    function.set(m,function.get(c)) ; 
                    function.set(c,pairVal) ; 
                }
            }
        }
    }
    public static  void printFunction(String query,List<Pair<Double,Integer>> function){
        if(query==null||function==null){
            return  ;
        }
        Pair<Double,Integer> paired = new Pair<Double,Integer >() ;  
        int width = function.size()  ; 
        double value  = 0.0 ; 
        int power = 0 ; 
        System.out.append(new String("The value of the function is : ")) ;
        System.out.print(new String("\n")) ;
        for(int m=0;m<width;m++){
            paired= function.get(m) ;
            value = paired.first  ; 
            power = paired.second ; 
            System.out.print(value ) ; 
            System.out.print(query+ new String("^")) ;
            System.out.print(power) ; 
            if(m!=width-1){
                System.out.print(new String("+")) ; 
            }
        }
        System.out.println(new String(""))  ;
    }
    public static double compute(double variable,List<Pair<Double,Integer>> function){
        double power = 0.0   ; 
        double product = 0.0 ; 
        double total  = 0.0 ;
        int second  = 0 ; 
        double first = 0.0 ;
        Pair<Double,Integer> pairVal = new Pair<Double,Integer>() ;
        int length = function.size(); 
        for(int m= 0;m<length;m++){
            pairVal = function.get(m) ; 
            second = pairVal.second ; 
            first = pairVal.first ;
            power = Math.pow(variable,second)  ;
            product = power*first ; 
            total= total+product ; 
        }
        return total ; 
    }
    public static void createFunction(double[] parity,int[] powers,List<Pair<Double,Integer>> function){
        if(function==null||powers==null||parity==null){
            return  ;}
        if(parity.length!=powers.length){
            return ;}
        double value = 0.0 ; 
        Pair<Double,Integer> pairVal = new Pair<Double,Integer>() ;   
        int power= 0  ;    
        int length = parity.length  ; 
        for(int n=0;n<length;n++){
            value = parity[n] ; 
            power = powers[n] ; 
            pairVal = new Pair<Double,Integer>(value,power) ; 
            function.add(pairVal) ;
        }
        sort(function) ;    
    } 
     * 
     */