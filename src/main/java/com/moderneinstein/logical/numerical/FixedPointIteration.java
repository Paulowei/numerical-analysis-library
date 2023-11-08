//  package com.moderneinstein.logical.numerical  ;
package com.moderneinstein.logical.numerical  ;
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
import java.io.PrintStream; 
import java.io.OutputStream ; 
import java.io.FileOutputStream  ; 

class FixedPointIteration extends Object implements Cloneable {
    public static PrintStream stream =  new PrintStream(System.out) ; 
    public static String mains  = new String("\n") ; 
    public static PrintStream current =  stream   ; 
    public  static PrintStream custom ; 
    public static  double  converge =  1.5 ;  
    public static String  CREST = new String("z" ) ;  
    public static String TROUGH = new String("x") ;
    public static  void configure(PrintStream brace){
            current =  brace ;
    }

    //   Pair<Double,Integer> temp = new Pair<Double,Integer>() ; 
    //         newPair.second = temp.second-(minPair.second-1) ;
   //  newPair.first = (temp.first/minPair.first)*-1 ; 
    public static List<Pair<Double,Integer>> generate(List<Pair<Double,Integer>> function){
        int length = function.size() ; 
        LinkedList<Pair<Double,Integer>> retVal =  new LinkedList<Pair<Double,Integer>>() ;
        Pair<Double,Integer> minPair= new Pair<Double,Integer>(function.get(0).first,function.get(0).second) ; 
        int minPos = 0 ;
        for(int n=minPos;n<length;n++){
            Pair<Double,Integer> temp = function.get(n) ; 
            if(temp.second<=minPair.second){
                minPos =  n ; 
                minPair= temp ;   }    }
        for(int m=0;m<length;m++){
            if(m==minPos){  continue ;    }
           Pair<Double,Integer>  temp =  function.get(m) ;
            Pair<Double,Integer> newPair = new Pair<Double,Integer>((temp.first/minPair.first)*-1,temp.second-(minPair.second-1)) ;
            retVal.addLast(newPair) ;   }
        return retVal  ;    }
    //         double functVal = Manipulate.compute(startVal,function) ; 
    //         double tempVal = 0.0 ; 
    public static  double iterate(double startVal,double search,int maximum,List<Pair<Double,Integer >> function,String[] reknown){
        double shiftVal = 0.0  ; 
        int counter = 0 ;
        List<Pair<Double,Integer>> derivative = Functional.differentiate(function)  ;
        Manipulate.appendString(Manipulate.functionToString(CREST,derivative),reknown) ; 
        while(true){
           double tempVal = startVal+shiftVal; 
            double functVal  = Manipulate.compute(tempVal,derivative) ; 
            if(Math.abs(functVal)<=converge){
                startVal = tempVal;
                break ;     }
              tempVal  = startVal-shiftVal ;   
             functVal = Manipulate.compute(tempVal,derivative) ;
            if(Math.abs(functVal)<= converge){   
                startVal = tempVal ;
                break ;    }
            shiftVal = shiftVal+search ; 
            counter = counter+ 1 ; 
            if(counter>maximum){
                break  ;     }
        }
        Manipulate.appendString ("The starting value is : "+startVal, reknown) ;
        return startVal ;
    }
    public static double fixedPointIteration(double startVal,double limit,double search, 
    int maximum,List<Pair<Double,Integer>> function,String[] holder){
        int length = function.size() ; 
        List<Pair<Double,Integer>> conjugate = generate(function) ; 
        Manipulate.appendString(Manipulate.functionToString(TROUGH,function),holder) ;
        Manipulate.appendString(Manipulate.functionToString(CREST,conjugate),holder) ;
        startVal = iterate(startVal,search,15,conjugate,holder ) ; 
        int iterations = 0  ;
        double recent = 0.0  ; 
        while(true){
            recent = Manipulate.compute(startVal,conjugate)  ; 
            double change  = Math.abs(recent-startVal )   ; 
            if(change<=Math.abs(limit)){
                break ;    }
            Manipulate.appendString(new String("x : ")+ Double.toString(recent),holder) ;
            iterations= iterations+1  ; 
            startVal = recent  ; 
            if(iterations>maximum){
                break ;    }
        }
        Manipulate.appendString("The Solution of the function is :"+new String("\n"),holder) ;
         Manipulate.appendString(String.valueOf(Double.valueOf(recent)).concat(new String("\n")),holder) ; 
        return recent;
    }
}
/*
 *   public static double iterate(double startVal,double search,int maximum,List<Pair<Double,Integer >> function){
        double tempVal = 0.0 ; 
        double shiftVal = 0.0  ; 
        double functVal = compute(startVal,function) ; 
        int counter = 0 ;
        List<Pair<Double,Integer>> derivative = differentiate(function)  ;
        while(true){
            tempVal = startVal+shiftVal; 
            functVal  = compute(tempVal,derivative) ; 
            if(Math.abs(functVal)<=0){
                startVal = tempVal;
                break ;
            }
            tempVal  = startVal-shiftVal ; 
            functVal = compute(tempVal,derivative) ;
            if(Math.abs(functVal)<= 0){
                startVal = tempVal ;
                break ;
            }
            shiftVal = shiftVal+search ; 
            counter = counter+ 1 ; 
            if(counter>maximum){
                break  ;
            }
        }
        System.out.println(startVal) ;
        return startVal ;
    }
 */
/*
 * 
 * 
   
    public static List<Pair<Double,Integer>> differentiate(List<Pair<Double,Integer>> value){
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
 */
/*
class Pair<N extends Object ,M extends Object > extends Object implements Cloneable{
    N first; 
    M second ; 
    public Pair(){
        this.first = null ; 
        this.second= null ;
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
    /*  
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