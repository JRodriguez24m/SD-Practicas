import java.util.*;

class bSecuencial{
   public static void main(String[] args) {
      Scanner owl= new Scanner(System.in);
      bs bo=new bs();
      int x=0,op=0;
      int [] a=null;
      
         do {
            System.out.print("\n\n\n\n Busqueda secuencial\n"+
         "  1. Ingresar/modificar tamaño\n"+
         "  2. Ingresar datos random\n"+
         "  3. ver\n"+
         "  4. Buscar elemento\n"+
         "  0. Salir\n    Opción: "); 
         op=owl.nextInt();
         switch (op) {
            case 1:
               System.out.print("\n   -Ingrese el tamaño: "); x=owl.nextInt();
               a=new int [x];
               break;

            case 2:
               for (int i = 0; i < a.length; i++) {
                  a[i]=(int)(Math.random()*15+5);
               }
               System.out.println("   -Vector generado\n");
               bo.mostrar(a);
               break;
            case 3:
               bo.mostrar(a);
               break;

            case 4:
               bo.bubble(a);
               break;

            case 0:
               break;
            default:
               break;
         }
         } while (op!=0);
      
   }
}

class bs{
      Boolean ReineL = false;
   public void busqueda(int [] a, int val){
      for(int i=0; i < a.length; i++){
            if (val==a[i]){
                  ReineL = true;
            }
            }
            if (ReineL==true){
                  
            }
      }

   public void mostrar (int [] a){
      for (int k = 0; k < a.length; k++) {
         System.out.print(" "+a[k]);
      }
   }
}