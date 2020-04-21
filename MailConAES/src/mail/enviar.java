package mail;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class enviar extends JFrame { //Esta clase es la que nos va a ayudar a obtener los tados del usuario que quiere enviar mail

    JLabel lblCorreo, lblContra, lblPara, lblAsunto;
    JTextField txtCorreo, txtPara, txtAsunto;
    JPasswordField txtContra;
    JButton aceptar, cancelar;
    
    String correo, contra, para, asunto;

    public enviar() { //Lo que hace el constructor es simplemente pintar la interfaz que obtiene los datos del usuario que va a enviar el mail
        
        setLayout(null);
        setBounds(100, 50, 315, 230);

        lblCorreo = new JLabel("Correo: ");
        lblCorreo.setBounds(10, 10, 100, 30);
        add(lblCorreo);

        lblContra = new JLabel("Contraseña: ");
        lblContra.setBounds(10, 40, 100, 30);
        add(lblContra);

        lblPara = new JLabel("Para: ");
        lblPara.setBounds(10, 70, 100, 30);
        add(lblPara);

        lblAsunto = new JLabel("Asunto: ");
        lblAsunto.setBounds(10, 100, 100, 30);
        add(lblAsunto);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(90, 10, 190, 30);
        add(txtCorreo);

        txtContra = new JPasswordField();
        txtContra.setEchoChar('*');
        txtContra.setBounds(90, 40, 190, 30);
        add(txtContra);

        txtPara = new JTextField();
        txtPara.setBounds(90, 70, 190, 30);
        add(txtPara);

        txtAsunto = new JTextField();
        txtAsunto.setBounds(90, 100, 190, 30);
        add(txtAsunto);

        aceptar = new JButton("Aceptar");
        aceptar.setBounds(90, 150, 75, 25);
        aceptar.addActionListener(new ActionListener() { //Al darle aceptar, obtiene los datos de los textos y los pone en las variables correspondientes
            public void actionPerformed(ActionEvent e) {
                if(txtCorreo.getText().equals("") || txtContra.getText().equals("") || txtPara.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Ingresa los datos correspondientes en los espacios");
                }else{
                    correo = txtCorreo.getText();
                    contra = txtContra.getText();
                    para = txtPara.getText();
                    asunto = txtAsunto.getText();
                    
                    mailSender enviar = new mailSender(correo, contra, para, asunto);
                    enviar.enviar();
                    
                    setVisible(false);
                }
            }
        });
        add(aceptar);

        cancelar = new JButton("Cancelar");
        cancelar.setBounds(175, 150, 85, 25);
        cancelar.addActionListener(new ActionListener() { //Si le damos click a cancelar simplemente se cierra la interfaz
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add(cancelar);
        
        setVisible(true);
    }
    
    
    //estos metodos son simplemente para obtener los valores de las variables
    public String getCorreo(){
        return correo;
    }
    
    public String getContra(){
        return contra;
    }
    
    public String getPara(){
        return para;
    }
}
