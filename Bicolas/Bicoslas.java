import java.util.Scanner;

class Bicolas{
   public static void main(String[] args) {
      Mbicolas queue = new Mbicolas();
      Scanner owl=new Scanner(System.in);
      int m,val;
      do {
         System.out.println("Menu\n 1. Inresar por la derecha.\n 2. Inresar por la Izquierda.");
         m=owl.nextInt();
         switch (m) {
            case 1:
               System.out.print("    Ingrese  el elemento: ");
               val=owl.nextInt();
               queue.PushDer(val);
               break;
            case 2:
               System.out.print("    Ingrese el elemento: ");
               val=owl.nextInt();
               queue.PushIZQ(val);
               break;
            case 6:
                        
            default:
               break;
         }
      } while (m!=0);

   }
}

class Mbicolas{
   private int a=0, b=9, x=9, y=0;
   int[]queuee=new int[10];
   public void PushIZQ(int val){
      queuee[b]=val;
      b++;
      x--;
   }
   public void PushDer(int val){
      queuee[x]=val;
      x--;
      b--;
   }
   public void see(){
      for (int i = 0; i < queuee.length; i++) {
         
      }
   }
}