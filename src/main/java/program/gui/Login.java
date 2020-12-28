package program.gui;

import program.DAO.UserDAO;
import program.DAO.UserDAOImpl;
import program.encoder.Encoder;
import program.entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {

    public Login() {

        final JFrame frame = new JFrame("Окно авторизации.");
        frame.setSize(new Dimension(640, 480));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.white);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.VERTICAL;

        JLabel loginLabel = new JLabel("Логин:");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(loginLabel, constraints);

        final JTextField login = new JTextField();
        login.setPreferredSize(new Dimension(200, 40));
        constraints.gridy = 1;
        panel.add(login, constraints);

        JLabel emptyLabel1 = new JLabel(" ");
        constraints.gridy = 2;
        panel.add(emptyLabel1, constraints);

        JLabel passwordLabel = new JLabel("Пароль:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));
        constraints.gridy = 3;
        panel.add(passwordLabel, constraints);

        final JPasswordField password = new JPasswordField();
        password.setPreferredSize(new Dimension(200, 40));
        constraints.gridy = 4;
        panel.add(password, constraints);

        JLabel emptyLabel2 = new JLabel(" ");
        constraints.gridy = 5;
        panel.add(emptyLabel2, constraints);

        JButton add = new JButton("Войти");
        add.setPreferredSize(new Dimension(200, 40));
        add.setForeground(Color.white);
        add.setBackground(new Color(26, 77, 13, 255));
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserDAO userDAO = new UserDAOImpl();

                if (!login.getText().isEmpty() && !password.getText().isEmpty()) {
                    User user = userDAO.getByName(login.getText());

                    if (user.getId() != 0) {
                        if (user.getPassword().equals(new Encoder().getEncodedString(password.getText()))) {
                            MainForm.setUser(user);
                            new MainForm();
                            frame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Не удалось войти! Проверьте корректность вводимых данных!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Не удалось войти! Проверьте корректность вводимых данных!");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Не все поля введены!");
                }
            }
        });
        constraints.gridy = 6;
        panel.add(add, constraints);

        JButton cancel = new JButton("Отмена");
        cancel.setPreferredSize(new Dimension(200, 40));
        cancel.setForeground(Color.white);
        cancel.setBackground(new Color(123, 12, 11));
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        constraints.gridy = 7;
        panel.add(cancel, constraints);

        frame.add(panel);
        frame.setVisible(true);
    }

}
