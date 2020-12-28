package program.DAO;

import program.connect.Connecter;
import program.entities.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    TeacherDAO teacherDAO = new TeacherDAOImpl();

    private final String GET_ALL = "SELECT * FROM `courses`;";
    private final String GET_BY_ID = "SELECT * FROM `courses` WHERE id = ?";

    private final String ADD = "INSERT INTO `courses` (`id`, `teacher_id`, `name`, `specialty`, `number_course`, `semester_number`," +
            " `number_of_students`, `number_of_lecture_hours`, `number_of_practical_hours`, `number_of_labalatory_hours`," +
            " `have_credit`, `have_exams`, `number_of_test`) " +
            "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private final String UPDATE = "UPDATE `courses` SET `teacher_id` = ?, `name` = ?, `specialty` = ?, `number_course` = ?," +
            " `semester_number` = ?, `number_of_students` = ?, `number_of_lecture_hours` = ?, `number_of_practical_hours` = ?," +
            " `number_of_labalatory_hours` = ?, `have_credit` = ?, `have_exams` = ?, `number_of_test` = ? WHERE `courses`.`id` = ?;";

    private final String DELETE = "DELETE FROM `courses` WHERE id = ?";

    public List<Course> list() {
        List<Course> list = new ArrayList<Course>();
        Connection connection = null;
        Statement statement = null;
        ResultSet res = null;

        try {
            connection = new Connecter().getConnection();
            statement = connection.createStatement();
            connection.setAutoCommit(false);
            res = statement.executeQuery(GET_ALL);

            while (res.next()) {
                list.add(fromResultSetToCourse(res));
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                res.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public Course getById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        Course course = new Course();
        try {
            connection = new Connecter().getConnection();
            statement = connection.prepareStatement(GET_BY_ID);
            connection.setAutoCommit(false);
            statement.setInt(1, id);
            res = statement.executeQuery();
            while (res.next()) {
                course = fromResultSetToCourse(res);
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                res.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return course;
    }

    public void add(Course course) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = new Connecter().getConnection();
            statement = connection.prepareStatement(ADD);

            connection.setAutoCommit(false);

            statement.setInt(1, course.getTeacher().getId());
            statement.setString(2, course.getName());
            statement.setString(3, course.getSpecialty());
            statement.setInt(4, course.getNumberCourse());
            statement.setInt(5, course.getSemesterNumber());
            statement.setInt(6, course.getNumberOfStudents());
            statement.setInt(7, course.getNumberOfLectureHours());
            statement.setInt(8, course.getNumberOfPracticalHours());
            statement.setInt(9, course.getNumberOfLabalatoryHours());
            statement.setBoolean(10, course.isHaveCredit());
            statement.setBoolean(11, course.isHaveExams());
            statement.setInt(12, course.getNumberOftest());

            statement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void edit(Course course) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = new Connecter().getConnection();
            statement = connection.prepareStatement(UPDATE);
            connection.setAutoCommit(false);

            statement.setInt(1, course.getTeacher().getId());
            statement.setString(2, course.getName());
            statement.setString(3, course.getSpecialty());
            statement.setInt(4, course.getNumberCourse());
            statement.setInt(5, course.getSemesterNumber());
            statement.setInt(6, course.getNumberOfStudents());
            statement.setInt(7, course.getNumberOfLectureHours());
            statement.setInt(8, course.getNumberOfPracticalHours());
            statement.setInt(9, course.getNumberOfLabalatoryHours());
            statement.setBoolean(10, course.isHaveCredit());
            statement.setBoolean(11, course.isHaveExams());
            statement.setInt(12, course.getNumberOftest());
            statement.setInt(13, course.getId());

            statement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(Course course) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = new Connecter().getConnection();
            statement = connection.prepareStatement(DELETE);
            connection.setAutoCommit(false);

            statement.setInt(1, course.getId());
            statement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Course fromResultSetToCourse(ResultSet res) {
        Course course = new Course();
        try {
            course.setId(res.getInt("id"));
            course.setTeacher(teacherDAO.getById(res.getInt("teacher_id")));
            course.setName(res.getString("name"));
            course.setSpecialty(res.getString("specialty"));
            course.setNumberCourse(res.getInt("number_course"));
            course.setSemesterNumber(res.getInt("semester_number"));
            course.setNumberOfStudents(res.getInt("number_of_students"));
            course.setNumberOfLectureHours(res.getInt("number_of_lecture_hours"));
            course.setNumberOfPracticalHours(res.getInt("number_of_practical_hours"));
            course.setNumberOfLabalatoryHours(res.getInt("number_of_labalatory_hours"));
            course.setHaveCredit(res.getBoolean("have_credit"));
            course.setHaveExams(res.getBoolean("have_exams"));
            course.setNumberOftest(res.getInt("number_of_test"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

}
