import java.util.ArrayList;
import java.util.List;

class Course {
    private String Code;
    private String Title;
    private String Description;
    private int Capacity;
    private String Schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.Code = courseCode;
        this.Title = title;
        this.Description = description;
        this.Capacity = capacity;
        this.Schedule = schedule;
    }

    public String getCourseCode() {
        return Code;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public int getCapacity() {
        return Capacity;
    }

    public String getSchedule() {
        return Schedule;
    }
}