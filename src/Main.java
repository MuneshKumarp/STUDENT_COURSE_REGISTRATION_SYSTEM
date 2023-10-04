import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourseDatabase courseDB = new CourseDatabase();
        StudentDatabase studentDB = new StudentDatabase();
        Scanner scanner = new Scanner(System.in);

        // Add courses to the course database
        System.out.println("Add Courses to the Database:");
        while (true) {
            System.out.print("Enter Course Code (or 'exit' to finish): ");
            String courseCode = scanner.nextLine();
            if (courseCode.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.print("Enter Course Title: ");
            String courseTitle = scanner.nextLine();
            System.out.print("Enter Course Description: ");
            String courseDescription = scanner.nextLine();
            System.out.print("Enter Course Capacity: ");
            int courseCapacity = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter Course Schedule: ");
            String courseSchedule = scanner.nextLine();

            Course course = new Course(courseCode, courseTitle, courseDescription, courseCapacity, courseSchedule);
            courseDB.addCourse(course);
        }

        // Add students to the student database
        System.out.println("\nAdd Students to the Database:");
        for (int i = 1; i <= 2; i++) {
            System.out.print("Enter Student Name: ");
            String studentName = scanner.nextLine();
            Student student = new Student(i, studentName);
            studentDB.addStudent(student);
        }

        // Student registration
        System.out.println("\nStudent Registration:");
        Student student1 = studentDB.getAllStudents().get(0); // Get the first student
        while (true) {
            System.out.println("Select a course to register (enter course code) or 'done' to finish:");
            List<Course> availableCourses = courseDB.getAllCourses();
            for (Course course : availableCourses) {
                System.out.println(course.getCourseCode() + " - " + course.getTitle());
            }
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            Course selectedCourse = availableCourses.stream()
                    .filter(course -> course.getCourseCode().equalsIgnoreCase(input))
                    .findFirst()
                    .orElse(null);

            if (selectedCourse != null) {
                student1.registerCourse(selectedCourse);
                System.out.println("Registered for: " + selectedCourse.getTitle());
            } else {
                System.out.println("Course not found.");
            }
        }

        // List available courses
        List<Course> availableCourses = courseDB.getAllCourses();
        System.out.println("\nAvailable Courses:");
        for (Course course : availableCourses) {
            System.out.println(course.getCourseCode() + " - " + course.getTitle() + " (Capacity: " + course.getCapacity() + ")");
        }

        // List registered courses for a student
        List<Course> mukeshCourses = student1.getRegisteredCourses();
        System.out.println("\nCourses registered by Mukesh:");
        for (Course course : mukeshCourses) {
            System.out.println(course.getCourseCode() + " - " + course.getTitle());
        }

        // Drop a course
        System.out.println("\nDrop a Course:");
        System.out.println("Select a course to drop (enter course code):");
        String courseCodeToDrop = scanner.nextLine();
        Course courseToDrop = mukeshCourses.stream()
                .filter(course -> course.getCourseCode().equalsIgnoreCase(courseCodeToDrop))
                .findFirst()
                .orElse(null);
        if (courseToDrop != null) {
            student1.dropCourse(courseToDrop);
            System.out.println("Dropped: " + courseToDrop.getTitle());
        } else {
            System.out.println("Course not found.");
        }

        // Close the scanner
        scanner.close();
    }
}
