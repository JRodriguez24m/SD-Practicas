import java.util.Scanner;

class QuickSort{
   public static void llenar(int [] vec){
       System.out.println("    -Vector generado-    \n");
      for (int i = 0; i < vec.length; i++) {
         vec[i]=(int)(Math.random() * 505)+1;
         System.out.print(vec[i]+", ");
      }
   }
   public static void main(String[] args) {

     Scanner owl = new Scanner(System.in);
     ordena Ordenar=new ordena();
     int o,n=0;
     int[]vector=null;
     boolean ff=false;
     do {
        try {
           System.out.print("\n\n\n\n    -Quick Sort-\n"+
           "\n 1. Generar vector."+
           "\n 2. Ordenar."+
           "\n 0. Salir.\n    Opción: ");
           o=owl.nextInt();
           switch (o) {
            case 0:
                ff=true;
                owl.close();
            break;
            case 1:
                System.out.print("      -Ingrese el tamaño del vector: ");
                n=owl.nextInt();
                vector=new int[n];
                llenar(vector);
            break;
            case 2:
                
                if(vector!=null){
                    Ordenar.Qsort(vector, 0, vector.length-1);
                    System.out.println("    -Vector ordenado-\n");
                    Ordenar.Mostrar(vector);                
                    
                }else{
                    System.out.println("\n----Cree un vector primero----\n");
                }
            break;
                  
            
            default:
                System.out.println(" \n-Ingese  una opcion valida...");
            break;
               
           }           
        } catch (Exception e) {
           System.out.println("\n -Intente de nuevo. Caracter no valido...\n\n") ;
           owl.next();
        }
     } while (!ff);
   }
}

class ordena{
    public void Mostrar(int [] vec){
       for (int i = 0; i < vec.length; i++) {
          System.out.print(vec[i]+", ");
       }
    }
    public void Qsort(int [] vec,int a, int b){
        int aux,i=a,j=b,pivote=vec[(a+b)/2];
        do {
            while(vec[i]<pivote){
                i++;
            }
            while(vec[j]>pivote){
                j--;
            }
            if(i<=j){
                aux=vec[i];
                vec[i]=vec[j];
                vec[j]=aux;
                i++;
                j--;
            }            
        } while (i<=j);
        if(a<j){
            Qsort(vec, a, j);
        }
        if(i<b){
            Qsort(vec, i, b);
        }
    }

}
