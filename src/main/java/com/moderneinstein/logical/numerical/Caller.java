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
public class Caller{
        public static Double[][] tests = new Double[][]{new Double[]{8.7,18.82091},new Double[]{8.6,18.50515}
        , new Double[]{8.3,17.56492},new Double[]{8.1,16.94410}} ;
        public static String calledString = new String("Interpolation.txt") ;
        public static Class<?> calledClass = Interpolation.class ; 
        public static File calledFile = new File("Interpolation.java") ;
        public static PrintStream stream = System.out ;
        public static String callFunct = new String("R" ) ;
        public static String delim = new String(":") ; 
        public static double testVal = 8.8  ;
      public static File createFile(){
        File file4 = new File("") ;
        BufferedWriter writer2  = null ; 
        OutputStream stream1 = null ; 
        OutputStreamWriter stream2 = null ;
        try{
       // String string1 = Interpolation.class.getName() ;
        String string1 = new String(calledString)  ;
         file4 = new File(string1) ;
          file4.createNewFile() ;
        String value2  = parseFile(file4) ; 
         stream1 = new FileOutputStream(file4,false) ; 
        PrintStream writer1 = new PrintStream(stream1,false)  ; 
        System.setOut(writer1) ;
         writer1.print(value2) ;
        writer2 = new BufferedWriter(new OutputStreamWriter(stream1)) ;;
        }catch(IOException exception){
            System.err.println(exception.getMessage()) ; 
            exception.printStackTrace() ;
       }
       stream = System.out ;
        return file4 ;
    }
    public static void callFunction(){
        List<Pair<Double,Integer>> function1 
        = new LinkedList<Pair<Double,Integer>>() ;
        List<Double[]> buffer1 = new Vector<Double[]>() ; 
        Double[] serd = new Double[]{} ;
        for(int v=0;v<tests.length;v++){
            serd= tests[v] ; 
            buffer1.add(serd) ;
        }
       function1 = Interpolation.lagrange(buffer1) ;
       Manipulate.printFunction(callFunct , function1,System.out) ;
       double computed = Manipulate.compute(testVal,function1) ;
       stream.append("The solution to the Lagrange Interpolation problem is ") ;
       stream.append(new String(":\n")) ;
       stream.print(computed) ;
       stream.append(new String("\n")) ;
    }
    public static Pair<List<Double[]>,Double> parseArgs(String[] args,boolean last){
        Double[] array4 = new Double[2] ; 
        Double value1 = 0.0 ; 
        Double value2 = testVal ; 
        List<Double[]>  buffer = new ArrayList<Double[]>() ;
       // int changed = (last==true?1 | 0) ;
        if(args.length==0){
            return new Pair<List<Double[]>,Double>(buffer,0.0) ;
        }
        for(int v=0;v<args.length-1;v++){
            String value = args[v] ; 
            String[] thread = value.split(new String(":"));
            array4 = new Double[]{Double.parseDouble(thread[0]), 
                Double.parseDouble(thread[1])  }  ; 
            buffer.add(array4) ;
         }
         if(last==true){
         int height = args.length ;
	  stream.append("True that \n\n ") ;
        value2 = Double.parseDouble(args[height-1]) ;
         }
         return new Pair<List<Double[]>,Double>(buffer,value2); 
    }
    public static String parseFile(File value){
        if(value==null){
            return new String("") ;    }
            String value1 = new String(); 
            String value2= new String() ;
            InputStream stream1 ;
            InputStreamReader stream2 ; 
            BufferedWriter writer2  ;
        try{
             stream1 = new FileInputStream(value) ;
            stream2 = new InputStreamReader(stream1) ;
            BufferedReader reader1 = new BufferedReader(stream2) ;
            while(true){
                value2 = reader1.readLine() ;
                if(value2==null){
                    break ; 
                } 
             value1 = value1.concat(value2) ; 
            value1 = value1.concat(new String("\n")) ;    }
            reader1.close() ;
        }catch(IOException exception) {
            System.err.println(exception.getMessage()) ;
            exception.printStackTrace() ;
        }
       return value1 ; 
    }
    public static double solve(List<Double[]> listed,double created){
        List<Pair<Double,Integer>> function
        = new ArrayList<Pair<Double,Integer>>() ;
    function = Interpolation.lagrange(listed) ;
    Manipulate.printFunction(callFunct,function,System.out) ;
    double computed =  Manipulate.compute(created,function) ;
    stream.append("The solution to the Lagrange Interpolation problem is ") ;
    stream.append(new String(":\n")) ;
    stream.print(computed) ;
    stream.append(new String("\n")) ;
    return  computed ;
    }
    public static boolean[] isParse(String[] args ){
        boolean[] array = new boolean[2] ;
        array[0] = false ; 
        array[1] = false ; 
        if(args==null||args.length==0){
            return new boolean[]{false,false} ;
        } 
        if(args.length==1){
           String argument = args[0] ;
           if(argument.indexOf(":")==-1){
            return array;
           }
           array[0] = true ;
           return array ;
        }
        String  crest = new String()  ; 
        for(int c=0;c<args.length-1;c++){
            crest = args[c]  ; 
            if(crest.indexOf(delim)==-1){
                return array ;
            }
        }
        if(args[args.length-1].indexOf(delim)!=-1){
            array[0] = true;
            array[1] = false ; 
            return array ;
        }
        array[0] = true ;
        array[1] = true ;
        return array ; 
    }
    public static int solveArgs(String[] args){
        boolean[] truths = new boolean[2] ; 
        truths = isParse(args) ; 
        if(truths[0]==false){
            stream.append("Incorrect,or Missing Arguments provided ; ") ;
            callFunction() ;
            return 0 ;
        }
        Pair<List<Double[]>,Double> paired  = parseArgs(args,truths[1]) ; 
        List<Double[]> values =  paired.first; 
        solve(paired.first,paired.second) ; 
        return 1 ; 
    }
	/**
	 * @param args
	 */
	public static void main(String[] args){

      //  Interpolation.printFunction(new String("F"),funct) ;
      PrintStream temp  = System.out; 
     File filed = createFile() ;
     solveArgs(args) ;
     System.setOut(temp) ; 
     stream = System.out ;
     Interpolation.freads =  temp ;  
     solveArgs(args) ;
  stream.append(" Created values \n") ;
   //  solve(values.first,values.second) ;
  // solve(values.first,values.second) ;
   //System.setOut(temp) ;

	}
}
/*   List<Pair<Double,Integer>> function = Interpolation.lagrange(values); 
        Double value = Manipulate.compute(paired.second,function) ; 
        Manipulate.printFunction(callFunct,function,stream) ; 
        stream.append("The solution to the problem is : ") ;
        stream.println(value) ; 
           /*
        List<Double> listed = List.of(3.0 ,4.0,5.0) ;
        List<Pair<Double,Integer>> listVal = Interpolation.polynomial(listed,0) ; 
        Interpolation.printFunction(new String("S"),listVal) ;
        Interpolation.printFunction(new String("Z"),Interpolation.subtraction(listVal,listVal)) ;
        Interpolation.printFunction(new String("C"),listVal) ;
        List<Double[]> coupled = List.of(new Double[]{3.0,6.0},new Double[]{4.0 ,8.0},new Double[]{5.0,10.0}) ;
        List<Pair<Double,Integer>> funct = Interpolation.lagrange(coupled ) ; 
        */ 
/*     // parseFile(file5) ;
   //     OutputStream stream1 = new FileOutputStream(file5) ; 
    //PrintStream writer1 = new PrintStream( stream1 , false )  ;
     //   System.setOut(writer1) ;
     // stream.append(args[0]) ;
           // parseFile(filed) ;
    //  }catch(IOException exception){
     //   System.err.println(exception.getMessage());
     //   exception.printStackTrace( ) ;
      // }
 */
/*      //   callFunction() ; 
    // Interpolation.lagrange(values) ;
          //  parseFile(filed) ;\
   //   try{
      File file5= new File("Interpolation.txt");
     Pair<List<Double[]>,Double> values = parseArgs(args) ;
    //  callFunction() ; 
     //Interpolation.lagrange(values.first) ;
 */
