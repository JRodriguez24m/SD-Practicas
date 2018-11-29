import java.util.Scanner;

class proy{
   public static void llenar(int [] vec,int [] vec2, int [] vec3, int [] vec4){
       System.out.println("    -Vector generado-    \n");
      for (int i = 0; i < vec.length; i++) {
         vec[i]=vec2[i]=vec3[i]=vec4[i]=(int)(Math.random() * 999)+1;
         System.out.print(" "+vec[i]);
      }
   }
   public static void main(String[] args) {

     Scanner owl = new Scanner(System.in);
     ordena Ordenar=new ordena();
     int o,oo,n=0;
     int[]vector=null;
     int[]vector2=null;
     int[]vector3=null;
     int[]vector4=null;
     boolean ff=false;
     long a,b;
     double tiempo;
     
     do {
        try {
           System.out.print("\n\n\n\n    -Métodos de ordenamiento-\n"+
           "\n 1. Generar vector."+
           "\n 2. Ordenar."+
           "\n 0. Salir.\n    Opción: ");
           o=owl.nextInt();
           switch (o) {
            case 0:
                ff=true;
            break;

            case 1:
                System.out.print("      -Ingrese el tamaño del vector: ");
                n=owl.nextInt();
                vector=new int[n];
                vector2=new int[n];
                vector3=new int[n];
                vector4=new int[n];
                llenar(vector,vector2,vector3,vector4);
            break;

            case 2:
                System.out.print("\n\n    --ORDENAR-\n"+
                "\n   1. Bubble Sort."+
                "\n   2. Quick Sort."+
                "\n   0. Regresar.\n    Opción: ");
                oo=owl.nextInt();

                switch(oo){
                    case 0:

                    break;

                    case 1:
                        a=System.nanoTime();    
                        Ordenar.BubbleSort(vector);
                        b=System.nanoTime();
                        tiempo=(double)(b-a)*1e-9;
                        System.out.println("\n\n ---TIEMPO DE EJECUCION -- Bubble Sort: "+tiempo);
                        System.out.println("    -Vector ordenado-\n");
                        Ordenar.Mostrar(vector);                        
                    break;

                    case 2:
                        a=System.nanoTime();
                        Ordenar.Qsort(vector2, 0, vector2.length-1);
                        b=System.nanoTime();
                        tiempo=(double)(b-a)*1e-9;
                        System.out.println("\n\n ---TIEMPO DE EJECUCION -- QuickSort: "+tiempo);
                        System.out.println("    -Vector ordenado-\n");
                        Ordenar.Mostrar(vector2);
                    break;
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

    public void BubbleSort(int[]vec){
        
        int aux;
        for (int i = 0; i < vec.length; i++) {
            for (int j = i + 1; j < vec.length; j++) {
                if(vec[i]>vec[j]){
                    aux=vec[i];
                    vec[i]=vec[j];
                    vec[j]=aux;
                }
            }   
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

            if(a<j){
                Qsort(vec, a, j);
            }
            if(i<b){
                Qsort(vec, i, b);
            }
        } while (i<=j);
    }
}