package com.main;
import java.util.*;
public class Application {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		boolean seat[] = new boolean[10];
       
        try {
        while (true) {
            System.out.println("please type 1 for First Class");
            System.out.println("please type 2 for economy");
            System.out.print("choice : ");
            int inputValue = input.nextInt();
            if (inputValue == 1) {
                if (!assignSeatsForPlane(seat, 0, 4)) {
                    if (takeConfirmationInputFromUser("firstClass")) {
                        if (!assignSeatsForPlane(seat, 5, 9)) {
                            System.out.println("Next flight leaves in 3 hours.");
                            break;
                        }
                    }
                }
            } else if (inputValue == 2) {
                if (!assignSeatsForPlane(seat, 5, 9)) {
                    if (takeConfirmationInputFromUser("economy")) {
                        if (!assignSeatsForPlane(seat, 0, 4)) {
                            System.out.println("Next flight leaves in 3 hours.");
                            break;
                        }
                    }
                }
            }
        }
        }catch(Exception ex){
        	System.out.println(ex);
        	
        }finally {
        	input.close();
        }
    }
    private static boolean assignSeatsForPlane(boolean seats[], int startIndex, int endIndex) {
        while (startIndex <= endIndex) {
            if (seats[startIndex] == false) {
                seats[startIndex] = true;
                return true;
            }
            startIndex++;
        }
        return false;
    }
    private static boolean takeConfirmationInputFromUser(String name) {
        if (name == "firstClass") {
            System.out.println("it’s acceptable to be placed in the economy-class section");
        } else {
            System.out.println("it’s acceptable to be placed in the first-class section");
        }
        System.out.println("please type 1 for Yes");
        System.out.println("please type 2 for No");
        int choice = input.nextInt();
        if (choice == 1) {
            return true;
        } else {
            return false;
        }
       
	}

}
