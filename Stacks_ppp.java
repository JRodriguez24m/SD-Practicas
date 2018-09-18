
import java.util.*;
public class Stacks_ppp {
	static Scanner owl=new Scanner (System.in);

	static int[] stack=new int[5];
	public static void push(int var, int pos){
			stack[pos]=var;
	}

	public static void peek(int pos) {
		System.out.println("");
		for (int i = 0; i < pos; i++) {
			System.out.println(stack[i]);
		}
	}
	public static void pop(int pos) {
		stack[pos]=0;
	}

	public static void main(String[] args) {
		int val, pos=0, menu,exit=0;
		char otro='n';
		do {
			System.out.println(" \nEscriba:\n 1. Ingresar valor\n"
										  + " 2. Imprimir\n"
										  + " 3. Eliminar último valor\n"
										  + " 0. para salir");
			menu=owl.nextInt();
			switch (menu) {
			case 0:
				break;
			case 1:
				do {
					if(pos>=5) {
						System.out.println("\n**Pila llena**\n");
						otro='n';
					}else {

						System.out.println("Ingrese el dato");
						val=owl.nextInt();
						push(val,pos);

						pos++;
						System.out.print(" ¿Ingresará otro elemento?(s/n): ");
						otro=owl.next().charAt(0);
					}
				} while (otro!='n');
				break;
			case 2:
				if (pos<=0) {
					System.out.println("\n**PIla vacia**");

				}else {
					System.out.println("_____");
					peek(pos);
					System.out.println("_____");
				}
				break;
			case 3:
				do {
					if(pos<=0) {
						System.out.println("\n**Pila vacia**\n");
						otro='n';

					}else {
						pos--;
						pop(pos);
						System.out.println("¿Eliminar otro? (s/n)");
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
