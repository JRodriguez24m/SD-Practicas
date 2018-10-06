import java.util.Scanner;
public class EcuacionRecursiva{
  public static int ec(int ba, int ex){
    if (ex==1) {
      return ba;
    }else if (ex==0) {
      return 1;
    } else{
      return 2*ec(ba,ex-1);
    }
  }
  public static void main(String[] args) {
    Scanner owl=new Scanner(System.in);
    int o,n=0;
    do {
      System.out.print("Menu:\n 1.Ingresar exponente\n  2.Ver Resultado.\n  0.Salir\n   Opcion:");
      o=owl.nextInt();
      switch (o) {
        case 1:
            System.out.print("  -Exponente= "); n=owl.nextInt();
          break;
        case 2:
        System.out.println("Resultado= "+ec(2,n));
          break;
        case 0:
            System.out.println("...");
          break;
        default:
            System.out.println("-Ingrese una opcion valida...");
          break;
      }
    } while (o!=0);
  }
}
