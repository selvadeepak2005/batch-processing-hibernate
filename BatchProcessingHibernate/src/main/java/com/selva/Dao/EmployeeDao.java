package com.selva.Dao;

import com.selva.Entity.Employee;
import com.selva.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class EmployeeDao {

    // Batch Insert
    public void batchInsertEmployees(Scanner sc, int totalRecords) {

        Transaction transaction = null;

        try (Session session = HibernateUtil
                .getSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();

            for (int i = 1; i <= totalRecords; i++) {

                System.out.println("\n========== Employee " + i + " ==========");

                System.out.print("Enter Employee Name : ");
                String name = sc.nextLine();

                System.out.print("Enter Department : ");
                String department = sc.nextLine();

                System.out.print("Enter Salary : ");
                Double salary = sc.nextDouble();
                sc.nextLine();

//                Employee employee = Employee.builder()
//                        .employeeName("Employee " + i)
//                        .department("IT")
//                        .salary(30000.0 + i)
//                        .build();
//                it is used for to add 10000 record only for testing purpose



                Employee employee = Employee.builder()
                        .employeeName(name)
                        .department(department)
                        .salary(salary)
                        .build();

//             it is manual entry


                session.persist(employee);
//                if (i == 5) {
//                    throw new RuntimeException("Testing Rollback");
//                }
                // it is used for rollback verification only for testing purpose

                if (i % 50 == 0) {

                    session.flush();
                    session.clear();
                    System.out.println("Flushing and Clearing Session at Record : " + i);

                    System.out.println(i + " Employees Inserted...");
                }
            }

            transaction.commit();

            System.out.println("\nBatch Insert Completed Successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // Batch Update
    public void batchUpdateEmployees(String department,
                                     Double newSalary) {

        Transaction transaction = null;

        try (Session session = HibernateUtil
                .getSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();

            List<Employee> employees = session.createQuery(
                            "FROM Employee WHERE department = :department",
                            Employee.class)
                    .setParameter("department", department)
                    .list();

            if (employees.isEmpty()) {

                System.out.println("\nNo Employees Found!");

                return;
            }

            int count = 0;

            for (Employee employee : employees) {

                employee.setSalary(newSalary);

                session.merge(employee);

                count++;

                if (count % 50 == 0) {

                    session.flush();
                    session.clear();

                    System.out.println(count + " Employees Updated...");
                }
            }

            transaction.commit();

            System.out.println("\nBatch Update Completed Successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // Batch Delete
    public void batchDeleteEmployees(String department) {

        Transaction transaction = null;

        try (Session session = HibernateUtil
                .getSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();

            List<Employee> employees = session.createQuery(
                            "FROM Employee WHERE department = :department",
                            Employee.class)
                    .setParameter("department", department)
                    .list();

            if (employees.isEmpty()) {

                System.out.println("\nNo Employees Found!");

                return;
            }

            int count = 0;

            for (Employee employee : employees) {

                session.remove(employee);

                count++;

                if (count % 50 == 0) {

                    session.flush();
                    session.clear();

                    System.out.println(count + " Employees Deleted...");
                }
            }

            transaction.commit();

            System.out.println("\nBatch Delete Completed Successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

}