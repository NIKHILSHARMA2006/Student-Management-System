import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n=================================");
            System.out.println("    STUDENT MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID.");
                        sc.nextLine();
                        break;
                    }
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine().trim();

                    System.out.print("Enter Age: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid age.");
                        sc.nextLine();
                        break;
                    }
                    int age = sc.nextInt();

                    System.out.print("Enter Marks (0-100): ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid marks.");
                        sc.nextLine();
                        break;
                    }
                    double marks = sc.nextDouble();
                    sc.nextLine();

                    if (id <= 0 || name.isEmpty() || age <= 0 ||
                            marks < 0 || marks > 100) {
                        System.out.println("Invalid student details.");
                        break;
                    }

                    manager.addStudent(new Student(id, name, age, marks));
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID.");
                        sc.nextLine();
                        break;
                    }
                    manager.searchStudent(sc.nextInt());
                    sc.nextLine();
                    break;

                case 4:
                    System.out.print("Enter Student ID to update: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID.");
                        sc.nextLine();
                        break;
                    }
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine().trim();

                    System.out.print("Enter New Age: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid age.");
                        sc.nextLine();
                        break;
                    }
                    int newAge = sc.nextInt();

                    System.out.print("Enter New Marks (0-100): ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid marks.");
                        sc.nextLine();
                        break;
                    }
                    double newMarks = sc.nextDouble();
                    sc.nextLine();

                    if (newName.isEmpty() || newAge <= 0 ||
                            newMarks < 0 || newMarks > 100) {
                        System.out.println("Invalid student details.");
                        break;
                    }

                    manager.updateStudent(
                        updateId, newName, newAge, newMarks
                    );
                    break;

                case 5:
                    System.out.print("Enter Student ID to delete: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID.");
                        sc.nextLine();
                        break;
                    }
                    manager.deleteStudent(sc.nextInt());
                    sc.nextLine();
                    break;

                case 6:
                    System.out.println("Thank you for using the system!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
