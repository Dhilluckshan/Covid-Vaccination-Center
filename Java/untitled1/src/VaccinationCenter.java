import java.util.*;
import java.io.*;

public class VaccinationCenter {

    public static void main(String[] args) {
        Booth[] arr;
        int boothNum = 0;
        int vaccine = 150;
        int tokenNum = 0;
        int vaccine_x = 0;
        String[] ServiceCenter = new String[7];
        arr = new Booth[9];
        for (int i = 0; i < 9; ++i) {
            arr[i] = new Booth();
        }

        System.out.println("----------COVID-19 VACCINATION CENTER Program--------------");
        System.out.println("---------------COVID-19 VACCINATION CENTER-----------------");
        System.out.println("-----------------------------------------------------------");

        System.out.println("100 or VVB:View all Vaccination Booths");
        System.out.println("101 or VEB:View all Empty Booths");
        System.out.println("102 or APB:Add Patient to a Booth");
        System.out.println("103 or RPB:Remove Patient from a Booth");
        System.out.println("104 or VPS:View Patients Sorted in alphabetical order");
        System.out.println("105 or SPD:Store Program Data into file");
        System.out.println("106 or LPD:Load Program Data from file");
        System.out.println("107 or VRV:View Remaining Vaccinations");
        System.out.println("108 or AVS:Add Vaccinations to the Stock");
        System.out.println("999 or EXT:Exit the Program");
        System.out.println("choose your service:");

        Scanner input = new Scanner(System.in);
        String option;
        do {
            option = input.nextLine();
            if (option.equals("100") || option.equals("VVB")) {
                arr[0].setData(ServiceCenter);

            }

            if (option.equals("102") || option.equals("APB")) {
                String customerName;
                while (boothNum < 6) {

                    System.out.println("Enter the booth number :");
                    boothNum = input.nextInt();
                    if (boothNum == 6) {
                        break;
                    }
                    System.out.println("Enter patient name for booth " + boothNum + " :");

                    customerName = input.next();
                    if (boothNum < 6) {
                        vaccine = vaccine - 1;
                        if (vaccine == 20) {
                            System.out.println("Vaccine stock reached 20!");
                        }
                    }

                    arr[1].add(boothNum, customerName, ServiceCenter);
                }
            }

            if (option.equals("103") || option.equals("RPB")) {
                while (tokenNum < 6) {
                    System.out.println("Enter booth number :");
                    tokenNum = input.nextInt();
                    arr[2].remove(tokenNum, ServiceCenter);
                }
            }

            if (option.equals("101") || option.equals("VEB")) {
                arr[3].viewemp(ServiceCenter);
            }

            if (option.equals("104") || option.equals("VPS")) {
                arr[4].sort(ServiceCenter);
            }

            if (option.equals("107") || option.equals("VRV")) {
                arr[5].viewvaccine(vaccine);
            }

            if (option.equals("108") || option.equals("AVS")) {
                System.out.print("Added vaccines:");
                vaccine_x = input.nextInt();
                arr[6].addvaccine(vaccine_x, vaccine);
            }

            if (option.equals("105") || option.equals("SPD")) {
                try {
                    File myObj = new File("D:\\java_x.java");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();
                    if (myObj.createNewFile()) {
                        System.out.println("File created: " + myObj.getName());

                    } else {
                        System.out.println("File already exists.");
                    }

                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                arr[7].storefile();
            }
            if (option.equals("106") || option.equals("LPD")) {
                arr[8].loadfile();
            }

        } while (!(option.equals("999") || option.equals("EXT")));

    }
}