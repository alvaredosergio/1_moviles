package colorsgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.println("Bienvenido a 6x6 colorGame.\n");
        printMatrix();
        System.out.println("¿Qué fila o columna desea desplazar?");

        Scanner sc = new Scanner(System.in);
        String decision = sc.nextLine();

        // Switch to control the decision
        switch(decision) {
			case "c1": System.out.println("Seleccionaste la COLUMNA 1."); break;
			case "c2": System.out.println("Seleccionaste la COLUMNA 2."); break;
			case "c3": System.out.println("Seleccionaste la COLUMNA 3."); break;
            case "c4": System.out.println("Seleccionaste la COLUMNA 4."); break;
            case "c5": System.out.println("Seleccionaste la COLUMNA 5."); break;
            case "c6": System.out.println("Seleccionaste la COLUMNA 6."); break;
            case "f1": System.out.println("Seleccionaste la FILA 1."); break;
            case "f2": System.out.println("Seleccionaste la FILA 2."); break;
            case "f3": System.out.println("Seleccionaste la FILA 3."); break;
            case "f4": System.out.println("Seleccionaste la FILA 4."); break;
            case "f5": System.out.println("Seleccionaste la FILA 5."); break;
            case "f6": System.out.println("Seleccionaste la FILA 6."); break;

			default: System.out.println("La COLUMNA o FILA introducida es INCORRECTA. Intentelo de nuevo.");
        }

    }

    public static void printMatrix(){
        //print colors
        String reset = "\u001B[0m";
        String red = "\u001B[31m▀ ";
        String blue = "\u001B[34m▀ ";
        String green = "\u001B[32m▀ ";
        String yellow = "\u001B[33m▀ ";

        //List of colors
        List <String> colors = new ArrayList <String>();
        colors.add(red);
        colors.add(blue);
        colors.add(green);
        colors.add(yellow);

        //Empty matrix for 6x6
        String matrix [][] = {  
            {"","","","","",""},
            {"","","","","",""},
            {"","","","","",""},
            {"","","","","",""},
            {"","","","","",""},
            {"","","","","",""}
        };

        //Empty matrix for 2x2
        String objetiveMatrix [][] = {
            {"",""},
            {"",""}
        };

        // Counters for colors to control that dont exceded of 9 for each colors
        int contRed = 0;
        int contBlue = 0;
        int contGreen = 0;
        int contYellow = 0;

        // Loop to print 6x6 matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Random random = new Random();
                String rand = colors.get(random.nextInt(colors.size()));
                matrix[i][j] = rand;
                if(rand == red){
                    contRed++;
                    if(contRed >8){
                        colors.remove(red);
                    }
                }else if(rand == blue){
                    contBlue++;
                    if(contBlue >8){
                        colors.remove(blue);
                    }
                }else if(rand == green){
                    contGreen++;
                    if(contGreen >8){
                        colors.remove(green);
                    }
                }else{
                    contYellow++;
                    if(contYellow >8){
                        colors.remove(yellow);
                    }
                }
                System.out.print(matrix[i][j]); 
            }
            System.out.println();
        }
        System.out.print(reset);
        System.out.println("-----------");

        // Add colors again to list 'colors' because we delete it
        colors.add(red);
        colors.add(blue);
        colors.add(green);
        colors.add(yellow);

        // Loop to print 2x2 matrix
        for (int i = 0; i < objetiveMatrix.length; i++) {
            for (int j = 0; j < objetiveMatrix[i].length; j++) {
                Random random = new Random();
                String rand = colors.get(random.nextInt(colors.size()));
                objetiveMatrix[i][j] = rand;
                if(rand == red){
                    colors.remove(red);
                }else if(rand == blue){
                    colors.remove(blue);
                }else if(rand == green){
                    colors.remove(green);
                }else{
                    colors.remove(yellow);
                }
                System.out.print(objetiveMatrix[i][j]);
            }
            System.out.println();
        }
        System.out.print(reset);
    }

    
}
