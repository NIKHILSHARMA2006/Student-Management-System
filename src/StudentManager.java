import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private final String FILE_PATH = "data/students.txt";

    public StudentManager() {
        loadStudents();
    }

    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        students.add(student);
        saveStudents();
        System.out.println("Student added successfully!");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n========== STUDENT RECORDS ==========");

        for (Student s : students) {
            displayStudent(s);
        }
    }

    public void searchStudent(int id) {
        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("\nStudent found!");
            displayStudent(student);
        }
    }

    public void updateStudent(int id, String name, int age, double marks) {
        Student oldStudent = findStudent(id);

        if (oldStudent == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(oldStudent);
        students.add(new Student(id, name, age, marks));

        saveStudents();
        System.out.println("Student updated successfully!");
    }

    public void deleteStudent(int id) {
        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(student);
        saveStudents();
        System.out.println("Student deleted successfully!");
    }

    private Student findStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    private void displayStudent(Student s) {
        System.out.println("-------------------------------------");
        System.out.println("ID    : " + s.getId());
        System.out.println("Name  : " + s.getName());
        System.out.println("Age   : " + s.getAge());
        System.out.println("Marks : " + s.getMarks());
        System.out.println("Grade : " + s.getGrade());
    }

    private void saveStudents() {
        try {
            Path path = Paths.get(FILE_PATH);
            Files.createDirectories(path.getParent());

            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                for (Student s : students) {
                    writer.write(
                        s.getId() + "," +
                        s.getName().replace(",", " ") + "," +
                        s.getAge() + "," +
                        s.getMarks()
                    );
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving student records.");
        }
    }

    private void loadStudents() {
        Path path = Paths.get(FILE_PATH);

        if (!Files.exists(path)) {
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 4) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    double marks = Double.parseDouble(data[3]);

                    students.add(new Student(id, name, age, marks));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading student records.");
        }
    }
}