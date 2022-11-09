package adivinaadivinador;
import java.util.Random;
import java.util.Scanner; 
import static java.lang.Character.toLowerCase;
import static java.lang.System.exit;
import java.util.InputMismatchException;
public class Adivinaadivinador {
    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);
    static boolean loop = true;

    public static void juego(int dificultad) {
        if(dificultad == 0){
            System.out.println("Gracias por abrir el programa, vuelva pronto");
            exit(0);
        }
        char[] oculto, palabra;
        int faltantes, aux;
        if(dificultad == 1){
            String[] facil = {"cuba", "amen", "aseo", "bota", "cojo", "fumo", "gato", "nota", "taza", "lazo"};
            palabra = facil[rand.nextInt(10)].toCharArray();
            oculto = new char[] {'*', '*', '*', '*'};
            faltantes = 4;
            aux = 4;
        } else if(dificultad == 2) {
            String[] intermedio = {"amorcito", "animales", "anatemas", "abejones", "acerrojo", "aciertos", "adefesio", "africana", "guitarra", "pianista"};
            palabra = intermedio[rand.nextInt(10)].toCharArray();
            oculto = new char[] {'*', '*', '*', '*', '*', '*', '*', '*'};
            faltantes = 8;
            aux = 8;
        } else {
            String[] dificil = {"chiringuitos", "certificador", "capitalistas", "bolivarianos", "bolcheviques", "diccionarios", "combustibles", "circulatorio", "comprendedor", "concentrador"};
            palabra = dificil[rand.nextInt(10)].toCharArray();
            oculto = new char[] {'*', '*', '*', '*','*', '*', '*', '*','*', '*', '*', '*'};
            faltantes = 12;
            aux = 12;
        }

        while(loop) {                                           //preguntarle hasta descubrir la palabra
            int num; // con esto manejamos la excepcion de los numeros 
            System.out.println(oculto);
            System.out.print("¿Qué letra va?: ");
            char descubrir = toLowerCase(sc.next().charAt(0));
            if(descubrir == '0') {
                System.out.println("Ha usado el carácter especial, ahora el programa deberá cerrarse");
                break;
            }                         //para salir del juego si el usuario quiere
            if(descubrir == '1' || descubrir == '2' || descubrir == '3' || descubrir == '4' || descubrir == '5' || descubrir == '6' || descubrir == '7' || descubrir == '8' || descubrir == '9'){
                num = 1;
            } else {
                num = 0;
            }
            for(int j = 0; j < palabra.length; j++){
                if(descubrir == palabra[j]){
                    oculto[j] = descubrir;
                    aux--;
                }
            } //Para evaluar si la letra está en la palabra
            if(num == 1){
                System.out.println("Lo que se introdujo no es una letra, vuelva a intentarlo");
            }else{
                if(faltantes != aux){ //Con esta ciclo nos permite mantener el control de las letras que si pertenecen a la palabra
                faltantes = aux;
            } else{
                System.out.println("Esa letra no corresponde con la palabra, intente nuevamente");
            }  
            }
          
            int x = 0;
            for (char value : oculto) if (value == '*') x++;
            if(x == 0) {
                System.out.print("¡Ganaste! ¿Quieres jugar otra vez? (0 = No / cualquier otro número = Sí): ");
                int respuesta = sc.nextInt();
                if(respuesta == 0){
                    System.out.println("Gracias por jugar, esperamos que vuelva pronto");
                    break;
                }
                juego(dificultad);
            }
        }
        loop = false;
    }
    public static void main(String[] args) {
        int dificultad = 0;
        System.out.print("Salir (0)\nFacil (1): 4 letras\nIntermedio (2): 8 letras\nDificil (3): 12 letras\nElige el nivel: ");
        try{
            dificultad = sc.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("El juego no puede manejar ese nivel de dificultad, intentelo de nuevo");
        }
        juego(dificultad);
    }
    
}
