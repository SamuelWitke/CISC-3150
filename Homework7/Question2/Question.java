import java.io.*;
import java.io.Serializable;
 /*
  * Code was modified from 
  * http://javabeginnerstutorial.com/core-java-tutorial/transient-vs-static-variable-java/
  *
*/

class Question { 
    public static void main(String ...args){
        Employee emp = new Employee();
        emp.firstName = "Vivekanand";
        emp.lastName = "Gautam";
        emp.companyName = "JBT";
        emp.address = "MUM";
        emp.companyCEO = "ME CEO";
        try {
            FileOutputStream fileOut = new FileOutputStream("./employee.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(emp);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in ./employee.txt file");
        } catch (IOException i) {
            i.printStackTrace();
        }
        emp = null;
        try {
            FileInputStream fileIn = new FileInputStream("./employee.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            emp = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserializing Employee...");
        System.out.println("First Name of Employee: " + emp.firstName);
        System.out.println("Last Name of Employee: " + emp.lastName);
        System.out.println("Company Name: "+emp.companyName);
        System.out.println("Company CEO: "+emp.companyCEO);
        System.out.println("Company Address: "+emp.address);
    }
}
class Employee extends superEmployee {
  public String firstName;
}

class superEmployee implements Serializable {
  public String lastName;
  static String companyCode=""; 
  static String companyName = "TATA";
  transient String address = "DEL";
  static transient String companyCEO = "Jayshree";
}
