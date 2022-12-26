//https://java-online.ru/swing-jlist.xhtml
//https://java-online.ru/swing-jtextfield.xhtml
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main
{
    public static void main(String argv[] )
    {
        MyFrame f = new MyFrame("The Window");
        f.setVisible(true);
        f.setSize(300,100);
    }
}

class MyFrame extends JFrame implements ActionListener
{
    JTextField f1;
    JTextField f2;
    JTextField f3;
    JComboBox<String> cb;
    MyFrame(String s)
    {
        super(s);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        Button b = new Button("=");
        b.setBounds(0,100,75,50);

        f1 = new JTextField(6);
        f2 = new JTextField(6);
        f3 = new JTextField(7);
        f3.setEditable(false);

        String[] elements = new String[] {"&", "|", "^","~"};
        DefaultComboBoxModel cbModel = new DefaultComboBoxModel<String>();
        for (int i = 0; i < elements.length; i++)
            cbModel.addElement((String)elements[i]);
        cb= new JComboBox<String>(cbModel);

        contentPane.add(f1);
        contentPane.add(cb);
        contentPane.add(f2);
        contentPane.add(b);
        contentPane.add(f3);

        b.addActionListener(this);

        WindowListener w1 = new WindowAdapter()
        {
            public void windowActivated(WindowEvent e)
            {
                setBackground(Color.blue);
            }
            public void windowClosed(WindowEvent e)
            {
                System.exit(0);
            }
            public void windowClosing(WindowEvent e)
            {
                dispose();
            }
            public void windowDeactivated(WindowEvent e)
            {
                setBackground(Color.lightGray);
            }
        };//attention semicolon!

        addWindowListener(w1);
    }

    public void actionPerformed(ActionEvent e)
    {
        Integer x = Integer.valueOf(f1.getText());
        Integer y = Integer.valueOf(f2.getText());

        String binary = Integer.toBinaryString(x);
        String res = "";
        String oper = cb.getSelectedItem().toString();
        try{
            switch(oper){
                case ("&"):
                    res =(x+y) + "";
                    break;
                case ("|"):
                    res = (x-y) + "";
                    break;
                case ("^"):
                    res = (x*y) + "";
                    break;
                case ("~"):
                    if (y == 0){
                        res = "I'm call to police";
                    }else{
                        res = (x/y) + "";
                    }
                    break;
            }
            f3.setText(res);

        }catch(Exception err){
            f3.setText("I'm call to police");
        }
    }
}
