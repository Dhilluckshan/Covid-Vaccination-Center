import java.util.*;
import java.io.*;

public class Booth {

    public static void main(String[] args) {

    }

    public void setData(String ServiceCenter[]) {
        for (int x = 0; x < 6; x++) {
            if (ServiceCenter[x] != null) {
                System.out.println("booth " + x + " warded by " + ServiceCenter[x]);
            } else {
                System.out.println("booth " + x + " is empty");
            }
        }

    }

    public void add(int booth_No, String patient_name, String ServiceCenter[]) {
        ServiceCenter[booth_No] = patient_name;
        for (int x = 0; x < 6; x++) {
            if (ServiceCenter[x] != null) {
                System.out.println("booth " + x + "warded by " + ServiceCenter[x]);
            } else {
                System.out.println("booth " + x + " is empty");
            }

        }
    }

    public static void remove(int token_No, String ServiceCenter[]) {
        for (int x = 0; x < 6; ++x) {
            if (x == token_No) {
                System.out.println("Patient in booth  " + x + " removed ");
                ServiceCenter[x] = null;
            } else {

                if (ServiceCenter[x] != null) {
                    System.out.println("booth " + x + " warded by " + ServiceCenter[x]);
                } else {
                    System.out.println("booth " + x + " is empty");
                }

            }
        }
    }

    public static void viewemp(String ServiceCenter[]) {
        for (int x = 0; x < 6; ++x) {
            if (ServiceCenter[x] != null) {

            } else {
                System.out.println("booth " + x + " is empty");
            }
        }
    }

    public static void sort(String ServiceCenter[]) {
        ArrayList<String> name = new ArrayList<>();
        for (int x = 0; x < 6; ++x) {

            if (ServiceCenter[x] != null) {
                name.add(ServiceCenter[x]);

            }
        }
        int j;
        boolean flag = true;
        String temp;
        String temp_1;

        while (flag) {
            flag = false;
            for (j = 0; j < name.size() - 1; j++) {
                if (name.get(j).compareToIgnoreCase(name.get(j + 1)) > 0) {
                    temp = name.get(j);
                    temp_1 = name.get(j + 1);
                    name.set(j, temp_1);
                    name.set(j + 1, temp);
                    flag = true;
                }
            }
        }
        System.out.println(name);
    }

    public static void viewvaccine(int vaccine) {
        System.out.println(vaccine + " vaccines remaining");
    }

    public static void addvaccine(int vaccine_x, int vaccine) {
        System.out.println("Total vaccine count " + (vaccine + vaccine_x));
    }

    public static void storefile() {
        try {
            FileWriter myWriter = new FileWriter("D:\\java_x.txt");

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void loadfile() {
        File myObj = new File("D:\\java_x.txt");
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
        } else {
            System.out.println("The file does not exist.");
        }
    }
}

