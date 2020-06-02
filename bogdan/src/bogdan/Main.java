package bogdan;

import java.io.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {


        Manager manager1 = new Manager(1, "Kiril", "Tomson", 5600, 25);
        Manager manager2 = new Manager(2, "Bil", "Grit", 5300, 15, manager1);
        Employee employee1 = new Employee(1, "Aliona", "Tenytska", 600, manager2);
        Employee employee2 = new Employee(2, "Dasha", "Filatova", 3520, manager2);

        Employee employee3 = new Employee(3, "Max", "Alekseyev", 2847, manager1);
        Manager manager3 = new Manager(3, "Tom", "Jonson", 8547, 8);
        Manager manager4 = new Manager(4, "Roma", "Romson", 5624, 5, manager3);
        Manager manager5 = new Manager(5, "Tim", "Bild", 8547, 6, manager4);
        Employee employee4 = new Employee(4, "Liza", "Wild", 1425, manager5);
        System.out.println(employee4.toString());
        System.out.println(manager5.toString());
        System.out.println("Top manager of employee:" + employee4.getId() + " - " + employee4.getTopManager().toString());


        System.out.println("Данные с файла:");
        Manager manager6 = null;
        Employee employee5 = null;
        Employee employee6 = null;

        try {
            File file1 = new File("D:\\Java\\VIZZI\\BOGDAn\\bogdan\\InputManager.txt");
            //создаем объект FileReader для объекта File
            FileReader fr1 = new FileReader(file1);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader1 = new BufferedReader(fr1);
            // считаем сначала первую строку
            manager6 = new Manager(parseInt(reader1.readLine()), reader1.readLine(), reader1.readLine(), parseDouble(reader1.readLine()), parseDouble(reader1.readLine()));

            File file2 = new File("D:\\Java\\VIZZI\\BOGDAn\\bogdan\\InputEmployeers.txt");
            //создаем объект FileReader для объекта File
            FileReader fr2 = new FileReader(file2);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader2 = new BufferedReader(fr2);
            // считаем сначала первую строку
            employee5 = new Employee(parseInt(reader2.readLine()), reader2.readLine(), reader2.readLine(), parseDouble(reader2.readLine()),manager6);
            employee6 = new Employee(parseInt(reader2.readLine()), reader2.readLine(), reader2.readLine(), parseDouble(reader2.readLine()),manager6);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(manager6.toString());
        System.out.println(employee5.toString());
        System.out.println(employee6.toString());

        File file3 = new File("D:\\Java\\VIZZI\\BOGDAn\\bogdan\\OutputManager.txt");
        File file4 = new File("D:\\Java\\VIZZI\\BOGDAn\\bogdan\\OutputEmployeers.txt");

        try {

            FileOutputStream outfile3 = new FileOutputStream(file3);
            ObjectOutputStream out_of_file3 = new ObjectOutputStream(outfile3);
            out_of_file3.writeObject(manager6);

            FileOutputStream outfile4 = new FileOutputStream(file4);
            ObjectOutputStream out_of_file4 = new ObjectOutputStream(outfile4);
            out_of_file4.writeObject(employee5);
            out_of_file4.writeObject(employee6);

            FileInputStream infile3  = new FileInputStream(file3);
            ObjectInputStream in_of_file4  = new ObjectInputStream(infile3);
            Manager newMen6 = (Manager) in_of_file4.readObject();

            FileInputStream infile4= new FileInputStream(file4);
            ObjectInputStream in_of_file3 =  new ObjectInputStream(infile4);

            Employee nemEmp5 = (Employee) in_of_file3.readObject();
            Employee nemEmp6= (Employee) in_of_file3.readObject();

            System.out.println("Новые данные с файла:");
            System.out.println(nemEmp5.toString());
            System.out.println(nemEmp6.toString());
            System.out.println(newMen6.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

