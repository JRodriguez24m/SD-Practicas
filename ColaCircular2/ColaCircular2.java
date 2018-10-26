
import java.util.Scanner;
class ColaCircular2{
   public static void main(String[] args) {
      Scanner owl=new Scanner(System.in);
      Cqueue queue=null;   
      int mm,val;
      char mmm='n';
      do {
         System.out.print("\nCola circular.\n"+
                          "1. Crear Cola.\n"+
                          "2. Ingresar elemento.\n"+
                          "3. Eliminar primero.\n"+
                          "4. Ver cola.\n"+
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
               queue.peek();
               break;

            case 0:           
               break;
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

   public void peek(){
      for (int i = 0; i < queue.length; i++) {
         System.out.print(queue[i] + " ");
      }     
   }
}