import java.security.cert.X509Certificate;
import java.util.*;
import java.io.*;

public class ExtendedBooth {

    public void setData(String ServiceCenter[]) {
        for (int x = 1; x < 7; x++) {
            if (ServiceCenter[x] != null) {
                System.out.println("booth " + x + " warded by " + ServiceCenter[x]);
            } else {
                System.out.println("booth " + x + " is empty");
            }
        }

    }

    public void add(String firstName, String sname, int age, String city, String nic, String vac, String ServiceCenter[]) {
        if (vac.equals("vaccine_Astrazeneca")) {
            if (ServiceCenter[0] == null) {
                ServiceCenter[0] = firstName;
                System.out.println("Type your first name: " + firstName);
                System.out.println("Type your surname: " + sname);
                System.out.println("Enter your Age: " + age);
                System.out.println("Enter the city: " + city);
                System.out.println("Enter your NIC number: " + nic);
                System.out.println("Added to booth 1"  );
            } else if (ServiceCenter[1] == null) {
                ServiceCenter[1] = firstName;
                System.out.println("Type your first name: " + firstName);
                System.out.println("Type your surname: " + sname);
                System.out.println("Enter your Age: " + age);
                System.out.println("Enter the city: " + city);
                System.out.println("Enter your NIC number: " + nic);
                System.out.println("Added to booth 2"  );

            } else {
                System.out.println("Booth are currently not available for AstraZeneca vaccine");
            }
        } else if (vac.equals("vaccine_sinopharm")) {
            if (ServiceCenter[2] == null) {
                ServiceCenter[2] = firstName;
                System.out.println("Type your first name: " + firstName);
                System.out.println("Type your surname: " + sname);
                System.out.println("Enter your Age: " + age);
                System.out.println("Enter the city: " + city);
                System.out.println("Enter your NIC number: " + nic);
                System.out.println("Added to booth 3 "  );

            } else if (ServiceCenter[3] == null) {
                ServiceCenter[3] = firstName;
                System.out.println("Type your first name: " + firstName);
                System.out.println("Type your surname: " + sname);
                System.out.println("Enter your Age: " + age);
                System.out.println("Enter the city: " + city);
                System.out.println("Enter your NIC number: " + nic);
                System.out.println("Added to booth 4"  );
            } else {
                System.out.println("Booth not available for SinoPharm");
            }
        } else if (vac.equals("Pfizer")) {
            if (ServiceCenter[4] == null) {
                ServiceCenter[4] = firstName;
                System.out.println("Type your first name: " + firstName);
                System.out.println("Type your surname: " + sname);
                System.out.println("Enter your Age: " + age);
                System.out.println("Enter the city: " + city);
                System.out.println("Enter your NIC number: " + nic);
                System.out.println("Added to booth 5"  );

            } else if (ServiceCenter[5] == null) {
                ServiceCenter[5] = firstName;
                System.out.println("Type your first name: " + firstName);
                System.out.println("Type your surname: " + sname);
                System.out.println("Enter your Age: " + age);
                System.out.println("Enter the city: " + city);
                System.out.println("Enter your NIC number: " + nic);
                System.out.println("Added to booth 6"  );
            } else {
                System.out.println("Booth not available for Pfizer");
            }
        }

    }

    public static void remove(int tokenNum, String ServiceCenter[]) {
        for (int x = 0; x < 6; ++x) {
            if (x == tokenNum) {
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
            FileWriter myWriter = new FileWriter("C:\\Users\\java_x.txt");

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void loadfile() {
        File myObj = new File("C:\\Users\\java_x.txt");
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