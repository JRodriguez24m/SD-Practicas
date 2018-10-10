    import java.util.Scanner;
    class ColaCircular{   
        public static void main(String[] args) {
            Scanner owl=new Scanner(System.in);
            int in=0,ou=0, val=0, m;
            Met qq=null;
            do {
                System.out.print("Cola circular.\n"+
                                "1. Crear cola\n"+
                                "2. Insertar\n"+
                                "0. Salir\n    Opción: ");
                m=owl.nextInt();
                switch (m) {
                    case 1:
                        if (qq!=null) {
                            qq=new Met();
                        } else {
                            System.out.println("    La cola ya está creada...");
                        }
                        break;
                    case 2:
                        if (qq!=null) {
                            qq.push(in, ou, val);
                        } else {
                            System.out.println("    Debe crear un cola primero...");
                        }
                        break;
                    default:
                        break;
                }
            } while (m!=0);

        }

    }

    public class Met {
        private int [] queue=new int[5];
        public Met(){}

        public int push(int in, int ou, int val) {
            if(in!=ou){
                queue[ou]=val;
                in++;
                return in;
            }else{
                System.out.println("    COLA LLENA...");
                return in;
            }
        }

        public void Peek() {
            for (int i = 0; i < queue.length; i++) {
                System.out.print("  "+queue[i]);
            }
        }
    }