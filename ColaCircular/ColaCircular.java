import java.util.Scanner;
class ColaCircular{
   public static void main(String[] args) {
      Scanner owl=new Scanner(System.in);
      Cqueue queue=null;   
      int mm,val;
      char mmm='n';
//s
      do {
         System.out.print("\nCola circular.\n"+
                          "1. Crear Cola.\n"+
                          "2. Ingresar elemento.\n"+
                          "3. Ver cola.\n"+
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
   private int val=0, in=0, ou=1;

   public void push(int val){
      this.val=val;
      if (val!= 0) {
         if (in==ou) {
            System.out.println("Cola llena... \n");
          //  return;
         } else {                    
            queue[ou]=val;       
            ou++;
            if(ou>4)
               ou=0;  
         }
                    
      }else
         System.out.println("Asegurese de ingresar elementos diferentes de 0...\n");         
   }

   public void peek(){
      for (int i = 0; i < queue.length; i++) {
         System.out.print(queue[i] + " ");
      }
   }

   public int getIn(){
      return in;
   }
   public int getOu(){
      return ou;
   }
   

}