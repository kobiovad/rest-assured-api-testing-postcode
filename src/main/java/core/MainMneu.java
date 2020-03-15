package core;

import java.util.Scanner;

public class MainMneu {
    public static void main(String[] args){

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Post Code (Example:CB3 0FA)");
        String cityCode = myObj.nextLine();

        Utilite utilite = new Utilite();
        utilite.printPostCity(cityCode); //"CB3 0FA"


    }
}
