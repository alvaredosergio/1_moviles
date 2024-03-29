package colorsgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static int moves;

    // Colored squares codes
    public static String reset = "\u001B[0m";
    public static String red = "\u001B[31m▀ ";
    public static String blue = "\u001B[34m▀ ";
    public static String green = "\u001B[32m▀ ";
    public static String yellow = "\u001B[33m▀ ";
    public static String cyan = "\u001B[36m▀ ";

    //Only color
    public static String red_ = "\u001B[31m";
    public static String blue_ = "\u001B[34m";
    public static String green_ = "\u001B[32m";
    public static String yellow_ = "\u001B[33m";
    public static String cyan_ = "\u001B[36m";

    public static void main(String[] args) {
        System.out.println("\r"
        + "  ____       ____              __                  _____                \r\n"
        + " / __/__ __ / __/  ____ ___   / /___   ____ ___   / ___/___ _ __ _  ___ \r\n"
        + "/ _ \\ \\ \\ // _ \\  / __// _ \\ / // _ \\ / __/(_-<  / (_ // _ `//  ' \\/ -_)\r\n"
        + "\\___//_\\_\\ \\___/  \\__/ \\___//_/ \\___//_/  /___/  \\___/ \\_,_//_/_/_/\\__/ \r\n"
        + "                                                                        "
        + "");
        System.out.println("You must to complete the 6x6 square like the 2x2 pattern.");
        System.out.println("Choose what COLUMN or ROW you wanna move: ('c1' = Column 1, 'r1' = Row 1, etc...)");
        System.out.println("GOOD LUCK!!\n");

        

        // List of colors
        List <String> colors = new ArrayList <String>();
        colors.add(red);
        colors.add(blue);
        colors.add(green);
        colors.add(yellow);

        // Empty matrix for 6x6 square
        String matrix [][] = {  
            {"","","","","",""},
            {"","","","","",""},
            {"","","","","",""},
            {"","","","","",""},
            {"","","","","",""},
            {"","","","","",""}
        };
        
        // Empty matrix for 2c2 square
        String objetiveMatrix [][] = {
            {"",""},
            {"",""}
        };

        // Counters for each color
        int contRed = 0;
        int contBlue = 0;
        int contGreen = 0;
        int contYellow = 0;
    
        // First loop to put a random color on 6x6 square from list 'colors' on the matrix
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
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

        // Add again colors to the list 'colors', because we remove it
        colors.add(red);
        colors.add(blue);
        colors.add(green);
        colors.add(yellow);

        // First loop to put a random color on the 2x2 square from list 'colors'
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

        // Matrix created to transform the 2x2 objetiveMatrix into a 6x6 to check it
        String tl = objetiveMatrix[0][0];
        String tr = objetiveMatrix[0][1];
        String bl = objetiveMatrix[1][0];
        String br = objetiveMatrix[1][1];
        String compMatrix [][] = {  
            {tl,tl,tl,tr,tr,tr},
            {tl,tl,tl,tr,tr,tr},
            {tl,tl,tl,tr,tr,tr},
            {bl,bl,bl,br,br,br},
            {bl,bl,bl,br,br,br},
            {bl,bl,bl,br,br,br}
        };

        // Scanner to introduce the decision
        Scanner sc = new Scanner(System.in);

        // Infinite loop to execute the program
        while (matrix != compMatrix){

            // Loop to check if our 6x6 is the correct like the patron.
            if(Arrays.deepEquals(matrix, compMatrix) == true){
                break;
            }

            System.out.println("Choose COLUMN or ROW:");
            
            String option = sc.nextLine();

            // Switch for all columns or rows decision
            switch(option) {
                case "c1": 
                String c00 = matrix[0][0];
                String c10 = matrix[1][0];
                String c20 = matrix[2][0];
                String c30 = matrix[3][0];
                String c40 = matrix[4][0];
                String c50 = matrix[5][0];
                matrix[0][0] = c50;
                matrix[1][0] = c00;
                matrix[2][0] = c10;
                matrix[3][0] = c20;
                matrix[4][0] = c30;
                matrix[5][0] = c40;
                moves++;
                break;
                case "c2": 
                String c01 = matrix[0][1];
                String c11 = matrix[1][1];
                String c21 = matrix[2][1];
                String c31 = matrix[3][1];
                String c41 = matrix[4][1];
                String c51 = matrix[5][1];
                matrix[0][1] = c51;
                matrix[1][1] = c01;
                matrix[2][1] = c11;
                matrix[3][1] = c21;
                matrix[4][1] = c31;
                matrix[5][1] = c41;
                moves++;
                break;
                case "c3": 
                String c02 = matrix[0][2];
                String c12 = matrix[1][2];
                String c22 = matrix[2][2];
                String c32 = matrix[3][2];
                String c42 = matrix[4][2];
                String c52 = matrix[5][2];
                matrix[0][2] = c52;
                matrix[1][2] = c02;
                matrix[2][2] = c12;
                matrix[3][2] = c22;
                matrix[4][2] = c32;
                matrix[5][2] = c42;
                moves++;
                break;
                case "c4": 
                String c03 = matrix[0][3];
                String c13 = matrix[1][3];
                String c23 = matrix[2][3];
                String c33 = matrix[3][3];
                String c43 = matrix[4][3];
                String c53 = matrix[5][3];
                matrix[0][3] = c53;
                matrix[1][3] = c03;
                matrix[2][3] = c13;
                matrix[3][3] = c23;
                matrix[4][3] = c33;
                matrix[5][3] = c43;
                moves++;
                break;
                case "c5": 
                String c04 = matrix[0][4];
                String c14 = matrix[1][4];
                String c24 = matrix[2][4];
                String c34 = matrix[3][4];
                String c44 = matrix[4][4];
                String c54 = matrix[5][4];
                matrix[0][4] = c54;
                matrix[1][4] = c04;
                matrix[2][4] = c14;
                matrix[3][4] = c24;
                matrix[4][4] = c34;
                matrix[5][4] = c44;
                moves++;
                break;
                case "c6": 
                String c05 = matrix[0][5];
                String c15 = matrix[1][5];
                String c25 = matrix[2][5];
                String c35 = matrix[3][5];
                String c45 = matrix[4][5];
                String c55 = matrix[5][5];
                matrix[0][5] = c55;
                matrix[1][5] = c05;
                matrix[2][5] = c15;
                matrix[3][5] = c25;
                matrix[4][5] = c35;
                matrix[5][5] = c45;
                moves++;
                break;
                case "r1": 
                String r00 = matrix[0][0];
                String r01 = matrix[0][1];
                String r02 = matrix[0][2];
                String r03 = matrix[0][3];
                String r04 = matrix[0][4];
                String r05 = matrix[0][5];
                matrix[0][0] = r05;
                matrix[0][1] = r00;
                matrix[0][2] = r01;
                matrix[0][3] = r02;
                matrix[0][4] = r03;
                matrix[0][5] = r04;
                moves++;
                break;
                case "r2": 
                String r10 = matrix[1][0];
                String r11 = matrix[1][1];
                String r12 = matrix[1][2];
                String r13 = matrix[1][3];
                String r14 = matrix[1][4];
                String r15 = matrix[1][5];
                matrix[1][0] = r15;
                matrix[1][1] = r10;
                matrix[1][2] = r11;
                matrix[1][3] = r12;
                matrix[1][4] = r13;
                matrix[1][5] = r14;
                moves++;
                break;
                case "r3": 
                String r20 = matrix[2][0];
                String r21 = matrix[2][1];
                String r22 = matrix[2][2];
                String r23 = matrix[2][3];
                String r24 = matrix[2][4];
                String r25 = matrix[2][5];
                matrix[2][0] = r25;
                matrix[2][1] = r20;
                matrix[2][2] = r21;
                matrix[2][3] = r22;
                matrix[2][4] = r23;
                matrix[2][5] = r24;
                moves++;
                break;
                case "r4": 
                String r30 = matrix[3][0];
                String r31 = matrix[3][1];
                String r32 = matrix[3][2];
                String r33 = matrix[3][3];
                String r34 = matrix[3][4];
                String r35 = matrix[3][5];
                matrix[3][0] = r35;
                matrix[3][1] = r30;
                matrix[3][2] = r31;
                matrix[3][3] = r32;
                matrix[3][4] = r33;
                matrix[3][5] = r34;
                moves++;
                break;
                case "r5": 
                String r40 = matrix[4][0];
                String r41 = matrix[4][1];
                String r42 = matrix[4][2];
                String r43 = matrix[4][3];
                String r44 = matrix[4][4];
                String r45 = matrix[4][5];
                matrix[4][0] = r45;
                matrix[4][1] = r40;
                matrix[4][2] = r41;
                matrix[4][3] = r42;
                matrix[4][4] = r43;
                matrix[4][5] = r44;
                moves++;
                break;
                case "r6": 
                String r50 = matrix[5][0];
                String r51 = matrix[5][1];
                String r52 = matrix[5][2];
                String r53 = matrix[5][3];
                String r54 = matrix[5][4];
                String r55 = matrix[5][5];
                matrix[5][0] = r55;
                matrix[5][1] = r50;
                matrix[5][2] = r51;
                matrix[5][3] = r52;
                matrix[5][4] = r53;
                matrix[5][5] = r54;
                moves++;
                break;

                default: System.out.println("The COLUMN or ROW choosed are INCORRECT. Try it again.\n");
            }

            // Second loop to print the 6x6 matrix when moved by user
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    System.out.print(matrix[i][j]);
                }
            System.out.println();
            }
            System.out.print(reset);
            System.out.println("-----------");

            // Second loop to print 2x2 
            for(int i = 0; i < objetiveMatrix.length; i++){
                for(int j = 0; j < objetiveMatrix[i].length; j++){
                    System.out.print(objetiveMatrix[i][j]);
                }
            System.out.println();
            }
            System.out.print(reset);
        }

        sc.close();
        // Print the Congratulations
        System.out.println();
        System.out.println("CONGRATULATIONS !!");
        System.out.println("Moves used: " + cyan_ + moves + " move/s." + reset);
        System.out.println("You complete the "+red_+"6"+blue_+"x"+yellow_+"6 "+green_+"c"+red_+"o"+blue_
        +"l"+yellow_+"o"+green_+"r"+red_+"s"+blue_+" "+yellow_+"G"+green_+"a"+red_+"m"+blue_+"e"+yellow_+"."+reset);
        System.out.println("\r"
        + " ______ __                      __\r\n"
        + "/_  __// /  ___   ___  ___  ___/ /\r\n"
        + " / /  / _ \\/ -_) / -_)/ _ \\/ _  / \r\n"
        + "/_/  /_//_/\\__/  \\__//_//_/\\_,_/  \r\n"
        + "                                  \r"
        + "");
    }
}
