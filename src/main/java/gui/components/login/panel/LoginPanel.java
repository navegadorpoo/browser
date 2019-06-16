package gui.components.login.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import gui.components.interaction.Dialog;
import gui.components.label.StyledLabel;
import gui.components.login.input.Input;
import gui.components.login.input.InputType;
import lib.browser.Browser;
import lib.browser.User;
import lib.database.repositories.UserRepository;

public class LoginPanel extends JPanel {
    Input username = new Input("Usuário", InputType.TEXT);
    Input password = new Input("Senha", InputType.PASSWORD);
    JButton login  = new JButton("Entrar");

    public LoginPanel() {
        setLayout(new GridBagLayout());
        setBorder(new EmptyBorder(50, 50, 50, 50));
        add(new StyledLabel("Bem Vindo!", "teal", "30", 30), getGridConstraints(0));
        add(new StyledLabel("Faça login e aproveite todos os nossos recursos", "teal", "14", 30), getGridConstraints(1));
        add(username, getGridConstraints(2));
        add(password, getGridConstraints(3));
        add(login,    getGridConstraints(4));
        setEvents();
    }

    private GridBagConstraints getGridConstraints(int gridy) {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = gridy;
        c.weightx = 1;
        return c;
    }

    private void setEvents() {
        LoginPanel self = this;
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    String login = username.getText();
                    String pass  = password.getText();
                    User user = new User(0, null, null, login, login, pass);
                    user.validateUsername();
                    user.validatePassword();

                    User loggedUser = UserRepository.consult(login, login, pass);

                    if (loggedUser == null) {
                        Dialog.showMessage("error", "Atenção", "Usuário ou senha inválidos");
                        return;
                    }

                    Browser.getInstance().login(loggedUser);
                } catch (IllegalArgumentException e) {
                    Dialog.showMessage("info", "Atenção", e.getMessage());
                } catch (SQLException e) {
                    Dialog.showMessage("error", "Ops", "Ocorreu um problema ao realizar o login. Por favor, tente novamente mais tarde.");
                } finally {
                    SwingUtilities.getWindowAncestor(self).setVisible(false);
                }
            }
        });
    }
}
