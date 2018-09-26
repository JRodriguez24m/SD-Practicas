
import java.util.*;
public class Stacks_pp {
	//cargo la clase scanner para poder ingresar parametros
	static Scanner owl=new Scanner (System.in);

	//declaro el arreglo como statico
	static int[] stack=new int[5];
	//Metodo push, va a recibir el dato y la posicion a la cual se va a Ingresar
	//dentro de la pila
	public static void push(int var, int pos){
			stack[pos]=var;
	}

	public static void main(String[] args) {
		/* declaro 4 variables
		val para recirbir al dato
		pos para identificar la posicion
		menu que se ra usado para switch*/
		int val, pos=0, menu,exit=0;
// variable de tipo char para saber si se desea ingresar otro elemento
		char otro='n';
		//inicio de ciclo doW para el menu
		do {

			System.out.println(" \nEscriba:\n 1. Ingresar valor\n"
										  + " 2. Imprimir\n"
										  + " 0. para salir");
			menu=owl.nextInt();
			switch (menu) {
			case 0:
			//SI el usuario ingresa 0 sale del ciclo y se cierra el programa
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
			default:
				break;
			}
		} while (menu!=0);
	}
}
