import poo.tema3.Student;
import poo.util.ExceptieDateIncomplete;
import poo.util.ExceptieListaGoala;
import poo.util.ExceptieListaPlina;
import poo.util.ListaDeComparable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfataGrafica extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JLabel frameLabel = new JLabel();
    JButton butonAdauga;
    JButton butonSterge;
    JButton butonSorteaza;
    JLabel labelNume;
    JLabel labelPrenume;
    JLabel labelPrezenta;
    JLabel labelLista;
    JTextField textNume;
    JTextField textPrenume;
    JTextField textPrezenta;
    JTextArea textLista;
    ListaDeComparable<Student> lista;
    int dimensiune;
    int numarElemente;

    InterfataGrafica(int dimensiune) {
        this.dimensiune = dimensiune;

        lista = new ListaDeComparable<>(Student.class, dimensiune);

        butonAdauga = new JButton("Adauga");
        butonSterge = new JButton("Sterge");
        butonSorteaza = new JButton("Sorteaza");

        butonAdauga.setBounds(400, 25, 150, 150);
        butonAdauga.addActionListener(this);

        butonSterge.setBounds(400, 200, 150, 150);
        butonSterge.addActionListener(this);

        butonSorteaza.setBounds(400, 375, 150, 150);
        butonSorteaza.addActionListener(this);

        labelNume = new JLabel("Nume  ->");
        labelPrenume = new JLabel("Prenume  ->");
        labelPrezenta = new JLabel("Prezenta  ->");
        labelLista = new JLabel("Lista de studenti");

        labelNume.setBounds(40, 25, 60, 50);
        labelPrenume.setBounds(40, 85, 90, 50);
        labelLista.setBounds(150, 220, 160, 50);
        labelPrezenta.setBounds(40, 145, 90, 50);

        textNume = new JTextField();
        textPrenume = new JTextField();
        textPrezenta = new JTextField();
        textLista = new JTextArea();


        textNume.setBounds(130, 25, 230, 50);

        textPrenume.setBounds(130, 85, 230, 50);

        textPrezenta.setBounds(130, 145, 230, 50);

        textLista.setBounds(40, 260, 320, 265);

        textLista.setLineWrap(true);
        textLista.setWrapStyleWord(true);
         textLista.setEditable(false);



        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(600, 580);
        frame.setResizable(false);
        frame.setTitle("TEMA 3 RADU");


        frame.add(frameLabel);
             frameLabel.add(butonAdauga);
             frameLabel.add(butonSterge);
             frameLabel.add(butonSorteaza);
             frameLabel.add(labelNume);
             frameLabel.add(labelPrezenta);
             frameLabel.add(labelLista);
             frameLabel.add(labelPrenume);
             frameLabel.add(textNume);
             frameLabel.add(textPrenume);
             frameLabel.add(textPrezenta);
             frameLabel.add(textLista);

        frame.setLocationRelativeTo(null); // pe mijlocul ecranului
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == butonAdauga) {

                butonSterge.setEnabled(true);

                String nume = textNume.getText();
                String prenume = textPrenume.getText();
                int prezenta = Integer.parseInt(textPrezenta.getText());
                if (nume.isEmpty() || prenume.isEmpty() || prezenta == 0) {
                    throw new ExceptieDateIncomplete("Completeaza toate campurile");
                }

                Student studentAdaugat = new Student();

                studentAdaugat.setNume(nume);
                studentAdaugat.setPrenume(prenume);
                studentAdaugat.setPrezenta(prezenta);


                textNume.setText("");
                textPrenume.setText("");
                textPrezenta.setText("");

                lista.adaugareElemente(studentAdaugat);
                textLista.setText(lista.afisareElemente());

                numarElemente++;
                if (numarElemente > 0) {
                    butonSorteaza.setEnabled(true);
                }
            }
        } catch (ExceptieListaPlina e1) {
            butonAdauga.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Lista este plina (sorteaza/sterge)", "EroareListaPlina", JOptionPane.WARNING_MESSAGE);
        } catch (ExceptieListaGoala e1) {
            JOptionPane.showMessageDialog(null, "Lista este goala (adauga)", "EroareListaGoala", JOptionPane.WARNING_MESSAGE);
        } catch (ExceptieDateIncomplete ex) {
            JOptionPane.showMessageDialog(null, "Completeaza toate campurile", "EroareDateIncomplete", JOptionPane.WARNING_MESSAGE);
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Prezenta trebuie sa fie un numar", "EroarePrezenta", JOptionPane.WARNING_MESSAGE);
        }

        if (e.getSource() == butonSterge) {
            try {
                lista.eliminareElemente();
                textLista.setText(lista.afisareElemente());
            } catch (ExceptieListaGoala e1) {
                butonSterge.setEnabled(false);
                butonSorteaza.setEnabled(false);
                JOptionPane.showMessageDialog(null, "lista este goala (adauga)", "EroareListaGoala", JOptionPane.WARNING_MESSAGE);
                textLista.setText("");
            }
            numarElemente--;
            butonAdauga.setEnabled(true);

        }

        if (e.getSource() == butonSorteaza) {
            try {
                lista.sortareElemente();
                textLista.setText(lista.afisareElemente());
            } catch (ExceptieListaGoala e1) {
                butonSorteaza.setEnabled(false);
                JOptionPane.showMessageDialog(null, "lista este goala (adauga)", "EroareListaGoala", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}

