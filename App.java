import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Introduce un número: ");
    int numero = sc.nextInt();
    System.out.print("Simple o en color(s/c) ");
    String simpleocolor = sc.next();
    sc.close();
    if (simpleocolor.equals("s")) {
      if (numero < 0) {
        System.out.println("Por favor,introduzca un número positivo");
      }
      int invertido = 0;
      int maxDigito = 0;
      while (numero > 0) {
        // multiplicamos el invertido por 10 y le sumamos el resto de la división por 10
        invertido = invertido * 10 + numero % 10;
        numero = numero / 10;
        if (numero % 10 > maxDigito) {
          //  actualizamos el maxdigito y actualizamos el número dividiéndolo por 10
          maxDigito = numero % 10;
        }
        while (invertido > 0) {
          System.out.println(" ---");
          System.out.println("| " + invertido % 10 + " |");
          System.out.println(" ---");
          // actualizamos el invertido dividiéndolo por 10
          invertido = invertido / 10;
        }
      }
    } else if (simpleocolor.equals("c")) {}
  }
}
