import javax.swing.*;
import java.awt.*;
import java.io.*;


public class ImageEncryption{
    public static void operate(int key){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file =fileChooser.getSelectedFile();

        try{
            FileInputStream fis =new FileInputStream(file);
            byte [] data =new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data){
                System.out.println(b);
                data [i]=(byte)(b^key);
                i++;
            }

            FileOutputStream fos =new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null," Done");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String [] args){
        System.out.println("hello sumit!");
        JFrame f=new JFrame();
        f.setTitle("Image Operation");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        Font font =new Font("Roboto",Font.BOLD,25);

        JButton button =new JButton();
        button.setText("Open Image!!!");
        button.setFont(font);
        JTextField textfield=new JTextField(10);
        textfield.setFont(font);
        JLabel label =new JLabel("Enter key ");
        label.setFont(font);

        JPanel panel =new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.add(label);
        panel.add(textfield);

        button.addActionListener(e->{
            System.out.println("Button click.");
            String text=textfield.getText();
            int temp=Integer.parseInt(text);
            operate(temp);
        });

        f.setLayout(new FlowLayout());

        f.add(button);
        f.add(panel);
        f.setVisible(true);

    }
}