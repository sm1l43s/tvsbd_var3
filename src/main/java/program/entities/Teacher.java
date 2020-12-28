package program.entities;

import java.util.Date;

public class Teacher {

    private int id;
    private String surname;
    private String name;
    private String patronym;
    private String academicDegree;
    private String academicRank;
    private String position;
    private String gender;
    private Date birthday;
    private int numberOfCoursesTaught;

    public Teacher() {}

    public Teacher(String surname, String name, String patronym, String academicDegree,
                   String academicRank, String position, String gender, Date birthday,
                   int numberOfCoursesTaught) {
        this.surname = surname;
        this.name = name;
        this.patronym = patronym;
        this.academicDegree = academicDegree;
        this.academicRank = academicRank;
        this.position = position;
        this.gender = gender;
        this.birthday = birthday;
        this.numberOfCoursesTaught = numberOfCoursesTaught;
    }

    public Teacher(int id, String surname, String name, String patronym,
                   String academicDegree, String academicRank, String position,
                   String gender, Date birthday, int numberOfCoursesTaught) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronym = patronym;
        this.academicDegree = academicDegree;
        this.academicRank = academicRank;
        this.position = position;
        this.gender = gender;
        this.birthday = birthday;
        this.numberOfCoursesTaught = numberOfCoursesTaught;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronym() {
        return patronym;
    }

    public void setPatronym(String patronym) {
        this.patronym = patronym;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public String getAcademicRank() {
        return academicRank;
    }

    public void setAcademicRank(String academicRank) {
        this.academicRank = academicRank;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getNumberOfCoursesTaught() {
        return numberOfCoursesTaught;
    }

    public void setNumberOfCoursesTaught(int numberOfCoursesTaught) {
        this.numberOfCoursesTaught = numberOfCoursesTaught;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronym='" + patronym + '\'' +
                ", academicDegree='" + academicDegree + '\'' +
                ", academicRank='" + academicRank + '\'' +
                ", position='" + position + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", numberOfCoursesTaught=" + numberOfCoursesTaught +
                '}';
    }
}
