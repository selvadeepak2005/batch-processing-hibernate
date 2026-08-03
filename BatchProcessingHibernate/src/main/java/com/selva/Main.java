package com.selva;

import com.selva.Dao.EmployeeDao;
import com.selva.Util.HibernateUtil;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDao employeeDao = new EmployeeDao();

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("      Batch Processing System");
            System.out.println("====================================");
            System.out.println("1. Batch Insert Employees");
            System.out.println("2. Batch Update Employees");
            System.out.println("3. Batch Delete Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice : ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("\nEnter Number of Employees : ");
                    int totalRecords = sc.nextInt();
                    sc.nextLine();

                    employeeDao.batchInsertEmployees(sc, totalRecords);

                    break;

                case 2:

                    System.out.print("\nEnter Department : ");
                    String updateDepartment = sc.nextLine();

                    System.out.print("Enter New Salary : ");
                    Double newSalary = sc.nextDouble();
                    sc.nextLine();

                    employeeDao.batchUpdateEmployees(
                            updateDepartment,
                            newSalary);

                    break;

                case 3:

                    System.out.print("\nEnter Department : ");
                    String deleteDepartment = sc.nextLine();

                    employeeDao.batchDeleteEmployees(
                            deleteDepartment);

                    break;

                case 4:

                    System.out.println("\n====================================");
                    System.out.println("Thank You...");
                    System.out.println("Application Closed Successfully.");
                    System.out.println("====================================");

                    HibernateUtil.shutdown();

                    break;

                default:

                    System.out.println("\nInvalid Choice!");

            }

        } while (choice != 4);

        sc.close();
    }
}