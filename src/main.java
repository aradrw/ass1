import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args) {

        school school = new school();


        try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                String surname = parts[1];
                int age = Integer.parseInt(parts[2]);
                boolean gender = parts[3].equalsIgnoreCase("Male");

                student student = new student(name, surname, age, gender);

                for (int i = 4; i < parts.length; i++) {
                    student.addGrade(Integer.parseInt(parts[i]));
                }

                school.addMember(student);
            }
        } catch (IOException e) {
            System.out.println("Error reading students file: " + e.getMessage());
        }


        try (BufferedReader br = new BufferedReader(new FileReader("teachers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                String surname = parts[1];
                int age = Integer.parseInt(parts[2]);
                boolean gender = parts[3].equalsIgnoreCase("Male");
                String subject = parts[4];
                int yearsOfExperience = Integer.parseInt(parts[5]);
                int salary = Integer.parseInt(parts[6]);

                teacher teacher = new teacher(name, surname, age, gender, subject, yearsOfExperience, salary);

                if (yearsOfExperience > 10) {
                    teacher.giveRaise(10.0); // Give a 10% raise
                }

                school.addMember(teacher);
            }
        } catch (IOException e) {
            System.out.println("Error reading teachers file: " + e.getMessage());
        }


        System.out.println(school);


        System.out.println("\nGPA of Students:");
        for (person member : school.getMembers()) {
            if (member instanceof student) {
                student student = (student) member;
                System.out.println(student.getName() + " " + student.getSurname() + ": " + student.calculateGPA());
            }
        }


        System.out.println("\nTeachers' Salaries After Raises:");
        for (person member : school.getMembers()) {
            if (member instanceof teacher) {
                teacher teacher = (teacher) member;
                System.out.println(teacher.getName() + " " + teacher.getSurname() + ": " + teacher.getSalary());
            }
        }
    }
}
