package program.gui;

import program.DAO.CourseDAO;
import program.DAO.CourseDAOImpl;
import program.DAO.TeacherDAO;
import program.DAO.TeacherDAOImpl;
import program.entities.Course;
import program.entities.Teacher;
import program.entities.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainForm {

    private final int WIDTH = 1024;
    private final int HEIGHT = 768;

    private static User user;

    TeacherDAO teacherDAO = new TeacherDAOImpl();
    CourseDAO courseDAO = new CourseDAOImpl();

    JTable table = null;
    boolean flag = true;

    public MainForm() {
        final JFrame frame = new JFrame("Данные факультета о преподавателях и читаемых ими курсах");
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

//      Top panel
        JPanel  panelTop = new JPanel();
        panelTop.setLayout(new GridBagLayout());
        panelTop.setPreferredSize(new Dimension(WIDTH, 150));
        panelTop.setBackground(new Color(255, 255, 255));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JButton btnCourses = new JButton("Данные преподавателей");
        btnCourses.setPreferredSize(new Dimension(200, 40));
        btnCourses.setForeground(Color.black);
        btnCourses.setBackground(new Color(192, 192, 246));
        btnCourses.setFocusable(false);
        btnCourses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flag = true;
                createTable(table, flag);
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 0;
        panelTop.add(btnCourses, constraints);

        JLabel emptyLabel1 = new JLabel(" ");
        constraints.gridx = 1;
        constraints.gridy = 0;
        panelTop.add(emptyLabel1, constraints);

        JButton btnTeachers = new JButton("Данные курсов");
        btnTeachers.setPreferredSize(new Dimension(200, 40));
        btnTeachers.setForeground(Color.black);
        btnTeachers.setBackground(new Color(192, 192, 246));
        btnTeachers.setFocusable(false);
        btnTeachers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flag = false;
                createTable(table, flag);
            }
        });
        constraints.gridx = 2;
        constraints.gridy = 0;
        panelTop.add(btnTeachers, constraints);

        JLabel emptyLabel2 = new JLabel(" ");
        constraints.gridx = 1;
        constraints.gridy = 1;
        panelTop.add(emptyLabel2, constraints);

        if (user.getRole().equals("ADMIN")) {
            final JButton addTeachers = new JButton("Добавить преподавателя");
            addTeachers.setFocusable(false);
            addTeachers.setPreferredSize(new Dimension(200, 40));
            addTeachers.setForeground(Color.white);
            addTeachers.setBackground(new Color(26, 77, 13, 255));
            addTeachers.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new AddTeachers();
                    frame.dispose();
                }
            });
            constraints.gridx = 0;
            constraints.gridy = 2;
            panelTop.add(addTeachers, constraints);

            JLabel emptyLabel3 = new JLabel(" ");
            constraints.gridx = 3;
            constraints.gridy = 2;
            panelTop.add(emptyLabel3, constraints);

            JButton addCourses = new JButton("Добавить курс");
            addCourses.setFocusable(false);
            addCourses.setPreferredSize(new Dimension(200, 40));
            addCourses.setForeground(Color.white);
            addCourses.setBackground(new Color(26, 77, 13, 255));
            addCourses.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new AddCourses();
                    frame.dispose();
                }
            });
            constraints.gridx = 2;
            constraints.gridy = 2;
            panelTop.add(addCourses, constraints);

            JLabel emptyLabel4 = new JLabel(" ");
            constraints.gridx = 1;
            constraints.gridy = 3;
            panelTop.add(emptyLabel4, constraints);

            JButton addUser = new JButton("Добавить пользователя");
            addUser.setFocusable(false);
            addUser.setPreferredSize(new Dimension(200, 40));
            addUser.setForeground(Color.white);
            addUser.setBackground(new Color(26, 77, 13, 255));
            addUser.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new AddUser();
                    frame.dispose();
                }
            });
            constraints.gridx = 5;
            constraints.gridy = 2;
            panelTop.add(addUser, constraints);

            JLabel emptyLabel5 = new JLabel(" ");
            constraints.gridx = 6;
            constraints.gridy = 0;
            panelTop.add(emptyLabel5, constraints);

            JButton deleteBtn = new JButton("Удалить выделенное");
            deleteBtn.setPreferredSize(new Dimension(200, 40));
            deleteBtn.setFocusable(false);
            deleteBtn.setForeground(Color.white);
            deleteBtn.setBackground(new Color(123, 12, 11));
            deleteBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    deleteRow(table, flag);
                }
            });
            constraints.gridx = 7;
            constraints.gridy = 3;
            panelTop.add(deleteBtn, constraints);
        }

        JLabel userLabel = new JLabel("Вы вошли как: " + user.getLogin());
        constraints.gridy = 0;
        constraints.gridx = 7;
        panelTop.add(userLabel, constraints);

