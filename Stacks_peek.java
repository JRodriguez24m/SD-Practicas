
import java.util.*;
public class Stacks_peek {
	static Scanner owl=new Scanner (System.in);

	static int[] stack=new int[5];
	public static void push(int var, int pos){
			stack[pos]=var;
	}

	public static void Imp(int pos) {
		System.out.println("");
		for (int i = 0; i < pos; i++) {
			System.out.println(stack[i]);
		}
	}

	public static void peek(int pos){
		System.out.println("\nEs: "+stack[pos]);
	}

	public static void pop(int pos) {
		stack[pos]=0;
	}
	public static void bus(int val, int pos){
		System.out.println("");
		boolean b=false;
		for (int i=0;i<stack.length ;i++ ) {
			if (val==(stack[i])){
				System.out.println("El valor ["+val+"] se encuentra en la posición ["+(i+1)+"].");
				b=true;
			}
		}if (b==false) {
			System.out.println("**No se encuentra el valor**");
		}
	}

	public static void main(String[] args) {
		int val, pos=0, menu,exit=0,menu2,valb=0;
		char otro='n';
		do {
			System.out.print(" \nEscriba:\n 1. Ingresar valor\n"
										  + " 2. Imprimir\n"
										  + " 3. Eliminar último valor\n"
										  + " 0. para salir\n"
											+ "Opcion: ");
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

						System.out.print("Ingrese el dato: ");
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
					System.out.print("Imprimir: \n1. Ultimo elemento \n2. Buscar dato \n3. Pila completa \nOpción: ");
					menu2=owl.nextInt();
					switch (menu2){
						case 1:
							peek((pos-1));
								break;
						case 2:
							System.out.print("Ingrese el valor a Buscar: ");
							 valb=owl.nextInt();
								bus(valb,pos);
								break;
						case 3:
						System.out.println("**pila completa**");
						Imp(pos);
						System.out.println("_________________");

								break;

					}
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
						System.out.print("¿Eliminar otro? (s/n)");
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
