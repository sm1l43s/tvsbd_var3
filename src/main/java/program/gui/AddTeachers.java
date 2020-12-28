package program.gui;

import program.DAO.TeacherDAO;
import program.DAO.TeacherDAOImpl;
import program.DAO.UserDAO;
import program.DAO.UserDAOImpl;
import program.entities.Teacher;
import program.entities.User;

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

public class AddTeachers {

    private final int WIDTH = 500;
    private final int HEIGHT = 800;

    List<JRadioButton> list = new ArrayList<JRadioButton>();

    public AddTeachers() {
        final JFrame frame = new JFrame("Форма добавления преоподавателя");
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.VERTICAL;

        JLabel surnameLabel = new JLabel("Фамилия:");
        surnameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(surnameLabel, constraints);

        final JTextField surname = new JTextField();
        surname.setPreferredSize(new Dimension(200, 40));
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(surname, constraints);

        JLabel emptyLabel = new JLabel(" ");
        constraints.gridy = 2;
        panel.add(emptyLabel, constraints);

        JLabel nameLabel = new JLabel("Имя:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridy = 3;
        panel.add(nameLabel, constraints);

        final JTextField name = new JTextField();
        name.setPreferredSize(new Dimension(200, 40));
        constraints.gridy = 4;
        panel.add(name, constraints);

        JLabel emptyLabel2 = new JLabel(" ");
        constraints.gridy = 5;
        panel.add(emptyLabel2, constraints);

        JLabel patronymLabel = new JLabel("Отчество:");
        patronymLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridy = 6;
        panel.add(patronymLabel, constraints);

        final JTextField patronym = new JTextField();
        patronym.setPreferredSize(new Dimension(200, 40));
        constraints.gridy = 7;
        panel.add(patronym, constraints);

        JLabel emptyLabel3 = new JLabel(" ");
        constraints.gridy = 8;
        panel.add(emptyLabel3, constraints);

        JLabel academicDegreeLabel = new JLabel("Ученая степень:");
        academicDegreeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridy = 9;
        panel.add(academicDegreeLabel, constraints);

        final JTextField academicDegree = new JTextField();
        academicDegree.setPreferredSize(new Dimension(200, 40));
        constraints.gridy = 10;
        panel.add(academicDegree, constraints);

        JLabel emptyLabel4 = new JLabel(" ");
        constraints.gridy = 11;
        panel.add(emptyLabel4, constraints);

        JLabel academicRankLabel = new JLabel("Ученое звание:");
        academicRankLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridy = 12;
        panel.add(academicRankLabel, constraints);

        final JTextField academicRank = new JTextField();
        academicRank.setPreferredSize(new Dimension(200, 40));
        constraints.gridy = 13;
        panel.add(academicRank, constraints);

        JLabel emptyLabel5 = new JLabel(" ");
        constraints.gridy = 14;
        panel.add(emptyLabel5, constraints);

        JLabel positionLabel = new JLabel("Должность:");
        positionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridy = 15;
        panel.add(positionLabel, constraints);

        final JTextField position = new JTextField();
        position.setPreferredSize(new Dimension(200, 40));
        constraints.gridy = 16;
        panel.add(position, constraints);

        JLabel emptyLabel6 = new JLabel(" ");
        constraints.gridy = 17;
        panel.add(emptyLabel6, constraints);

        JLabel genderLabel = new JLabel("Пол:");
        genderLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridy = 18;
        panel.add(genderLabel, constraints);

        ButtonGroup group = new ButtonGroup();
        final JRadioButton male = new JRadioButton("Мужской");
        constraints.gridy = 19;
        group.add(male);
        list.add(male);
        panel.add(male, constraints);

        final JRadioButton female = new JRadioButton("Женский");
        constraints.gridy = 20;
        group.add(female);
        list.add(female);
        panel.add(female, constraints);

        JLabel emptyLabel7 = new JLabel(" ");
        constraints.gridy = 21;
        panel.add(emptyLabel7, constraints);

        JLabel birthDayLabel = new JLabel("Дата рождения (гггг-мм-дд):");
        birthDayLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridy = 22;
        panel.add(birthDayLabel, constraints);

        final JTextField birthday = new JTextField();
        birthday.setPreferredSize(new Dimension(200, 40));
        constraints.gridy = 23;
        panel.add(birthday, constraints);

        JLabel emptyLabel8 = new JLabel(" ");
        constraints.gridy = 24;
        panel.add(emptyLabel8, constraints);

        JLabel numberCoursesLabel = new JLabel("Количество преподаваемых курсов:");
        numberCoursesLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridy = 25;
        panel.add(numberCoursesLabel, constraints);

        final JTextField numberCourses = new JTextField();
        numberCourses.setPreferredSize(new Dimension(200, 40));
        constraints.gridy = 26;
        panel.add(numberCourses, constraints);

        JLabel emptyLabel9 = new JLabel(" ");
        constraints.gridy = 27;
        panel.add(emptyLabel9, constraints);

        JButton add = new JButton("Добавить");
        add.setPreferredSize(new Dimension(200, 40));
        add.setForeground(Color.white);
        add.setBackground(new Color(26, 77, 13, 255));
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TeacherDAO teacherDAO = new TeacherDAOImpl();
                UserDAO userDAO = new UserDAOImpl();

                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");

                if (!surname.getText().isEmpty() && !name.getText().isEmpty() && !patronym.getText().isEmpty() &&
                    !academicDegree.getText().isEmpty() && !academicRank.getText().isEmpty() && !position.getText().isEmpty()
                    && !birthday.getText().isEmpty() && !numberCourses.getText().isEmpty() && (male.isSelected() || female.isSelected()) ) {

                    try {
                        dateFormat.parse(birthday.getText());
                        teacherDAO.add(new Teacher(surname.getText(), name.getText(), patronym.getText(), academicDegree.getText(),
                                academicRank.getText(), position.getText(), getTextCheckedRadioButton(list),
                                java.sql.Date.valueOf(birthday.getText()), Integer.parseInt(numberCourses.getText())));
                        JOptionPane.showMessageDialog(null, "Добавлено!");

                        userDAO.add(new User(surname.getText() + " " + name.getText(), birthday.getText(), "USER"));

                        new MainForm();
                        frame.dispose();
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Неверный формат ввода даты! Верный - гггг-мм-дд.");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Не все поля введены!");
                }

            }
        });
        constraints.gridy = 28;
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
        constraints.gridy = 30;
        panel.add(cancel, constraints);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                new MainForm();
            }
        });

        frame.add(panel);
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