//      Bottom panel
        JPanel panelBottom = new JPanel();
        panelBottom.setPreferredSize(new Dimension(WIDTH, 618));
        panelBottom.setBackground(Color.white);

        table = new JTable();
        table.setPreferredSize(new Dimension(WIDTH - 24, 618));
        table = createTable(table, flag);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(WIDTH - 24, 570));
        panelBottom.add(scrollPane);

        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelBottom, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private JTable createTable(JTable table, boolean flag) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);

        if (flag) {
            model = addDataTeachers(model);
        } else  {
            model = addDataCourses(model);
        }

        return table;
    }

    private JTable deleteRow(JTable table, boolean flag) {

        if (table.getSelectedRow() != -1) {
            if (flag) {
                teacherDAO.delete(teacherDAO.getById((Integer) table.getValueAt(table.getSelectedRow(), 1)));
            } else {
                courseDAO.delete(courseDAO.getById((Integer) table.getValueAt(table.getSelectedRow(), 1)));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ни одной строки таблицы не выделено!");
        }


        return createTable(table, flag);
    }

    private DefaultTableModel addDataTeachers(DefaultTableModel model) {
        List<Teacher> list = teacherDAO.list();

        model.addColumn("№");
        model.addColumn("ID");
        model.addColumn("Фамилия");
        model.addColumn("Имя");
        model.addColumn("Отчество");
        model.addColumn("Ученая степень");
        model.addColumn("Ученое звание");
        model.addColumn("Должность");
        model.addColumn("Пол");
        model.addColumn("Дата рождения");
        model.addColumn("Кол-во читаемых курсов");

        int i = 0;
        for (Teacher teacher: list) {
            if (teacher.getId() != 1) {
                model.addRow(new Object[]{++i, teacher.getId(), teacher.getSurname(), teacher.getName(), teacher.getPatronym(),
                        teacher.getAcademicDegree(), teacher.getAcademicRank(), teacher.getPosition(), teacher.getGender(),
                        teacher.getBirthday(), teacher.getNumberOfCoursesTaught()});
            }
        }

        return model;
    }

    private DefaultTableModel addDataCourses(DefaultTableModel model) {
        List<Course> list = courseDAO.list();

        model.addColumn("№");
        model.addColumn("ID");
        model.addColumn("Ф.И.О преподавателя");
        model.addColumn("Название");
        model.addColumn("Специальность");
        model.addColumn("№ курса");
        model.addColumn("№ семестра");
        model.addColumn("Кол-во студентов");
        model.addColumn("Кол-во лекционных часов");
        model.addColumn("Кол-во практических занятий");
        model.addColumn("Кол-во лабораторных часов");
        model.addColumn("Зачет");
        model.addColumn("Экзамен");
        model.addColumn("Кол-во контролльных работ");
        model.addColumn("Общее кол-во часов");

        int i = 0;
        for (Course course: list) {
            model.addRow(new Object[]{++i, course.getId(), course.getTeacher().getSurname() + " " + course.getTeacher().getName()
                    + " " + course.getTeacher().getPatronym(),course.getName(), course.getSpecialty(), course.getNumberCourse(),
                    course.getSemesterNumber(), course.getNumberOfStudents(), course.getNumberOfLectureHours(),
                    course.getNumberOfPracticalHours(), course.getNumberOfLabalatoryHours(), course.isHaveCredit(),
                    course.isHaveExams(), course.getNumberOftest(), course.getTotalHoursAtCourse()});
        }
        return model;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        MainForm.user = user;
    }
}
