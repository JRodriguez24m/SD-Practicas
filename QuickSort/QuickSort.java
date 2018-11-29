import java.util.*;

class QuickSort{
   public static void main(String[] args) {
      Scanner owl= new Scanner(System.in);
      ordena bo=new ordena();
      int x=0,op=0;
      
      int [] a=null;
      
         do {
            System.out.print("\n\n\n\n Ordenamiento método de la burbuja\n"+
         "  1. IngQuickSortresar/modificar tamaño\n"+
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
            int xx=0,yy=x;
               bo.Qsort(a, xx, yy);
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
   
   
   public void Qsort (int matriz[],int a, int  b){
      int ma[]=new ma[matriz.length];
      int buf,x=a,y=b, pivote=matriz[(x+y)/2];
      do {
            while(matriz[x]<pivote){
                  x++;
            }
            while (matriz[y]>pivote) {
                  y--;
            }
            if(x<=y){
                  buf=matriz[x];
                  matriz[x]=matriz[y];
                  matriz[y]=buf;
                  x++;
                  y--;
            }
      } while (x<=y);
      if(a<y){
            Qsort(matriz, a, y);
      }
      if(x<b){
            Qsort(matriz, x, b);
      }
      matriz=ma;
   }
   public void mostrar (int [] a){
      for (int k = 0; k < a.length; k++) {
         System.out.print(" "+a[k]);
      }
   }
}