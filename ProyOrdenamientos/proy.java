import java.util.Scanner;

class proy{
   public static void llenar(int [] vec,int [] vec2, int [] vec3, int [] vec4, int [] vec5){
       System.out.println("    -Vector generado-    \n");
      for (int i = 0; i < vec.length; i++) {
         vec[i]=vec2[i]=vec3[i]=vec4[i]=vec5[i]=(int)(Math.random() * 999)+1;
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
     int[]vector5=null;
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
                owl.close();
            break;

            case 1:
                System.out.print("      -Ingrese el tamaño del vector: ");
                n=owl.nextInt();
                vector=new int[n];
                vector2=new int[n];
                vector3=new int[n];
                vector4=new int[n];
                vector5=new int[n];
                llenar(vector,vector2,vector3,vector4,vector5);
            break;

            case 2:
                System.out.print("\n\n    --ORDENAR-\n"+
                "\n   1. Bubble Sort."+
                "\n   2. Quick Sort."+
                "\n   3. Merge Sort."+
                "\n   4. Shell Sort."+
                "\n   5. Insertion Sort"+
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
                        System.out.println("\n\n ---TIEMPO DE EJECUCION -- Bubble Sort: "+tiempo+" Segundos");
                        System.out.println("    -Vector ordenado-\n");
                        Ordenar.Mostrar(vector);                        
                    break;

                    case 2:
                        a=System.nanoTime();
                        Ordenar.Qsort(vector2, 0, vector2.length-1);
                        b=System.nanoTime();
                        tiempo=(double)(b-a)*1e-9;
                        System.out.println("\n\n ---TIEMPO DE EJECUCION -- Quick Sort: "+tiempo+" Segundos");
                        System.out.println("    -Vector ordenado-\n");
                        Ordenar.Mostrar(vector2);
                    break;

                    case 3:                    
                        a=System.nanoTime();
                        vector3=Ordenar.MergeSort(vector3);
                        b=System.nanoTime();
                        tiempo=(double)(b-a)*1e-9;
                        System.out.println("\n\n ---TIEMPO DE EJECUCION -- Merge Sort: "+tiempo+" Segundos");
                        System.out.println("    -Vector ordenado-\n");
                        Ordenar.Mostrar(vector3);
                    break;

                    case 4:                    
                    a=System.nanoTime();
                    Ordenar.SHell(vector4);
                    b=System.nanoTime();
                    tiempo=(double)(b-a)*1e-9;
                    System.out.println("\n\n ---TIEMPO DE EJECUCION -- SHell Sort: "+tiempo+" Segundos");
                    System.out.println("    -Vector ordenado-\n");
                    Ordenar.Mostrar(vector4);
                    break;

                    case 5:                    
                    a=System.nanoTime();
                    Ordenar.insercion(vector5);
                    b=System.nanoTime();
                    tiempo=(double)(b-a)*1e-9;
                    System.out.println("\n\n ---TIEMPO DE EJECUCION -- Inserción Sort: "+tiempo+" Segundos");
                    System.out.println("    -Vector ordenado-\n");
                    Ordenar.Mostrar(vector5);
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