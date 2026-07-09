

import java.util.Scanner;

class Employee {

    int empId;
    String empName;
    double[] monthlySalary = new double[3];

    
    Employee(int empId, String empName, double[] monthlySalary) {
        this.empId = empId;
        this.empName = empName;
        this.monthlySalary = monthlySalary;
    }

    
    double getTotalSalary() {
        double total = 0;
        for (double sal : monthlySalary) {
            total += sal;
        }
        return total;
    }

  
    double getAverageSalary() {
        return getTotalSalary() / monthlySalary.length;
    }

   
    int countVowels() {
        int count = 0;
        String name = empName.toLowerCase();

        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    String reverseName() {
        String rev = "";
        for (int i = empName.length() - 1; i >= 0; i--) {
            rev += empName.charAt(i);
        }
        return rev;
    }

   
    void display() {
        System.out.println("Employee ID : " + empId);
        System.out.println("Employee Name : " + empName);

        System.out.println("\nTotal Salary : " + getTotalSalary());
        System.out.println("Average Salary : " + getAverageSalary());

        System.out.println("\nNumber of Vowels : " + countVowels());
        System.out.println("\nReversed Name : " + reverseName());
    }
}

public class solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Employee ID : ");
        int id = sc.nextInt();

        sc.nextLine(); 

        System.out.print("Employee Name : ");
        String name = sc.nextLine();

        double[] salary = new double[3];

        System.out.println("\nMonthly Salaries:");
        for (int i = 0; i < 3; i++) {
            salary[i] = sc.nextDouble();
        }

        Employee emp = new Employee(id, name, salary);
        emp.display();

        sc.close();
    }
}