package program.DAO;

import program.entities.Course;

import java.util.List;

public interface CourseDAO {

    List<Course> list();
    Course getById(int id);
    void add(Course course);
    void edit(Course course);
    void delete(Course course);

}
