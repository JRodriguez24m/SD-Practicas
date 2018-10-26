import java.util.Scanner;
class ListasEnlazadas{
	public static void main(String[] args){
        int m;
        Object val;
        Lista l=null;
        Scanner owl=new Scanner(System.in);
        do {
            System.out.print("\n\nListas enlazadas\n"+
            "   1.Crear\n"+
            "   2.Ingresar\n"+
            "   3.ver\n"+
            "   0.Salir\n       Opcion:");
            m=owl.nextInt();
            switch (m) {
                case 1:
                  if (l!=null) {
                     l=new Lista();
                     System.out.println("-Se creo la lista-");                     
                  } else {
                     System.out.println("-Ya esta creada la lista-");
                  }
                    break;
                case 2:
                    System.out.print("  Ingresa el elemento: ");
                    val=owl.next();
                    l.push(val);
                    break;
                case 3:
                    l.peek();
                    break;
                case 0:
                    System.out.println("...");
                    break;
                default:
                  System.out.println("-Ingrese una opcion valida-");
                    break;
            }
        } while (m!=0);
        owl.close();
	}
}

class Nodo{
	private Object val;
	private Nodo next;

	public Nodo(Object val){
		this.val=val;
		this.next=null;			
	}

	public Object getVal() {
		return this.val;
	}

	public void setVal(Object val) {
		this.val = val;
	}

	public Nodo getNext() {
		return this.next;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}
}
/**********************************************/
class Lista{
	private int size;
	private Nodo in, fn;
	Lista(){
	    size=0;
        in=null; 
        fn=null;
	}
	public boolean Empty(){
		if(in==null){
			return true;
		}else{
			return false;
		}
	}
	public void push(Object val){
		Nodo acts;//nodo actual
		if(Empty()){//si esta vacia va a entrar
			acts=new Nodo(val);
			in=acts;
            fn=acts;
            size++;
		}else{
			acts=new Nodo(val);
			fn.setNext(acts);
            fn=acts;
            size++;
		}
	}
	public void peek(){
		if(Empty()){
			System.out.println("Lista vacia");
			return;
		}else{
			Nodo aux;
			aux=in;
			while(aux!=null){
				System.out.print(" "+aux.getVal());
				aux=aux.getNext();
			}
		}
	}
	public void pop(){
		
	}
}