import java.util.Scanner;
class ColaCLientes{
  static Scanner owl=new Scanner(System.in);
  static int [] queue = new int[5];

  public static void Push (int pos, int val){
      		queue[pos]=val;
  }

  public static void pop(int pos){
    for (int i=0; i<queue.length -1; i++) {
        queue[i]=queue[i+1];
    }
    queue[pos-1]=0;
  }
  public static void imp(){
    for (int i=0; i<queue.length; i++) {
      System.out.print("    Cliente "+queue[i]+", ");
    }
  }

  public static void main(String[] args) {
    int Sme, pos=0, val=0,f=0,mq;
    char o;
    do {
      System.out.print("\n*Caja 1.\n"+
      "  1. Nuevo cliente. \n" +
      "  2. Sale de la cola.\n"+
      "  3. Mostrar cola\n"+
      "  0. salir. \n" +
      "     Opción: "); Sme=owl.nextInt();
      switch (Sme) {
        case 0:
              System.out.println("Programa cerrado...");
          break;
        case 1:
				do {
		            if (pos>4) {
		        		System.out.println("\nCola llena...\n");
		        		o='n';
		            }else {
		            	System.out.print("	Nuevo cliente: ");
			            val=owl.nextInt();
			            Push(pos,val); pos++;
			            System.out.print("¿Ingresar otro? (s/n)");
			            o=owl.next().charAt(0);
		            }
				}while(o!='n');
        	break;
        case 2:
            if (pos<=0) {
              System.out.println("\nCola vacia...\n");
            }else {
              pop(pos);
              pos--;
            }
          break;
        case 3:
            imp();
          break;

        default:
          System.out.println("**Ingrese una opción valida.");
          break;
      }
    } while (Sme!=0);
  }
}
