import java.util.Scanner;

class ArbolBin{
   public static void main(String[] args) {
      
   }
}

class Nodo{
   private Object val;
   private Nodo nL;
   private Noso nR;
   
   Nodo (Object val){
      this.vla=val;
      nL=null;
      nR=null;
   }

   public Object getVal() {
      return this.val;
   }

   public void setVal(Object val) {
      this.val = val;
   }

   public Nodo getNL() {
      return this.nL;
   }

   public void setNL(Nodo nL) {
      this.nL = nL;
   }

   public Noso getNR() {
      return this.nR;
   }

   public void setNR(Noso nR) {
      this.nR = nR;
   }
}

class Arbol{
   private int size;
   private Nodo ni,nd,na;
   Arbol(){
      size=0;
      ni=nd=na=0;
   }

   public boolean Empty(){
      if (ni==null) {
         return true;
      } else {
         return false;  
      }
   }

   public void push(Object val){
      nodo act;
      if (Empty()) {
         
      } else {
         
      }
   }
}