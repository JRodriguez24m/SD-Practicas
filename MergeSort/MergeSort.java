import java.util.Scanner;

class MergeSort{
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
           System.out.print("\n\n\n\n    -Merge Sort-\n"+
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
                    Ordenar.MergeSort(vector);
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
          while(vIzq.length!=j){
              vec[i]=vIzq[j];
              i++;
              j++;
          }
          while (vDer.length!=k) {
              vec[i]=vDer[k];
              i++;
              k++;
          }
      }
      return vec;        
  }


}
