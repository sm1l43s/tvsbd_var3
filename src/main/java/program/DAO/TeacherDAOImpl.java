package program.DAO;

import program.connect.Connecter;
import program.entities.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImpl implements TeacherDAO {

    private final String GET_ALL = "SELECT * FROM `teachers`;";
    private final String GET_BY_ID = "SELECT * FROM `teachers` WHERE id = ?";
    private final String ADD = "INSERT INTO `teachers` (`id`, `surname`, `name`, `patronym`, `academic_degree`, `academic_rank`, `position`, `gender`, `birthday`, `number_of_courses_taught`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private final String UPDATE = "UPDATE `teachers` SET `surname` = ?, `name` = ?, `patronym` = ?, `academic_degree` = ?, `academic_rank` = ?, `position` = ?, `gender` = ?, `birthday` = ?, `number_of_courses_taught` = ? WHERE `teachers`.`id` = ?;";
    private final String DELETE = "DELETE FROM `teachers` WHERE id = ?";
    private final String UPDATE_INFO_COURSES = "{call update_info_courses(?)}";

    public List<Teacher> list() {
        List<Teacher> list = new ArrayList<Teacher>();
        Connection connection = null;
        Statement statement = null;
        ResultSet res = null;

        try {
            connection = new Connecter().getConnection();
            statement = connection.createStatement();
            connection.setAutoCommit(false);
            res = statement.executeQuery(GET_ALL);

            while (res.next()) {
                list.add(fromResultSetToTeacher(res));
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

    public Teacher getById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        Teacher teacher = new Teacher();
        try {
            connection = new Connecter().getConnection();
            statement = connection.prepareStatement(GET_BY_ID);
            connection.setAutoCommit(false);
            statement.setInt(1, id);
            res = statement.executeQuery();
            while (res.next()) {
                teacher = fromResultSetToTeacher(res);
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
        return teacher;
    }

    public void add(Teacher teacher) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = new Connecter().getConnection();
            statement = connection.prepareStatement(ADD);

            connection.setAutoCommit(false);

            statement.setString(1, teacher.getSurname());
            statement.setString(2, teacher.getName());
            statement.setString(3, teacher.getPatronym());
            statement.setString(4, teacher.getAcademicDegree());
            statement.setString(5, teacher.getAcademicRank());
            statement.setString(6, teacher.getPosition());
            statement.setString(7, teacher.getGender());
            statement.setDate(8, (Date) teacher.getBirthday());
            statement.setInt(9, teacher.getNumberOfCoursesTaught());

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

    public void edit(Teacher teacher) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = new Connecter().getConnection();
            statement = connection.prepareStatement(UPDATE);
            connection.setAutoCommit(false);

            statement.setString(1, teacher.getSurname());
            statement.setString(2, teacher.getName());
            statement.setString(3, teacher.getPatronym());
            statement.setString(4, teacher.getAcademicDegree());
            statement.setString(5, teacher.getAcademicRank());
            statement.setString(6, teacher.getPosition());
            statement.setString(7, teacher.getGender());
            statement.setDate(8, (Date) teacher.getBirthday());
            statement.setInt(9, teacher.getNumberOfCoursesTaught());
            statement.setInt(10, teacher.getId());


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

    public void delete(Teacher teacher) {
        Connection connection = null;
        PreparedStatement statement = null;
        CallableStatement callableStatement = null;
        try {
            connection = new Connecter().getConnection();
            callableStatement = connection.prepareCall(UPDATE_INFO_COURSES);
            statement = connection.prepareStatement(DELETE);
            connection.setAutoCommit(false);

            //storage procedure
            callableStatement.setInt(1, teacher.getId());
            callableStatement.execute();

            statement.setInt(1, teacher.getId());
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

    public Teacher fromResultSetToTeacher(ResultSet res) {
        Teacher teacher = new Teacher();
        try {
            teacher.setId(res.getInt("id"));
            teacher.setSurname(res.getString("surname"));
            teacher.setName(res.getString("name"));
            teacher.setPatronym(res.getString("patronym"));
            teacher.setAcademicDegree(res.getString("academic_degree"));
            teacher.setAcademicRank(res.getString("academic_rank"));
            teacher.setPosition(res.getString("position"));
            teacher.setGender(res.getString("gender"));
            teacher.setBirthday(res.getDate("birthday"));
            teacher.setNumberOfCoursesTaught(res.getInt("number_of_courses_taught"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }
}
