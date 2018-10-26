
import java.util.Scanner;
class ColaCircular3{
   public static void main(String[] args) {
      Scanner owl=new Scanner(System.in);
      Cqueue queue=null;   
      int mm,val,mv,vv;
      char mmm='n';
      do {
         System.out.print("\nCola circular.\n"+
                          "1. Crear Cola.\n"+
                          "2. Ingresar elemento.\n"+
                          "3. Eliminar primero.\n"+
                          "4. Ver/buscar.\n"+
                          "0. Salir.\n  Opcion: ");mm=owl.nextInt();
         switch (mm) {
            case 1:
               if (queue==null) {
                  queue=new Cqueue();
                  System.out.println("Se creo la cola...\n");
               } else { 
                  System.out.println("La cola ya esta creada...\n");
               }
               break;
            case 2:
               if (queue==null) {
                  System.out.println("Cree una cola primero...\n");
               } else {                  
                  do {
                     
                     System.out.print("   \nIngrese el elemento: "); val=owl.nextInt();
                     queue.push(val);
                     
                     System.out.print(" ¿Ingres ar otro?(S/n)");
                     mmm=owl.next().charAt(0);                           
                                
                  } while (mmm!='n');
                  
               }
               break;
            case 3:
               System.out.println("-Se elimino elemento-\n");
               queue.Pop();
               break;
            case 4:
            do {
               System.out.print("   -ver\n"+
                                 "     1.Ver cola completa\n"+
                                 "     2.Ver primero\n"+
                                 "     3.ver ultimo\n"+
                                 "     4.Buscar elemento\n"+
                                 "     0.volver\n"+
                                 "        opcion: ");mv=owl.nextInt();
               switch (mv) {
                  case 1:
                     queue.peek();
                     break;
                  case 2:
                     queue.peekF();
                     break;
                  case 3:
                     queue.peekL();
                     break;
                  case 4:
                     System.out.print(" -Ingrese el elemento a buscar: ");
                     vv=owl.nextInt();
                     queue.search(vv);
                     break;
                  case 0:

                     break;
               
                  default:
                  System.out.println("Ingrese una opcion valida...\n");
                     break;
               }               
            } while (mv!=0);
               break;

            case 0:        
            default:
               System.out.println("Ingrese una opcion valida...\n");
               break;
         }
      } while (mm!=0);
      owl.close();
   }
}

class Cqueue{
   private int [] queue = new int[5];
   private int x=0, y=0; 
   boolean tt=false,f=true;

   public void push(int val){
      if (val!= 0) {
         if (tt==true) {
            System.out.println("Cola llena... \n");
         } else {                    
        	 
        	queue[x]=val;  
            x++;
            if(x>4)
                x=0;            
            if((x==y)&&(f==false))
               tt=true;
            f=false;
         }
      }else
         System.out.println("Asegurese de ingresar elementos diferentes de 0...\n");         
   }

   public void Pop(){
      if (x==y&&f==true) {
         System.out.println("Cola vacia...\n");
      } else {
            if(y>4){
                  y=0;
            }
            if(y==x)
                  tt=true;
            }

            queue[y]=0;
            
            y++;
            if(x!=y) {
            	tt=false;
            }
   }

   public void search(int vv){
      boolean e=false;
      for (int i = 0; i < queue.length; i++) {
         if (vv==queue[i]) {
            System.out.println(" -El elemeneto "+vv+" se encontro en la posicion "+(i+1));
            e=true;
         }
      }
      if (e==false) {
         System.out.println(" -El elemeneto "+vv+", NO se encontro en la cola-");
      }
   }
   public void peekF(){
      if (x==y) {
         System.out.println(" -COla vacia...");  
      } else {
         System.out.println(" -El  primer elemento es "+ queue[y]);
      }
   }
   public void peekL(){
      if (x==y) {
         System.out.println(" -COla vacia...");  
      } else {
         System.out.println(" -El  ultimo elemento es "+ queue[(x-1)]);
      }
   }
   public void peek(){
      for (int i = 0; i < queue.length; i++) {
         System.out.print(queue[i] + " ");
      }     
   }
}