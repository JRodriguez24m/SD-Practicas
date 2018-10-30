import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

class ListaDoblementeEnlazada{
   public static void main(String[] args) {
      Scanner owl= new Scanner(System.in);
      Lista lista=new Lista();
      int o=24, val;
      boolean e=false;
      
      for(val=1;val<10;val++){
         lista.push(val);
      }

      do {
         System.out.print("\n -Lista doblemente enlazada-\n"+
                           "   1.Ingresar.\n"+
                           "   2.Mostrar principio a fin.\n"+
                           "   3.Mostrar de fin a inicio.\n"+
                           "   4.Eliminar.\n"+
                           "   5.Buscar.\n   6.Ver raíz\n"+"   0.Salir\n      Opción: ");
                           o=owl.nextInt();
         switch (o) {
            case 1:
               System.out.print("\n Ingresa el elemento: ");
               val=owl.nextInt();
               lista.push(val);
               break;

            case 2:               
               lista.verIF();               
               break;

            case 3:               
               lista.verFI();
               break;

            case 4:
               if(!lista.vacio()){
                  System.out.print("-Ingrese el elemento a eliminar: ");
                  val=owl.nextInt();
                  lista.eliminar(val);
               }else{
                  System.out.println("-Lista vacia");
               }
               break;

            case 5:
               if(!lista.vacio()){
                  System.out.print("-Ingrese el elemento a eliminar: ");
                  val=owl.nextInt();
                  lista.buscar(val);
               }else
                  System.out.println("-Lista vacia");
               break;
            
            case 6:

               System.out.println(" -La raíz es: "+lista.inicio.val);
               
               break;

            case 0:
               System.out.println("...");
               break;
         
            default:
               System.out.println("-Ingrese una opción valida-");
               break;
         }
      } while (o!=0);
   }
}

class Nodo{
   public int val;
   Nodo sig; 
   Nodo ant;

   public Nodo(int v){
      this(v,null,null);
   }

   public Nodo(int v, Nodo s, Nodo a){
      val=v;
      sig=s;
      ant=a; 

   }

   public int getVal() {
      return val;
   }

   public Nodo getSig() {
      return sig;
   }

   public Nodo getAnt() {
      return ant;
   }

}

class Lista{
   Nodo inicio, fin;
   
   public Lista(){
      inicio=null;
      fin=null;
   }

   public boolean vacio(){
      if (inicio==null){
         return true;
      }else {
         return false;  
      }
   }

   public void push(int v){
      if (!vacio()) {
         fin=new Nodo(v, null, fin);
         fin.ant.sig=fin;
      } else {
       inicio=fin=new Nodo(v);  
      }
   }

   public void verIF(){
		if(vacio()){
			System.out.println("Lista vacia");
			return;
		}else{
			Nodo aux=inicio;
			while(aux!=null){
				System.out.print(" "+aux.getVal());
				aux=aux.getSig();
			}
		}
	}

   public void verFI(){
		if(vacio()){
			System.out.println("Lista vacia");
			return;
		}else{
			Nodo aux=fin;
			while(aux!=null){
				System.out.print(" "+aux.getVal());
				aux=aux.getAnt();
			}
		}
   }

   public void eliminar(int val){         
      Nodo act=inicio;
      Nodo antr=null;
      while (act!=null) {
         if (act.val==val) {
            if (act==inicio) {
               inicio=inicio.sig;
               inicio.ant=null;
            }else{
               antr.sig=act.sig;
               act.sig.ant=act.ant;
               }
            }
         antr=act;
         act=act.sig;
      }
   }

   public void buscar(int val){
      Nodo aux=inicio;
      boolean e=false;
      while(aux!=null){
         if(val==aux.val)
            e=true;
         aux=aux.sig;
      }
      if(e){
         System.out.println("-El elemento se encuantra en la lista-");
      }else
         System.out.println("-El elemento "+val+", no se encuentra en la lista-");
   }

}