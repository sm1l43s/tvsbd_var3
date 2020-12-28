package program.entities;

public class Course {

    private int id;
    private Teacher teacher;
    private String name;
    private String specialty;
    private int numberCourse;
    private int semesterNumber;
    private int numberOfStudents;
    private int numberOfLectureHours;
    private int numberOfPracticalHours;
    private int numberOfLabalatoryHours;
    private boolean haveCredit;
    private boolean haveExams;
    private int numberOftest;

    private final int HOURS_BEFORE_EXAM = 2;

    public Course() {}

    public Course(Teacher teacher, String name, String specialty, int numberCourse,
                  int semesterNumber, int numberOfStudents, int numberOfLectureHours,
                  int numberOfPracticalHours, int numberOfLabalatoryHours,
                  boolean haveCredit, boolean haveExams, int numberOftest) {
        this.teacher = teacher;
        this.name = name;
        this.specialty = specialty;
        this.numberCourse = numberCourse;
        this.semesterNumber = semesterNumber;
        this.numberOfStudents = numberOfStudents;
        this.numberOfLectureHours = numberOfLectureHours;
        this.numberOfPracticalHours = numberOfPracticalHours;
        this.numberOfLabalatoryHours = numberOfLabalatoryHours;
        this.haveCredit = haveCredit;
        this.haveExams = haveExams;
        this.numberOftest = numberOftest;
    }

    public Course(int id, Teacher teacher, String name, String specialty, int numberCourse,
                  int semesterNumber, int numberOfStudents, int numberOfLectureHours,
                  int numberOfPracticalHours, int numberOfLabalatoryHours,
                  boolean haveCredit, boolean haveExams, int numberOftest) {
        this.id = id;
        this.teacher = teacher;
        this.name = name;
        this.specialty = specialty;
        this.numberCourse = numberCourse;
        this.semesterNumber = semesterNumber;
        this.numberOfStudents = numberOfStudents;
        this.numberOfLectureHours = numberOfLectureHours;
        this.numberOfPracticalHours = numberOfPracticalHours;
        this.numberOfLabalatoryHours = numberOfLabalatoryHours;
        this.haveCredit = haveCredit;
        this.haveExams = haveExams;
        this.numberOftest = numberOftest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getNumberCourse() {
        return numberCourse;
    }

    public void setNumberCourse(int numberCourse) {
        this.numberCourse = numberCourse;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getNumberOfLectureHours() {
        return numberOfLectureHours;
    }

    public void setNumberOfLectureHours(int numberOfLectureHours) {
        this.numberOfLectureHours = numberOfLectureHours;
    }

    public int getNumberOfPracticalHours() {
        return numberOfPracticalHours;
    }

    public void setNumberOfPracticalHours(int numberOfPracticalHours) {
        this.numberOfPracticalHours = numberOfPracticalHours;
    }

    public int getNumberOfLabalatoryHours() {
        return numberOfLabalatoryHours;
    }

    public void setNumberOfLabalatoryHours(int numberOfLabalatoryHours) {
        this.numberOfLabalatoryHours = numberOfLabalatoryHours;
    }

    public boolean isHaveCredit() {
        return haveCredit;
    }

    public void setHaveCredit(boolean haveCredit) {
        this.haveCredit = haveCredit;
    }

    public boolean isHaveExams() {
        return haveExams;
    }

    public void setHaveExams(boolean haveExams) {
        this.haveExams = haveExams;
    }

    public int getNumberOftest() {
        return numberOftest;
    }

    public void setNumberOftest(int numberOftest) {
        this.numberOftest = numberOftest;
    }

    public int getHOURS_BEFORE_EXAM() {
        return HOURS_BEFORE_EXAM;
    }

    public double getHoursLectureConsultation() {
        return 0.05 * this.numberOfLectureHours;
    }

    public double getHoursExams() {
        if (this.haveExams) {
            return 0.5 * this.numberOfStudents;
        }
        return 0.0;
    }

    public double getHoursCredit() {
        if (this.haveCredit) {
            return 0.25 * this.numberOfStudents;
        }
        return 0.0;
    }

    public double getHoursForCheckTest() {
        return 0.15 * this.numberOfStudents * this.numberOftest;
    }

    public int getTotalHoursAtCourse() {
        return (int) Math.ceil(this.numberOfLectureHours + this.numberOfPracticalHours + this.numberOfLabalatoryHours +
                getHOURS_BEFORE_EXAM() + getHoursLectureConsultation() + getHoursExams() + getHoursCredit() +
                getHoursForCheckTest());
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", teacher=" + teacher +
                ", name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", numberCourse=" + numberCourse +
                ", semesterNumber=" + semesterNumber +
                ", numberOfStudents=" + numberOfStudents +
                ", numberOfLectureHours=" + numberOfLectureHours +
                ", numberOfPracticalHours=" + numberOfPracticalHours +
                ", numberOfLabalatoryHours=" + numberOfLabalatoryHours +
                ", haveCredit=" + haveCredit +
                ", haveExams=" + haveExams +
                ", numberOftest=" + numberOftest +
                ", HOURS_BEFORE_EXAM=" + HOURS_BEFORE_EXAM +
                '}';
    }
}
