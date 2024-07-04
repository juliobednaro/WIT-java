package pl.wit.lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import net.miginfocom.swing.MigLayout;

public class PersonJF extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField textFirstName;
    private JTextField textSurname;
    private JTextField textAge;
    private JRadioButton radioMale;
    private JRadioButton radioFemale;
    private JTextArea textDescription;
    private JButton btnSave;
    private ButtonGroup genderGroup;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PersonJF frame = new PersonJF();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PersonJF() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[100px][grow]", "[][][][][][grow][]"));

        JLabel lblFirstName = new JLabel("Imię:");
        contentPane.add(lblFirstName, "cell 0 0,alignx trailing");
        textFirstName = new JTextField();
        contentPane.add(textFirstName, "cell 1 0,growx");
        textFirstName.setColumns(10);

        JLabel lblSurname = new JLabel("Nazwisko:");
        contentPane.add(lblSurname, "cell 0 1,alignx trailing");
        textSurname = new JTextField();
        contentPane.add(textSurname, "cell 1 1,growx");
        textSurname.setColumns(10);

        JLabel lblAge = new JLabel("Wiek:");
        contentPane.add(lblAge, "cell 0 2,alignx trailing");
        textAge = new JTextField();
        contentPane.add(textAge, "cell 1 2,growx");
        textAge.setColumns(10);

        JLabel lblGender = new JLabel("Płeć:");
        contentPane.add(lblGender, "cell 0 3,alignx trailing");

        radioMale = new JRadioButton("Mężczyzna");
        radioMale.setActionCommand("Mężczyzna");
        contentPane.add(radioMale, "flowx,cell 1 3");

        radioFemale = new JRadioButton("Kobieta");
        radioFemale.setActionCommand("Kobieta");
        contentPane.add(radioFemale, "cell 1 3");

        genderGroup = new ButtonGroup();
        genderGroup.add(radioMale);
        genderGroup.add(radioFemale);

        JLabel lblDescription = new JLabel("Opis:");
        contentPane.add(lblDescription, "cell 0 4,alignx trailing");

        textDescription = new JTextArea();
        contentPane.add(new JScrollPane(textDescription), "cell 1 4,grow");

        btnSave = new JButton("Zapisz");
        btnSave.addActionListener(this);
        contentPane.add(btnSave, "cell 1 5,alignx center");

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            String firstName = textFirstName.getText();
            String surname = textSurname.getText();
            String age = textAge.getText();
            String description = textDescription.getText();
            String gender = genderGroup.getSelection() != null ? genderGroup.getSelection().getActionCommand() : null;

            if (StringUtils.isBlank(firstName)) {
                showWarning("Pole Imię nie może być puste.");
                return;
            }

            if (StringUtils.isBlank(surname)) {
                showWarning("Pole Nazwisko nie może być puste.");
                return;
            }

            if (StringUtils.isBlank(age) || !NumberUtils.isDigits(age)) {
                showWarning("Pole Wiek musi zawierać same cyfry i nie może być puste.");
                return;
            }

            if (gender == null) {
                showWarning("Należy wybrać płeć.");
                return;
            }

            System.out.println("Imię: " + firstName);
            System.out.println("Nazwisko: " + surname);
            System.out.println("Wiek: " + age);
            System.out.println("Płeć: " + gender);
            System.out.println("Opis: " + description);
        }
    }

    private void showWarning(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
