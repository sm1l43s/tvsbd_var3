package program.gui;

import program.DAO.CourseDAO;
import program.DAO.CourseDAOImpl;
import program.DAO.TeacherDAO;
import program.DAO.TeacherDAOImpl;
import program.entities.Course;
import program.entities.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AddCourses {

    private final int WIDTH = 500;
    private final int HEIGHT = 800;

    TeacherDAO teacherDAO = new TeacherDAOImpl();

    List<JRadioButton> listCredit = new ArrayList<JRadioButton>();
    List<JRadioButton> listExam = new ArrayList<JRadioButton>();
    List<Teacher> listTeacher = teacherDAO.list();
    List<JRadioButton> listTeachersBtn = new ArrayList<JRadioButton>();

    public AddCourses() {
        final JFrame frame = new JFrame("Форма добавления курса");
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(new GridBagLayout());

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.VERTICAL;

        JLabel nameLabel = new JLabel("Название курса");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(nameLabel, constraints);

        final JTextField name = new JTextField();
        name.setPreferredSize(new Dimension(200, 40));
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(name, constraints);

        JLabel emptyLabel = new JLabel(" ");
        constraints.gridy = 2;
        panel.add(emptyLabel, constraints);

        JLabel specialtyLabel = new JLabel("Специальность курса");
        specialtyLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(specialtyLabel, constraints);

        final JTextField specialty = new JTextField();
        specialty.setPreferredSize(new Dimension(200, 40));
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(specialty, constraints);

        JLabel emptyLabel1 = new JLabel(" ");
        constraints.gridy = 5;
        panel.add(emptyLabel1, constraints);

        JLabel numberCourseLabel = new JLabel("Номер курса обучения");
        numberCourseLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(numberCourseLabel, constraints);

        final JTextField numberCourse = new JTextField();
        numberCourse.setPreferredSize(new Dimension(200, 40));
        constraints.gridx = 0;
        constraints.gridy = 7;
        panel.add(numberCourse, constraints);

        JLabel emptyLabel2 = new JLabel(" ");
        constraints.gridy = 8;
        panel.add(emptyLabel2, constraints);

        JLabel numberSemesterLabel = new JLabel("Номер семестра");
        numberSemesterLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridx = 0;
        constraints.gridy = 9;
        panel.add(numberSemesterLabel, constraints);

        final JTextField numberSemester = new JTextField();
        numberSemester.setPreferredSize(new Dimension(200, 40));
        constraints.gridx = 0;
        constraints.gridy = 10;
        panel.add(numberSemester, constraints);

        JLabel emptyLabel3 = new JLabel(" ");
        constraints.gridy = 11;
        panel.add(emptyLabel3, constraints);

        JLabel numberStudentsLabel = new JLabel("Количество студентов");
        numberStudentsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridx = 0;
        constraints.gridy = 12;
        panel.add(numberStudentsLabel, constraints);

        final JTextField numberStudents = new JTextField();
        numberStudents.setPreferredSize(new Dimension(200, 40));
        constraints.gridx = 0;
        constraints.gridy = 13;
        panel.add(numberStudents, constraints);

        JLabel emptyLabel4 = new JLabel(" ");
        constraints.gridy = 14;
        panel.add(emptyLabel4, constraints);

        final JLabel numberHoursLectureLabel = new JLabel("Количество лекционных часов:");
        numberHoursLectureLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridx = 0;
        constraints.gridy = 15;
        panel.add(numberHoursLectureLabel, constraints);

        final JTextField numberHoursLecture = new JTextField();
        numberHoursLecture.setPreferredSize(new Dimension(200, 40));
        constraints.gridx = 0;
        constraints.gridy = 16;
        panel.add(numberHoursLecture, constraints);

        JLabel emptyLabel5 = new JLabel(" ");
        constraints.gridy = 17;
        panel.add(emptyLabel5, constraints);

        JLabel numberHoursPracticalLabel = new JLabel("Количество часов практических занятий:");
        numberHoursPracticalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridx = 0;
        constraints.gridy = 18;
        panel.add(numberHoursPracticalLabel, constraints);

        final JTextField numberHoursPractical = new JTextField();
        numberHoursPractical.setPreferredSize(new Dimension(200, 40));
        constraints.gridx = 0;
        constraints.gridy = 19;
        panel.add(numberHoursPractical, constraints);

        JLabel emptyLabel6 = new JLabel(" ");
        constraints.gridy = 20;
        panel.add(emptyLabel6, constraints);

        JLabel numberHoursLabolatoryLabel = new JLabel("Количество часов лабораторных занятий:");
        numberHoursLabolatoryLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridx = 0;
        constraints.gridy = 21;
        panel.add(numberHoursLabolatoryLabel, constraints);

        final JTextField numberHoursLabolatory = new JTextField();
        numberHoursLabolatory.setPreferredSize(new Dimension(200, 40));
        constraints.gridx = 0;
        constraints.gridy = 22;
        panel.add(numberHoursLabolatory, constraints);

        JLabel emptyLabel7 = new JLabel(" ");
        constraints.gridy = 23;
        panel.add(emptyLabel7, constraints);

        JLabel testLabel = new JLabel("Количество контрольных работ:");
        testLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridx = 0;
        constraints.gridy = 24;
        panel.add(testLabel, constraints);

        final JTextField test = new JTextField();
        test.setPreferredSize(new Dimension(200, 40));
        constraints.gridx = 0;
        constraints.gridy = 25;
        panel.add(test, constraints);

        JLabel emptyLabel8 = new JLabel(" ");
        constraints.gridy = 26;
        panel.add(emptyLabel8, constraints);

        ButtonGroup groupIsCredit = new ButtonGroup();

        JLabel creditLabel = new JLabel("Есть ли зачет?");
        creditLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridx = 0;
        constraints.gridy = 27;
        panel.add(creditLabel, constraints);

        final JRadioButton yesCredit = new JRadioButton("Да");
        constraints.gridy = 28;
        groupIsCredit.add(yesCredit);
        listCredit.add(yesCredit);
        panel.add(yesCredit, constraints);

        final JRadioButton noCredit = new JRadioButton("Нет");
        constraints.gridy = 29;
        groupIsCredit.add(noCredit);
        listCredit.add(noCredit);
        panel.add(noCredit, constraints);

        JLabel emptyLabel9 = new JLabel(" ");
        constraints.gridy = 30;
        panel.add(emptyLabel9, constraints);

        ButtonGroup groupIsExam = new ButtonGroup();
        JLabel examLabel = new JLabel("Есть ли экзамен?");
        examLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridx = 0;
        constraints.gridy = 31;
        panel.add(examLabel, constraints);

        final JRadioButton yesExam = new JRadioButton("Да");
        constraints.gridy = 32;
        groupIsExam.add(yesExam);
        listExam.add(yesExam);
        panel.add(yesExam, constraints);

        final JRadioButton noExam = new JRadioButton("Нет");
        constraints.gridy = 33;
        groupIsExam.add(noExam);
        listExam.add(noExam);
        panel.add(noExam, constraints);

        JLabel emptyLabel10 = new JLabel(" ");
        constraints.gridy = 34;
        panel.add(emptyLabel10, constraints);

        JLabel teacherLabel = new JLabel("Преподаватель:");
        teacherLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridx = 0;
        constraints.gridy = 35;
        panel.add(teacherLabel, constraints);

        ButtonGroup groupTeachersBtn = new ButtonGroup();
        int i = 1;
        for (Teacher teacher: listTeacher) {
            if (teacher.getId() != 1) {
                JRadioButton button = new JRadioButton(teacher.getId() + " " + teacher.getSurname() + " " + teacher.getName() + " " + teacher.getPatronym());
                button.setPreferredSize(new Dimension(220, 40));
                groupTeachersBtn.add(button);
                listTeachersBtn.add(button);
                constraints.gridy = 36 + i++;
                panel.add(button, constraints);
            }
        }

        JButton add = new JButton("Добавить");
        add.setPreferredSize(new Dimension(200, 40));
        add.setForeground(Color.white);
        add.setBackground(new Color(26, 77, 13, 255));
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CourseDAO courseDAO = new CourseDAOImpl();
                if (!name.getText().isEmpty() && !specialty.getText().isEmpty() && !numberCourse.getText().isEmpty() &&
                    !numberSemester.getText().isEmpty() && !numberHoursLecture.getText().isEmpty() &&
                    !numberHoursLabolatory.getText().isEmpty() && !numberHoursPractical.getText().isEmpty() &&
                        (yesCredit.isSelected() || noCredit.isSelected() || yesExam.isSelected() || noExam.isSelected()) &&
                    !test.getText().isEmpty()) {

                    boolean exam = false;
                    if (getTextCheckedRadioButton(listExam).equals("Да")) {
                        exam = true;
                    }

                    boolean credit = false;
                    if (getTextCheckedRadioButton(listCredit).equals("Да")) {
                        credit = true;
                    }

                    int idTeacher = Integer.parseInt(getTextCheckedRadioButton(listTeachersBtn).substring(0, 1));

                    courseDAO.add(new Course(teacherDAO.getById(idTeacher), name.getText(), specialty.getText(),
                            Integer.parseInt(numberCourse.getText()), Integer.parseInt(numberSemester.getText()),
                            Integer.parseInt(numberStudents.getText()), Integer.parseInt(numberHoursLecture.getText()),
                            Integer.parseInt(numberHoursPractical.getText()), Integer.parseInt(numberHoursLabolatory.getText()),
                            credit, exam, Integer.parseInt(test.getText())));

                    JOptionPane.showMessageDialog(null, "Добавлено");
                    frame.dispose();
                    new MainForm();
                } else {
                    JOptionPane.showMessageDialog(null, "Не все поля введены!");
                }
            }
        });
        constraints.gridy = 36 + i + 2;
        panel.add(add, constraints);

        JButton cancel = new JButton("Отмена");
        cancel.setPreferredSize(new Dimension(200, 40));
        cancel.setForeground(Color.white);
        cancel.setBackground(new Color(123, 12, 11));
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainForm();
            }
        });
        constraints.gridy = 36 + i + 3;
        panel.add(cancel, constraints);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                new MainForm();
            }
        });

        frame.add(scrollPane);
        frame.setVisible(true);
    }

    private String getTextCheckedRadioButton(List<JRadioButton> list) {
        for (JRadioButton btn: list) {
            if (btn.isSelected()) {
                return btn.getText();
            }
        }
        return "none";
    }
}
