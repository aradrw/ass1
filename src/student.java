import java.util.ArrayList;
import java.util.List;

public class student extends person {
    private static int nextID = 1;
    private int studentID;
    private List<Integer> grades;

    public student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        this.studentID = nextID++;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        } else {
            System.out.println("err");
        }
    }

    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / (double) grades.size();
    }

    @Override
    public String toString() {
        return super.toString() + " i am a student with ID " + studentID + ".";
    }

    public List<Integer> getGrades() {
        return grades;
    }
}
