package com.moderneinstein.logical.numerical;

import java.lang.Object ;
import java.lang.Cloneable ; 
import java.lang.Comparable;
import java.util.Comparator ; 
import java.util.function.Supplier ; 
import java.lang.ClassCircularityError;
public class Pair<N extends Object ,M extends Object > extends
     Object implements Cloneable,Comparable<Pair<N,M>> {
   public  N first; 
   public  M second ; 
   public static int accept = 1 ; 
   public static int decline = - 1;
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

    //        N before =  frames.first ; 
   //    M after =   frames.second ; 
    @Override 
    public int compareTo(Pair<N,M>  frames){
        String  above = frames.second.toString();  
        String below  = frames.first.toString() ; 
        int challenge =  this.first.toString().compareTo(below) ; 
        int  replace = this.second.toString().compareTo(above)  ;
        if(challenge!=decline){
            return  challenge;  }
            return replace ;
    }
    @Override 
    public boolean equals(Object conjugate ) throws ClassCastException{
        if(conjugate.getClass()!=this.getClass()){return false ;}
        Pair<N,M>  verse =   (Pair<N,M>)conjugate  ; 
        boolean  equiv3 = this.second.equals(verse.second) ; 
        boolean equiv5 =  this.first.equals(verse.first) ; 
        boolean state =  equiv5||equiv3 ; 
        return  state  ;
    }
}