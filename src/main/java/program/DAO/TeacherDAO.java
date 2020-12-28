package program.DAO;

import program.entities.Teacher;

import java.util.List;

public interface TeacherDAO {

    List<Teacher> list();
    Teacher getById(int id);
    void add(Teacher teacher);
    void edit(Teacher teacher);
    void delete(Teacher teacher);

}
