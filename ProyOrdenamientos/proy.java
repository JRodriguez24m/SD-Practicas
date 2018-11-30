import java.util.Scanner;

class proy{
    //método para llenar los vectores e imprimir el que se genero
   public static void llenar(int [] vec,int [] vec2, int [] vec3, int [] vec4, int [] vec5,int vec24 []){
       System.out.println("    -Vector generado-    \n");
      for (int i = 0; i < vec.length; i++) {
          //El vector se generara con numeros de 1 a 505
         vec[i]=vec2[i]=vec3[i]=vec4[i]=vec5[i]=vec24[i]=(int)(Math.random() * 505)+1;
         System.out.print(vec[i]+", ");
      }
   }
   public static void copiar(int [] vec,int [] vec2, int [] vec3, int [] vec4, int [] vec5,int vec24 []){
    for (int i = 0; i < vec.length; i++) {
        //copia los datos del vector24 a los otos
       vec[i]=vec2[i]=vec3[i]=vec4[i]=vec5[i]=vec24[i];
       
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
     int [] vector24=null;
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
                vector24=new int [n];
                //se manda a llamar el metodo llenar
                llenar(vector,vector2,vector3,vector4,vector5,vector24);
            break;
            //En el caso 2 se mandan a llamar todos los metodos de ordenamiento y se toman tiempos
            case 2:
            for(int prueba=0;prueba<10;prueba++){
                //Comprueba si  existe un vetor primero 
                llenar(vector,vector2,vector3,vector4,vector5,vector24);
                double prom=0,prom2=0,prom3=0,prom4=0,prom5=0;
                if(vector!=null){
                    //variable a1 para el tomar el inicio del tiempo
                    long a=System.nanoTime();    
                    Ordenar.BubbleSort(vector);
                    //variable b1 para tomar el tiempo final
                    long b=System.nanoTime(); 
                    //se realiza la diferencia entre los tiempos, se multiplica por 1e-9 para convertir los
                    //nanosegundos a segundos
                    tBubble=(double)(b-a)*1.0e-9;
                    System.out.println("\n\n ---TIEMPO DE EJECUCION -- Bubble Sort: "+tBubble+" Segundos");
                    System.out.println("    -Vector ordenado-\n");
                    Ordenar.Mostrar(vector);                        
                    // se repite el proceso para los otros metodos  
                    a=System.nanoTime();
                    Ordenar.Qsort(vector2, 0, vector2.length-1);
                    b=System.nanoTime(); 
                    tQ=(double)(b-a)*1.0e-9;
                    System.out.println("\n\n ---TIEMPO DE EJECUCION -- Quick Sort: "+tQ+" Segundos");
                    System.out.println("    -Vector ordenado-\n");
                    Ordenar.Mostrar(vector2);                
                    
                    a=System.nanoTime();
                    vector3=Ordenar.MergeSort(vector3);
                    b=System.nanoTime();
                    tMerge=(double)(b-a)*1.0e-9;
                    System.out.println("\n\n ---TIEMPO DE EJECUCION -- Merge Sort: "+tMerge+" Segundos");
                    System.out.println("    -Vector ordenado-\n");
                    Ordenar.Mostrar(vector3);
                
                                    
                    a=System.nanoTime();
                    Ordenar.SHell(vector4);
                    b=System.nanoTime(); 
                    tSH=(double)(b-a)*1.0e-9;
                    System.out.println("\n\n ---TIEMPO DE EJECUCION -- SHell Sort: "+tSH+" Segundos");
                    System.out.println("    -Vector ordenado-\n");
                    Ordenar.Mostrar(vector4);
                
                    a=System.nanoTime();
                    Ordenar.insercion(vector5);
                    b=System.nanoTime(); 
                    tInsert=(double)(b-a)*1.0e-9;
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
                        System.out.print("  "+(i+1));
                        if(reine[i]==tBubble){System.out.print(". Burbuja");}                        
                        if(reine[i]==tInsert){System.out.print(". Inserción");}                        
                        if(reine[i]==tMerge){System.out.print(". Merge");}                        
                        if(reine[i]==tQ){System.out.print(". Quick");}                        
                        if(reine[i]==tSH){System.out.print(". Shell");}
                        System.out.print(" con "+reine[i]+"s.\n "); 
                        prom=(prom+tBubble)/2;      
                        prom2=(prom2+tInsert)/2; 
                        prom3=(prom3+tMerge)/2; 
                        prom4=(prom4+tQ)/2; 
                        prom5=(prom5+tSH)/2; 

                    }
                    //se calculan los promedios del tiempo de cada vector
                    double promedios[]={prom,prom2,prom3,prom4,prom5};
                    Ordenar.b(promedios);
                    System.out.println("\n\n***Promedios***\n");
                    for (int i = 0; i < promedios.length; i++) {
                        System.out.print("  "+(i+1));
                        if(promedios[i]==prom){System.out.print(". Burbuja");}                        
                        if(promedios[i]==prom2){System.out.print(". Inserción");}                        
                        if(promedios[i]==prom3){System.out.print(". Merge");}                        
                        if(promedios[i]==prom4){System.out.print(". Quick");}                        
                        if(promedios[i]==prom5){System.out.print(". Shell");}
                        System.out.print(" con "+promedios[i]+"s.\n "); 
                        

                    }
                }else{
                    System.out.println("\n----Cree un vector primero----\n");
                }

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
    
    //Metodo para mostrar los arreglos
    public void Mostrar(int [] vec){
       for (int i = 0; i < vec.length; i++) {
          System.out.print(vec[i]+", ");
       }
    }

    //Primer metodo de ordenamiento- burbuja
    public void BubbleSort(int[]vec){
        //variable auxiliar para hacer el cambio
        int aux;
        for (int i = 0; i < vec.length; i++) {
            for (int j = i + 1; j < vec.length; j++) {
                /*Condicion para hacer el cambio, si el numero que se encuentra en la posicion i
                es mayor al que esta en la posicion j se hace el cambio*/
                if(vec[i]>vec[j]){
                    aux=vec[i];
                    vec[i]=vec[j];
                    vec[j]=aux;
                }
            }   
        }
        
    }

    /*Segundo metod burbuja, este de tipo double, que recibira los tiempos de los metodos
    para ordenarlos */
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

    
    /*Segundo metodo de ordenamiento, Quick, recibira el vector y los indices a y b, que seran 
    primero y ultimo respectivamente */
    public void Qsort(int [] vec,int a, int b){

        /*Se crea la variable auxiliar para hacer los cambios, el pivote que estara lo mas cerca a la mitad
        y las variables i y j que se les asignaran los valores de a y b respectivamente */
        int aux,i=a,j=b,pivote=vec[(a+b)/2];
        //inicio del ciclo do-while que se epetira mientras i sea menor o igual a j
        do {
            //Ciclo while para aumentar el indie i, siempre y cuando el numero que este en la posicion
            //i sea menor al numero que este en el pivote.
            while(vec[i]<pivote){
                i++;
            }
            /*en este ciclo se disminuira j siempre y cuando el numero que este en la posicion j
            sea mayor al que este en la posicion pivote. */
            while(vec[j]>pivote){
                j--;
            }
            /* Condicion para realizar el cambio, cuando el numero en i sea menor o igual
            al que esta en j, de esta manera se enviaran los numeros mayores a la derecha y los
            menores a la izquierda*/
            if(i<=j){
                aux=vec[i];
                vec[i]=vec[j];
                vec[j]=aux;
                //una vez realizado el cambio los indices avanzan 1
                i++;
                j--;
            }
            
            
        } while (i<=j);

        /*se manda a llamar este mismo metodo para ordenar el lado izquierdo y derecho, creando nuevos pivotes
        e indices para ser ordenados*/
        if(a<j){
            Qsort(vec, a, j);
        }
        if(i<b){
            Qsort(vec, i, b);
        }
    }

    //Metodo de ordenamiento merge recibira un vector y lo retornara ordenado
    public int [] MergeSort(int [] vec){    
        //se crean los indices i, j y k, para el vector principa y izquierdo y el derecho respectivamente
        int i,j,k;   
        //se realizara una comprobacion, ya se se estara subdividiendo en diferentes vectores
        //se realizara el ordenamiento siempre y cuando el vector sea mayoy a 1, de lo contrario
        //ya estara ordenado
        if(vec.length>1){
            // se toman la medidas, para crear los vectores izquierdo y derecho
            int nIzq=vec.length/2,nDer=vec.length-nIzq;

            int vIzq[]=new int[nIzq];
            int vDer[]=new int [nDer];

            //ciclo para copiar los valores del  original al izquierdo
            for ( i = 0; i < nIzq; i++) {
                vIzq[i]=vec[i];
            }

            //se copian los valores del original al derecho
            for ( i = nIzq; i < nIzq+nDer; i++) {
                vDer[i-nIzq]=vec[i];
            }      
            
            //se manda a llamar este mismo metodo hasta que los elementos queden individuales.
            vIzq=MergeSort(vIzq);
            vDer=MergeSort(vDer);

            //se igualan los indicies a 0, con i para el original, j para el izquierdo, k para el derecho
            i=j=k=0;
            //ciclo while para realizar la mezcla, con un ciclo while que se recorrera
            /*siempre y cuando la longitud de vector izquierdo sea diferente a j y 
            la longitud del vector derecho sea diferente de k*/
            while (vIzq.length!=j&&vDer.length!=k) {
                /*se asignara lo que este en la posicion i al vector izquierdo en j siempre y cuando
                lo que este en la posicion  j del izq sea menor alo que este en la posicion k del derecho */
                if(vIzq[j]<vDer[k]){
                    vec[i]=vIzq[j];
                    i++;
                    j++;
                //si ees menor se realiza lo contrario
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
    //método shell
    public void SHell(int [] vec){
        //variable dist que sera la distancia con la que se compararan los elementos
        //auxiliar para realizar el cambio y los indices i, j y k que son los que se compararan
        int dist,aux,i,j,k;
        dist=vec.length/2;
        //ciclo while que se repetira hasta que la distancia sea 0
        while (dist>0) {
            //ciclo for para recorrer la distancia con que se comparan los elementos            
            for(i =dist; i<vec.length; i++){
                //se asigna a la distancia variable j con la que se comparara i
                j=i-dist;
                //ciclo while, que se recorrera cuando j sea mayor o igual a 0
                while (j>=0) {
                    k=j+dist;
                    //condicion para realizar el ordenamiento
                    //si el elemento de la posicion j es menor al de k se asigna un valor menor 
                    //a 0 para que ya no se repita el ciclo while.
                    if (vec[j]<=vec[k]){
                        j=-24;
                    }else{
                        //
                        aux=vec[j];
                        vec[j]=vec[k];
                        vec[k]=aux;
                        j=j-dist;
                    
                    }
                }
            }
            //se acorta la distancia
            dist=dist/2;
        }
    }

    //metodo de insercion
    public void insercion(int [] vec){
        //indices i y j ara realizar comparaciones y variale aux para realizar los cambios
        int aux,i,j;
        //ciclo que recorrera el vector desde la posicion 1 
        for(i=1;i<vec.length;i++){
            //se guardara el elemento de la posicion i en la variable auxiliar
            aux=vec[i];
            //se asigna al indice j una posicion antes del indice i 
            j=i-1;
            // Se recorrera este ciclo para realizar comprobaciones con los elementos anteriores*/
            while (j>=0&&vec[j]>aux) {
                //se asigna el elemento en nla posicion j+1 en la posicion j
                vec[j+1]=vec[j];
                
                j--;
            }
            //se asignara elemento alamcenado en la posicion j+1
            vec[j+1]=aux;
        }
    }
}
