package program.gui;

import program.DAO.UserDAO;
import program.DAO.UserDAOImpl;
import program.entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class AddUser {

    private final int WIDTH = 500;
    private final int HEIGHT = 800;

    List<JRadioButton> list = new ArrayList<JRadioButton>();

    public AddUser() {
        final JFrame frame = new JFrame("Форма добавления пользователя");
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.VERTICAL;

        JLabel loginLabel = new JLabel("Логин:");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(loginLabel, constraints);

        final JTextField login = new JTextField();
        login.setPreferredSize(new Dimension(200, 40));
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(login, constraints);

        JLabel emptyLabel = new JLabel(" ");
        constraints.gridy = 2;
        panel.add(emptyLabel, constraints);

        JLabel passwordLabel = new JLabel("Пароль:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridy = 3;
        panel.add(passwordLabel, constraints);

        final JTextField password = new JTextField();
        password.setPreferredSize(new Dimension(200, 40));
        constraints.gridy = 4;
        panel.add(password, constraints);

        JLabel emptyLabel2 = new JLabel(" ");
        constraints.gridy = 5;
        panel.add(emptyLabel2, constraints);

        JLabel roleLabel = new JLabel("Категория пользователя:");
        roleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridy = 6;
        panel.add(roleLabel, constraints);

        ButtonGroup group = new ButtonGroup();
        final JRadioButton admin = new JRadioButton("Администратор");
        constraints.gridy = 7;
        group.add(admin);
        list.add(admin);
        panel.add(admin, constraints);

        final JRadioButton user = new JRadioButton("Пользователь");
        constraints.gridy = 8;
        group.add(user);
        list.add(user);
        panel.add(user, constraints);

        JLabel emptyLabel7 = new JLabel(" ");
        constraints.gridy = 9;
        panel.add(emptyLabel7, constraints);

        JButton add = new JButton("Добавить");
        add.setPreferredSize(new Dimension(200, 40));
        add.setForeground(Color.white);
        add.setBackground(new Color(26, 77, 13, 255));
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserDAO userDAO = new UserDAOImpl();

                if (!login.getText().isEmpty() && !password.getText().isEmpty() && (admin.isSelected() || user.isSelected())) {
                    userDAO.add(new User(login.getText(), password.getText(), getRole(getTextCheckedRadioButton(list))));
                    JOptionPane.showMessageDialog(null, "Пользователь добавлен!");
                    frame.dispose();
                    new MainForm();
                } else {
                    JOptionPane.showMessageDialog(null, "Не все поля введены. Проверьте ввод!");
                }
            }
        });
        constraints.gridy = 10;
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
        constraints.gridy = 11;
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

    private String getRole(String str) {
        if (str.equals("Администратор")) {
            return "ADMIN";
        }
        return "USER";
    }

}
