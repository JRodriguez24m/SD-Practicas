import java.util.*;

class bubbleSort{
   public static void main(String[] args) {
      Scanner owl= new Scanner(System.in);
      ordena bo=new ordena();
      int x=0,op=0;
      int [] a=null;
      
         do {
            System.out.print("\n\n\n\n Ordenamiento método de la burbuja\n"+
         "  1. Ingresar/modificar tamaño\n"+
         "  2. Ingresar datos\n"+
         "  3. ver\n"+
         "  4. Ordenar\n"+
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

class ordena{
   int i=0,j=0,aux=0;
   
   public void bubble(int [] a){
      for (i = 0; i < a.length; i++) {
         for (j = i+1; j < a.length; i++) {
            if (a[i]>a[j]){
               aux=a[i];
               a[i]=a[j];
               a[j]=aux;
            }
         }
      }
   }
   public void mostrar (int [] a){
      for (int k = 0; k < a.length; k++) {
         System.out.print(" "+a[k]);
      }
   }
}