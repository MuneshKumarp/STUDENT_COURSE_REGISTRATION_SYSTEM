import java.util.ArrayList;
import java.util.List;

class Student {
    private int ID;
    private String Name;
    private List<Course> RegisteredCourses;

    public Student(int studentID, String name) {
        this.ID = studentID;
        this.Name = name;
        this.RegisteredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public List<Course> getRegisteredCourses() {
        return RegisteredCourses;
    }

    public void registerCourse(Course course) {
        if (RegisteredCourses.size() < 3) { // Assuming a student can register for a maximum of 3 courses
            RegisteredCourses.add(course);
        } else {
            System.out.println("You have reached the maximum course limit.");
        }
    }

    public void dropCourse(Course course) {
        RegisteredCourses.remove(course);
    }
}

class CourseDatabase {
    private List<Course> courses;

    public CourseDatabase() {
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public List<Course> getAllCourses() {
        return courses;
    }
}

class StudentDatabase {
    private List<Student> students;

    public StudentDatabase() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return students;
    }
}
