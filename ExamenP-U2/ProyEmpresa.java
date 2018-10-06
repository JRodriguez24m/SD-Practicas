
import java.util.Scanner;
public class ProyEmpresa {
	static Scanner owl=new Scanner (System.in);
	static int[] ver=new int[24];
	public static void push(int var, int pos){
			ver[pos]=var;
	}
	public static void peek(int pos) {
		System.out.println("");
		for (int i = 0; i < pos; i++) {
			System.out.println("   versión "+ver[i]+".");
		}
	}
	public static void pop(int pos) {
		ver[pos]=0;
	}
	public static void main(String[] args) {
		int pos=0, menu,exit=0;
    int var;
		char otro='n';
		do {
			System.out.print(" \nMenu:\n 1. Ingresar nueva versión.\n"
										  + " 2. Ver versiones.\n"
										  + " 3. Eliminar última versión.\n"
										  + " 0. Salir.\n   Opción: ");
			menu=owl.nextInt();
			switch (menu) {
			case 0:
      System.out.println("...");
				break;
			case 1:
				do {
          if (pos>=24) {
            System.out.println("\nMemoria llena...\n");
            otro='n';
          }else{
						System.out.print("Ingrese el número de la versión: ");
						var=owl.nextInt();
						push(var,pos);

						pos++;
						System.out.print(" ¿Ingresará otra versión?(s/n): ");
						otro=owl.next().charAt(0);
          }
				} while (otro!='n');
				break;
			case 2:
				if (pos<=0) {
					System.out.println("\nNinguna versión existente...\n");

				}else {
					System.out.println("_____");
					peek(pos);
					System.out.println("_____");
				}
				break;
			case 3:
				do {
					if(pos<=0) {
						System.out.println("\nNo se encontro ninguna versión...\n");
						otro='n';
					}else {
						pos--;
						pop(pos);
						System.out.print("¿Eliminar otra?, (s/n): ");
						otro=owl.next().charAt(0);
					}
				} while (otro!='n');
				break;
			default:
				break;
			}
		} while (menu!=0);
	}
}
