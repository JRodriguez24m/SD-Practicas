import java.util.Scanner;

class Bicolas{
   public static void main(String[] args) {
      Mbicolas queue = new Mbicolas();
      Scanner owl=new Scanner(System.in);
      int m,val,mm;
      do {  
            
            queue.see();

            System.out.print("Menu\n 1. Inresar.\n"+
                             " 0.Salir\n"+
                             "      opcion: ");
                            m=owl.nextInt();
            switch (m) {
                  case 1:                 
                        do {
                              System.out.print("\n  -Ingresar:\n"+
                                                "   1.Por la derecha\n"+
                                                "   2.Por la izquierda\n"+
                                                "   0.Regresar\n"+
                                                "     opcion: ");mm=owl.nextInt();
                              switch (mm) { 
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
                                    case 0:
                                          
                                          break;
                              
                                    default:
                                          break;
                              }
                        } while (mm!=0);
                        break;

                  case 2:
                        
                        break;
                  case 0:
                        break;
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
            if(empy()){
                  System.out.println("---Cola llena---");
            }else{
                  queuee[a]=val;
                  a++;
                  y++;
            }
      }
      public void PushDer(int val){
            if (empy()) {
                  System.out.println("---Cola llena---");
            } else {             
                  queuee[x]=val;
                  x--;
                  b--;     
            }
      }
      public void see(){
            System.out.println("--------------------------------");
            for (int i = 0; i < queuee.length; i++) {
                  System.out.print("  "+queuee[i]);
            }
            System.out.println("\n--------------------------------");
      }
      public boolean empy(){
            if((a-1)==x){
                  return true;
            }else{
                  return false;
            }
      }
}