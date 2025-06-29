import java.util.HashMap;
import java.util.Scanner;

// Student class to hold student details
class Student {
    private int id;
    private String name;
    private String branch;
    private int year;

    public Student(int id, String name, String branch, int year) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayDetails() {
        System.out.println("Student ID: " + id);
        System.out.println("Name     : " + name);
        System.out.println("Branch   : " + branch);
        System.out.println("Year     : " + year);
    }
}

public class Main {
    private static HashMap<Integer, Student> studentMap = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Remove Student");
            System.out.println("4. View Student Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        updateStudent();
                        break;
                    case 3:
                        removeStudent();
                        break;
                    case 4:
                        viewStudent();
                        break;
                    case 5:
                        System.out.println("Thank you for using the Student Management System!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please select between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                choice = 0;
            }

        } while (choice != 5);
    }

    private static void addStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = Integer.parseInt(sc.nextLine());

            if (studentMap.containsKey(id)) {
                System.out.println("Student with this ID already exists.");
                return;
            }

            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Branch: ");
            String branch = sc.nextLine();
            System.out.print("Enter Year: ");
            int year = Integer.parseInt(sc.nextLine());

            Student newStudent = new Student(id, name, branch, year);
            studentMap.put(id, newStudent);
            System.out.println("Student added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values where required.");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = Integer.parseInt(sc.nextLine());

        if (studentMap.containsKey(id)) {
            Student student = studentMap.get(id);
            System.out.print("Enter new Name: ");
            student.setName(sc.nextLine());
            System.out.print("Enter new Branch: ");
            student.setBranch(sc.nextLine());
            System.out.print("Enter new Year: ");
            student.setYear(Integer.parseInt(sc.nextLine()));
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found!");
        }
    }

    private static void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        int id = Integer.parseInt(sc.nextLine());

        if (studentMap.containsKey(id)) {
            studentMap.remove(id);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found!");
        }
    }

    private static void viewStudent() {
        System.out.print("Enter Student ID to view: ");
        int id = Integer.parseInt(sc.nextLine());

        if (studentMap.containsKey(id)) {
            studentMap.get(id).displayDetails();
        } else {
            System.out.println("Student not found!");
        }
    }
}
