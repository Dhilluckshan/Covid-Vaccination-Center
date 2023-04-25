
import java.util.*;
        import java.io.*;

public class Menu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int token_No = 0;
        String patientName;
        int booth_No = 0;
        int count = 0;
        String[] ServiceCenter = new String[7];
        int vaccine = 150;
        int vaccine_x = 0;
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
        String choose;

        do {

            choose = input.nextLine();
            if (choose.equals("100") || choose.equals("VVB")  || choose.equals("vvb") ) {
                initialise(ServiceCenter);
                for (int x = 1; x < 7; x++) {
                    if (ServiceCenter[x] != null) {
                        System.out.println("booth No -" + x  );
                    } else {
                        System.out.println("booth " + x + " is empty");
                    }
                }
            }
            if (choose.equals("102") || choose.equals("APB")|| choose.equals("apb")) {
                String patient_Name;
                while (booth_No < 6) {

                    System.out.println("(select the booth between 1 to 6 )");
                    System.out.println("please enter the  booth number :");
                    booth_No = input.nextInt();
                    if (booth_No == 6) {
                        break;
                    }
                    System.out.println("Enter patient name for booth " + booth_No + " :");

                    patient_Name = input.next();
                    if (booth_No < 7) {
                        vaccine = vaccine - 1;
                        if (vaccine == 20) {
                            System.out.println("Vaccine stock reached 20!");
                        }
                    }

                    add(booth_No, patient_Name, ServiceCenter);

                }

            }
            if (choose.equals("103") || (choose.equals("RPB")) || (choose.equals("rpb"))) {
                while (token_No < 7) {
                    System.out.println("(select the booth between 1 to 6 )");
                    System.out.println("please enter the  booth number :");

                    token_No = input.nextInt();
                    remove(token_No, ServiceCenter);

                }
            }


            if (choose.equals("101") || choose.equals("VEB")  || choose.equals("veb")) {
                viewemp(ServiceCenter);
            }

            if (choose.equals("104") || choose.equals("VPS") || choose.equals("vps")) {
                sort(ServiceCenter);
            }

            if (choose.equals("107") || choose.equals("VRV")|| choose.equals("vrv")) {
                viewvaccine(vaccine);
            }

            if (choose.equals("108") || choose.equals("AVS")|| choose.equals("avs")) {
                System.out.print("Added vaccines:");
                vaccine_x = input.nextInt();
                addvaccine(vaccine_x, vaccine);
            }

            if (choose.equals("105") || choose.equals("SPD")|| choose.equals("spd")) {
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
                storefile();

            }

            if (choose.equals("106") || choose.equals("LPD")|| choose.equals("lpd")) {
                loadfile();
            }

        } while (!(choose.equals("999") || choose.equals("EXT"))|| choose.equals("ext"));

    }

    private static void initialise(String patient_ref[]) {
        for (int x = 1; x < 7; x++)

            patient_ref[x] = "e";
        // System.out.println("initilise ");
    }

    private static void add(int boothNum, String patient_Name, String ServiceCenter[]) {
        ServiceCenter[boothNum] = patient_Name;
        for (int x = 1; x < 7; x++) {
            if (ServiceCenter[x] != null) {
                System.out.println("booth " + x + " warded by " + ServiceCenter[x]);
            } else {
                System.out.println("booth " + x + " is empty");
            }

        }
    }

    private static void remove(int tokenNum, String ServiceCenter[]) {
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

    private static void viewemp(String ServiceCenter[]) {
        for (int x = 0; x < 6; ++x) {
            if (ServiceCenter[x] != null) {

            } else {
                System.out.println("booth " + x + " is empty");
            }
        }
    }

    private static void sort(String ServiceCenter[]) {
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

    private static void viewvaccine(int vaccine) {
        System.out.println(vaccine + " vaccines remaining");
    }

    private static void addvaccine(int vaccine_x, int vaccine) {
        System.out.println("Total vaccines count is " + (vaccine + vaccine_x));
    }

    private static void storefile() {
        try {
            FileWriter myWriter = new FileWriter("D:\\java_x.txt");

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void loadfile() {
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
