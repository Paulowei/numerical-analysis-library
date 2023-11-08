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
import java.io.PrintWriter  ; 
import java.io.IOException  ; 
import java.io.FileInputStream ; 
import java.io.PrintStream; 
import java.io.OutputStream ; 
import java.io.FileOutputStream  ; 



 /*class Pair<N extends Object ,M extends Object > extends Object implements Cloneable{
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
    ///
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
}  */ // implements Cloneable
public class Bisection extends Object  {

    /*
       double  functVal =0.0 ; 
        double tempVal = 0.0 ;
     */  
    public static double  DRAFT = 0.2 ;  
      //  functVal = compute(tempVal,function) ;  
        //  functVal = compute(states[0],function) ;
    public static void adjust(double startVal,double[] array,List<Pair<Double,Integer>> function){
        double[]  states = new double[]{startVal,startVal} ;
        double shiftVal  = 0.0 ; 
        while(true){
           double tempVal = states[0]+shiftVal ;
            if(Manipulate.compute(tempVal,function)<=0.0){
                array [0] = tempVal ; 
                break ;  }
             tempVal =states[0]-shiftVal ; 
            if(Manipulate.compute(tempVal,function)<=0.0){
                array[0]= tempVal ; 
                break ;   }
            shiftVal = shiftVal + DRAFT ;     }
        while(true){
           double tempVal = states[1]-shiftVal  ; 
            if( Manipulate.compute (tempVal,function ) >=0.0){
               array[1] = tempVal ; 
                break ;     }
            tempVal =states[1]+shiftVal ; 
            if(Manipulate.compute(tempVal,function) >=0.0){
               array[1] = tempVal  ; 
            break ;  }
            shiftVal = shiftVal+DRAFT ;  }
    }  
     //  functVal = compute(tempVal,function) ;   
         //  double functVal = compute (tempVal,function ) ;  
         /*
         array[0] =  states[0] ;  
        array[1] = states[1] ;  */      
        /*System.out.append("Middle : "+middle+new String("\n")) ; 
            System.out.println(functVal) ; */
    public static double bisection(double startVal,double limit,int repeat,List<Pair<Double,Integer>> function,String contains[]){
        int length = function.size() ; 
        Pair<Double,Integer> paired = new Pair<Double,Integer>() ; 
        double functVal = 0.0 ; 
        int lapse =0 ; 
        double[] values = new double[2] ; 
        adjust(startVal,values,function) ; 
        double left = values[0] ; 
        double right = values[1] ;
        double middle= 0.0 ; 
        Manipulate.appendString(Manipulate.functionToString(new String("x"),function),contains) ;
        Manipulate.appendString("The starting value is : "+ startVal+new String("\n"),contains)  ; 
        Manipulate.appendString(new String("Left : ")+left+new String("\n"),contains) ;
        Manipulate.appendString(new String("Right : ") + right + new String("\n"),contains) ;  
        while(true){
            middle = (right+left )/2 ; 
            functVal = compute(middle,function ) ; 
            Manipulate.appendString( "Middle : "+middle+new String("\n") ,contains  ) ;   
            if(Math.abs(functVal)<=Math.abs(limit)){
                break  ;
            }else{
                if(functVal>0){
                    right = middle ;
                }
                if(functVal<0){
                    left = middle ;
                }
            }
            lapse = lapse+1 ; 
            if(lapse>repeat){
                break ;
            }
        }
       Manipulate.appendString("The solution to the equation is :",contains) ;
       Manipulate.appendString(Double.toString( middle),contains) ;
        return middle ;
    }    
    /*Manipulate.printFunction(new String("x"),function,System.out) ;
        System.out.println("The starting value is : "+ startVal)  ; 
        System.out.print(new String("Left : ")+left+new String("\n")) ;
        System.out.print(new String("Right : ") + right + new String("\n")) ; */
    public static  double compute(double variable,List<Pair<Double,Integer>> function){
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
  
}  

/**
 * 
 *   public static  void printFunction(String query,List<Pair<Double,Integer>> function){
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
    }   
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
        }
    } 
    */  
     /* 
    public static void createFunction(Map<Integer,Double> itemMap,List<Pair<Double,Integer >> function){
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
        Bisection object = new Bisection() ;
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
        System.out.print(new String("\n")) ; 
        double[]  parity =  new double[3] ; 
        int[] powers = new int[3] ; 
        parity = new double[]{4,-7,1} ;
        powers = new int[]{0,1,3} ; 
        LinkedList<Pair<Double,Integer>>  function = 
        new LinkedList<Pair<Double,Integer>>() ; 
        Pair<Double,Integer> paired   =   
        new Pair<Double,Integer>()  ;   
        createFunction(parity,powers,function) ; 
        printFunction(new String("x"),function) ;
     //   double answer = fixedPointIteration(2.0,0.01,0.2,10,function ) ;
        double starter = 0.0 ; 
        if(args.length>0){
            String value = args[0] ; 
            starter = Double.parseDouble(value) ; 
        }
        double answer = bisection(starter,0.002,15,function) ; 
        System.setOut(temp) ;
         answer = bisection(starter,0.002,15,function) ; 
        TreeMap<Integer,Double> treeMap = new  TreeMap<Integer,Double>() ; 
        function.clear();
        createFunction(treeMap,function) ;
        printFunction(new String("t"),function) ; 
        answer = bisection(starter,0.002,15,function) ; 
    }
 */  
/*
 * 
 *  public static  List<Pair<Double,Integer>> differentiate(List<Pair<Double,Integer>> value){
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
 */