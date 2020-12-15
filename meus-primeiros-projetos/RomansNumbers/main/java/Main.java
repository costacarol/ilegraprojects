import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Numbers numbers = new Numbers();

        Scanner scan = new Scanner(System.in);


        System.out.println("Insira um número inteiro de 1 a 20 para a conversão:");
        int number = scan.nextInt();
        if (numbers.convertIntToRoman(number) != null){
            System.out.println("Resultado: " + numbers.convertIntToRoman(number));
        }
        else System.out.println("Número inválido. Tente novamente.");

        Scanner scan2 = new Scanner(System.in);
        System.out.println("Insira um número em romano de I a XX para a conversão: ");
        String roman = scan2.nextLine();
        if(numbers.convertRomanToInt(roman) != null){
            System.out.println("Resultado: " + numbers.convertRomanToInt(roman));
        }
        else System.out.println("Número inválido. Tente novamente.");
    }
}
