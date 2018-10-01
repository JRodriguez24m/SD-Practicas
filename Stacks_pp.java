
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
										  + " 0. para salir");
			menu=owl.nextInt();
			switch (menu) {
			case 0:
			//SI el usuario ingresa 0 sale del ciclo y se cierra el programa
				break;
			case 1:
			//INicio del ciclo para llenar Pila
				do {
					//condicion para que no se puedan ingresar mas elementos en la Pila
					if(pos>=5) {
						//En caso que se cumpla se imprimira que la pila ya esta llena
						System.out.println("\n**Pila llena**\n");
						//se asignara n a la variable otro para que no deje ingresar  mas elementos
						otro='n';
					}else {
						//si, no se cumple la condicion el usuario podrá seguir ingresando elementos
						System.out.println("Ingrese el dato");
						val=owl.nextInt();
						//Se envia el elemento y la posicion a la cual se va a asignar
						push(val,pos);

						pos++;
						System.out.print(" ¿Ingresará otro elemento?(s/n): ");
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
