import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ManageEmployees  {
    private JFrame frame = new JFrame("Employee Register");
    private JLabel label1,label2,label3,label4,label5,label6,label7,label8;
   private JTextField textField;
    private JButton button1,button2,button3,button4;
    //private Dimension dimension;
    private JTable table;
    private Object[][]employeeInfo={{"Meron","","","","","","",""},{"Christian","","","","","","",""}};
    private String[] columnnames={"Name","Sur Name","Gender","Birth date","Tel.no","Salary","Department","Role"};
    private JScrollPane scrollPane;
    private DefaultTableModel tabelmodel;


    public ManageEmployees(){
        frame.setLayout(null);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocationRelativeTo(null);
        table= new JTable();
       // table.setBounds(30, 40, 200, 300);
        tabelmodel=new DefaultTableModel(employeeInfo,columnnames);
        table.setModel(tabelmodel);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(700,270);
        scrollPane.setLocation(50,50);
        frame.add(scrollPane);


        button1= new JButton("Add");
        button1.setSize(100,30);
        button1.setLocation(50,370);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addFrame= new JFrame();
                JLabel addName= new JLabel("Namn");
                JButton buttonSave,buttonCancel;
                addName.setSize(80,30);
                addName.setLocation(10,40);

                JTextField namnField= new JTextField(50);
                namnField.setSize(200,30);
                namnField.setLocation(60,50);
                addFrame.setLayout(null);
                addFrame.setSize(300,400);
                //addFrame.setDefaultCloseOperation(addFrame.EXIT_ON_CLOSE);
                addFrame.add(addName);
                addFrame.add(namnField);
                addFrame.setVisible(true);
                buttonSave= new JButton("Save");
                buttonCancel=new JButton("Cancel");
                buttonSave.setSize(80,30);
                buttonSave.setLocation(50,300);
                buttonCancel.setSize(80,30);
                buttonCancel.setLocation(170,300);
                addFrame.add(buttonSave);
                addFrame.add(buttonCancel);

            }
        });
        frame.add(button1);


        button2= new JButton("Delete");
        button2.setSize(100,30);
        button2.setLocation(250,370);
        //button2.addActionListener(new ());
        frame.add(button2);

        button3= new JButton("Uppdate");
        button3.setSize(100,30);
        button3.setLocation(450,370);
       // button3.addActionListener(new ());
        frame.add(button3);

        /*button4=new JButton("Search");
        button4.setSize(100,30);
        button4.setLocation(650,370);
       // button4.addActionListener(new ());
        frame.add(button4);*/


        label1 = new JLabel("Search");
        label1.setSize(200,30);
        label1.setLocation(550,8);
        frame.add(label1);

        textField= new JTextField(10);
        textField.setSize(150,20);
        textField.setLocation(600,15);
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                String textToSearch = textField.getText();
                Object[][] filteredEmployeeInfo = getFilteredEmployeeInfo(textToSearch, employeeInfo);
                tabelmodel=new DefaultTableModel(filteredEmployeeInfo,columnnames);
                table.setModel(tabelmodel);        
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        frame.add(textField);


        frame.setVisible(true);



}

    private Object[][] getFilteredEmployeeInfo(String textToSearch, Object[][] employeeInfo) {
        if(textToSearch.isEmpty()) {
            return employeeInfo;
        }
        Object[][] filteredEmployeeInfo = {{"Christian","","","","","","",""}};
        return filteredEmployeeInfo;
    }

    public static void main(String[] args) {
       new ManageEmployees();

    }
}