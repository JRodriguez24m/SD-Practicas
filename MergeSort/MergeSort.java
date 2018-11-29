import java.util.*;

class MergeSort{
   public static void main(String[] args) {
      Scanner owl= new Scanner(System.in);
      merge lizard=new merge();
      int x=0,op=0;
      int [] a=null;

         do {
            System.out.print("\n\n\n\n Ordenamiento método merge\n"+
         "  1. Ingresar/modificar tamaño\n"+
         "  2. Ingresar datos\n"+
         "  3. ver\n"+
         "  4. Ordenar\n"+
         "  0. Salir\n    Opción: ");
         op=owl.nextInt();
         switch (op) {
            case 1:
               System.out.print("\n   -Ingrese el tamaño: ");
               x=owl.nextInt();
               a=new int [x];
               break;

            case 2:
            if (a!=null){
               for (int i = 0; i < a.length; i++) {
                  a[i]=(int)(Math.random()*15+5);
               }
               System.out.println("   -Vector generado\n");
               lizard.mostrar(a);

             }else {
               System.out.println(" - Genere un vector primero. \n\n");
             }
               break;
            case 3:
               lizard.mostrar(a);
               break;

            case 4:
            if(a!=null){
              lizard.sort(a);

            }else{
              System.out.println(" - Genere un vector primero. \n\n");
            }

               break;

            case 0:
            System.out.println(" . . .\n\n");
            owl.close();
               break;
            default:
               break;
         }
         } while (op!=0);

   }
}

class merge{
   int i=0,j=0,k=0;

   public int [] sort(int [] a){
     if (a.length>  1){
       int nIzq=a.length/2, nDer=a.length-nIzq;
        int aIzq[]=new int[nIzq];
        int aDer[]=new int[nDer];
        // se inserta la parte izq en su arreglo
        for ( i = 0; i < nIzq; i++) {
          aIzq[i]=a[i];

        }
        //se inserta en el derecho
        for (i = nIzq; i < (nIzq+nDer); i++) {
          aDer[i-nIzq]=a[i];
        }

        aIzq=sort(aIzq);
        aDer=sort(aDer);

        i=j=k=0;

        while(aIzq.length !=j && aDer.length !=k ){
          if(aDer[j]<aDer[k]){
            a[i]=aIzq[j];
            i++;
            j++;
          }else{
            a[i]=aDer[k];
            i++;
            k++;
          }
        }
        //vector final
        while(aIzq.length != j){
          a[i]=aIzq[j];
          i++;
          j++;
        }
        while(aDer.length != k){
          a[i]=aDer[k];
          i++;
          k++;
        }
     }
     return a;
   }
   public void mostrar (int [] a){
      for (int s = 0; s < a.length; s++) {
         System.out.print(" "+a[s]);
      }
   }
}
