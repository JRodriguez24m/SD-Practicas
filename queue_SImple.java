import java.util.Scanner;
class queue_Simple{
  static Scanner owl=new Scanner(System.in);
  static int [] queue = null;

  public static void Create(){
    if (queue== null) {
      queue = new int [5];
      System.out.println("***Cola creada***");
    }else{
      System.out.println("***************************"+
                        "\n***Ya ha creado una cola***"+
                        "\n***************************");
    }
  }

  public static void Push (int pos, int val){

      if(val == 0)
        System.out.println("***Error: \n   No se admiten 0 en la cola\n   Porfavor ingrese un valor diferente de 0.");
      	else
      		queue[pos]=val;

  }

  public static void main(String[] args) {
    int Sme, pos=4, val=0;
    char o;
    do {
      System.out.print("\n*Cola Simple, (Creación,push)\n"+
      " Menú: \n" +
      "  1. Crear Cola. \n" +
      "  2. Ingresar datos. \n" +
      "  3. ver\n"+
      "  0. salir. \n" +
      "     Opción: "); Sme=owl.nextInt();
      switch (Sme) {
        case 0:
              System.out.println("***Programa cerrado.");
          break;
        case 1:
          Create();
          break;
        case 2:
        	if (queue==null) {

        		System.out.println("**Debe crear una cola antes**");
			}else {
				do {
		            if (pos<0) {
		        		System.out.println("**Cola llena**");
		        		o='n';
		            }else {
		            	System.out.print("	Ingrese el elemento: ");
			            val=owl.nextInt();
			            Push(pos,val); pos--;
			            System.out.print("¿Ingresar otro? (s/n)");
			            o=owl.next().charAt(0);
		            }
				}while(o!='n');
			}
          break;

        case 3:
        	for (int i = 0; i < queue.length; i++) {
				System.out.println(queue[i]);

			}
        	break;

        default:
          System.out.println("**Ingrese una opción valida.");
          break;
      }
    } while (Sme!=0);
  }
}
