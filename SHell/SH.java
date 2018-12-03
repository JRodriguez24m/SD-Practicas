import java.util.Scanner;

class SH{
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
           System.out.print("\n\n\n\n    -Shell Sort-\n"+
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
                    Ordenar.SHell(vector);
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
    public void SHell(int [] vec){
      int dist,aux,i,j,k;
      dist=vec.length/2;
      while (dist>0) {           
          for(i =dist; i<vec.length; i++){
              j=i-dist;
              while (j>=0) {
                  k=j+dist;
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
          dist=dist/2;
      }
  }


}
