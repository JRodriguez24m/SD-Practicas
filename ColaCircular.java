import java.util.Scanner;
class ColaCircular{
   public static void main(String[] args) {
      Scanner owl=new Scanner(System.in);
      Cqueue queue=new Cqueue();
      int mm,val;
      char mmm;
//s
      do {
         System.out.print("\nCola circular\n"+
                          "1. Crear Cola\n"+
                          "2. Ingresar elemento\n"+
                          "0. Salir\n  Opcion: ");mm=owl.nextInt();
         switch (mm) {
            case 1:
               if (queue!=null) {
                  queue=new Cqueue();
                  System.out.println("Se creo la cola...\n");
               } else { 
                  System.out.println("La cola ya esta creada...\n");
               }
               break;
            case 2:
               if (queue!=null) {
                  do {
                     System.out.print("   \nIngrese el elemento: "); val=owl.nextInt();
                     queue.push(val);
                     System.out.println(" ¿Ingresar otro?(S/n)");
                     mmm=owl.next().charAt(0);
                  } while (mmm!='n'||mmm!='N');
                  
               } else {
                  System.out.println("Cree una cola primero...\n");
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
      if (val != 0) {
         if(in!=ou){
            this.val=val;
            ou++;
            queue[in]=val;
         }else
            System.out.println("Cola llena...\n");
      }else
         System.out.println("Asegurese de ingresar elementos diferentes de 0...\n");         
   }

   public int getVal() {
      return this.val;
   }

   public void setVal(int val) {
      this.val = val;
   }

   public int getIn() {
      return this.in;
   }

   public void setIn(int in) {
      this.in = in;
   }

   public int getOu() {
      return this.ou;
   }

   public void setOu(int ou) {
      this.ou = ou;
   }


   public void peek(){
      for (int i = 0; i < queue.length; i++) {
         System.out.println(queue[i] + " ");
      }
   }
   

}