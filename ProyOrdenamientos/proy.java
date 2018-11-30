import java.util.Scanner;

class proy{
    //método para llenar los vectores e imprimir el que se genero
   public static void llenar(int [] vec,int [] vec2, int [] vec3, int [] vec4, int [] vec5){
       System.out.println("    -Vector generado-    \n");
      for (int i = 0; i < vec.length; i++) {
          //El vector se generara con numeros de 1 a 505
         vec[i]=vec2[i]=vec3[i]=vec4[i]=vec5[i]=(int)(Math.random() * 505)+1;
         System.out.print(vec[i]+", ");
      }
   }
   public static void main(String[] args) {

     Scanner owl = new Scanner(System.in);
     //creo el objeto, en donde estan los metodos de ordenamiento
     ordena Ordenar=new ordena();
     //variable o para usarse en el menu y n  para el tamaño del vector
     int o,n=0;
     int[]vector=null;
     int[]vector2=null;
     int[]vector3=null;
     int[]vector4=null;
     int[]vector5=null;
     //variable booleana para salir
     boolean ff=false;
     //variables para medir los tiempos de ejecucion
     double tBubble,tQ,tMerge,tSH,tInsert;
     // do while para el menu
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
                owl.close();
            break;
           // en el caso 1 se crean los vecotres a ordenar
            case 1:
                System.out.print("      -Ingrese el tamaño del vector: ");
                n=owl.nextInt();
                vector=new int[n];
                vector2=new int[n];
                vector3=new int[n];
                vector4=new int[n];
                vector5=new int[n];
                //se manda a llamar el metodo llenar
                llenar(vector,vector2,vector3,vector4,vector5);
            break;
            //En el caso 2 se mandan a llamar todos los metodos de ordenamiento y se toman tiempos
            case 2:
                //variable a1 para el tomar el inicio del tiempo
                long a1=System.nanoTime();    
                Ordenar.BubbleSort(vector);
                //variable b1 para tomar el tiempo final
                long b1=System.nanoTime();
                //se realiza la diferencia entre los tiempos, se multiplica por 1e-9 para convertir los
                //nanosegundos a segundos
                tBubble=(double)(b1-a1)*1e-9;
                System.out.println("\n\n ---TIEMPO DE EJECUCION -- Bubble Sort: "+tBubble+" Segundos");
                System.out.println("    -Vector ordenado-\n");
                Ordenar.Mostrar(vector);                        
                // se repite el proceso para los otros metodos  
                long a2=System.nanoTime();
                Ordenar.Qsort(vector2, 0, vector2.length-1);
                long b2=System.nanoTime();
                tQ=(double)(b2-a2)*1e-9;
                System.out.println("\n\n ---TIEMPO DE EJECUCION -- Quick Sort: "+tQ+" Segundos");
                System.out.println("    -Vector ordenado-\n");
                Ordenar.Mostrar(vector2);                
                
                long a3=System.nanoTime();
                vector3=Ordenar.MergeSort(vector3);
                long b3=System.nanoTime();
                tMerge=(double)(b3-a3)*1e-9;
                System.out.println("\n\n ---TIEMPO DE EJECUCION -- Merge Sort: "+tMerge+" Segundos");
                System.out.println("    -Vector ordenado-\n");
                Ordenar.Mostrar(vector3);
               
                                  
                long a4=System.nanoTime();
                Ordenar.SHell(vector4);
                long b4=System.nanoTime();
                tSH=(double)(b4-a4)*1e-9;
                System.out.println("\n\n ---TIEMPO DE EJECUCION -- SHell Sort: "+tSH+" Segundos");
                System.out.println("    -Vector ordenado-\n");
                Ordenar.Mostrar(vector4);
            
                long a5=System.nanoTime();
                Ordenar.insercion(vector5);
                long b5=System.nanoTime();
                tInsert=(double)(b5-a5)*1e-9;
                System.out.println("\n\n ---TIEMPO DE EJECUCION -- Inserción Sort: "+tInsert+" Segundos");
                System.out.println("    -Vector ordenado-\n");
                Ordenar.Mostrar(vector5);
                // se crea el vector reine para almacenar los tiempos
                double  reine[]={tBubble,tInsert,tMerge,tQ,tSH};
                //se ordenan los tiempos de menor a myor
                Ordenar.b(reine);
                System.out.println("\n\n\n----Tiempos----");  
                //ciclo for para mostrar los tiempos en orden acendente              
                for (int i = 0; i < reine.length; i++) {
                    System.out.print("--"+(i+1));
                    if(reine[i]==tBubble){System.out.print(". burbuja");}                        
                    if(reine[i]==tInsert){System.out.print(". Insercion");}                        
                    if(reine[i]==tMerge){System.out.print(". MErge");}                        
                    if(reine[i]==tQ){System.out.print(". quick");}                        
                    if(reine[i]==tSH){System.out.print(". shell");}
                    System.out.print(" con "+reine[i]+"s.\n ");                    
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


    public void b(double[]vec){
        
        double aux;
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

    public int [] MergeSort(int [] vec){    
        int i,j,k;   
        if(vec.length>1){
            int nIzq=vec.length/2,nDer=vec.length-nIzq;

            int vIzq[]=new int[nIzq];
            int vDer[]=new int [nDer];

            for ( i = 0; i < nIzq; i++) {
                vIzq[i]=vec[i];
            }

            for ( i = nIzq; i < nIzq+nDer; i++) {
                vDer[i-nIzq]=vec[i];
            }      
            
            vIzq=MergeSort(vIzq);
            vDer=MergeSort(vDer);

            //i para el original, j para el izq, k para el derecho
            i=j=k=0;

            while (vIzq.length!=j&&vDer.length!=k) {
                if(vIzq[j]<vDer[k]){
                    vec[i]=vIzq[j];
                    i++;
                    j++;
                }else{
                    vec[i]=vDer[k];
                    i++;
                    k++;
                }
            }
            //se empieza a llenar el arreglo final pasando la parte izquierda
            while(vIzq.length!=j){
                vec[i]=vIzq[j];
                i++;
                j++;
            }
            //se  pasa la parte derecha al arreglo final
            while (vDer.length!=k) {
                vec[i]=vDer[k];
                i++;
                k++;
            }
        }
        
        return vec;        
    }

    public void SHell(int [] vec){
        int dist,aux,i,j,k;
        dist=vec.length/2;
        while (dist>0) {
            for(i =dist; i<vec.length; i++){
                j=i-dist;
                while (j>=0) {
                    k=j+dist;
                    if (vec[j]<=vec[k])
                        j=-24;
                        else{
                        aux=vec[j];
                        vec[j]=vec[k];
                        vec[k]=aux;
                        j=j-dist;
                    }
                }
            }
            dist=dist/2;
        }
    }

    public void insercion(int [] vec){
        int aux,i,j;
        for(i=1;i<vec.length;i++){
            aux=vec[i];
            j=i-1;
            while (j>=0&&vec[j]>aux) {
                vec[j+1]=vec[j];
                j--;
            }
            vec[j+1]=aux;
        }
    }
}
