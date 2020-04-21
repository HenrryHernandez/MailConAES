
package mailconaes;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.security.Key;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import javax.swing.JOptionPane;



public class MailConAES {

    private byte[] llave;
    
    public MailConAES(String key){
        System.out.println(key.length());
        if(key.length() % 8 == 0 && key.length() > 8){
            llave = key.getBytes();
        }else{
            JOptionPane.showMessageDialog(null, "La llave es incorrecta. Una llave correcta debe de tener mas de 15 caracteres y ser multiplo de 8, por ejemplo, 16, 24, 32, etc.\n8 tampoco es válido.");
        }
        
    }
    
    public String encriptar(String datos) throws Exception{
        Key k = new SecretKeySpec(llave, "AES");
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, k);
        byte[] encriptado = c.doFinal(datos.getBytes());
        String encriptadoString = Base64.getEncoder().encodeToString(encriptado);
        
        crearFile(datos, "textPlano.txt");
        crearFile(encriptadoString, "textoEncriptado.txt");
        
        return encriptadoString;
     
    }
    
    public String desencriptar(String datosEncriptados) throws Exception{
        Key k = new SecretKeySpec(llave, "AES");
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, k);
        byte[] decodificado = Base64.getDecoder().decode(datosEncriptados);
        byte[] decodificado2 = c.doFinal(decodificado);
        String desencriptado = new String(decodificado2);
        
        crearFile(desencriptado, "textoDesencriptado.txt");
        
        return desencriptado;
    }

    private void crearFile(String datos, String nombreFile) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFile));
        writer.write(datos);
        writer.close();
    }
    
    
    /*public static void main(String[] args) {
        try{
            MailConAES aes = new MailConAES("asdsdwavdqvdvde");
            String encriptado = aes.encriptar("Im in it to win it");
            System.out.println("Encriptado: " +encriptado);
            
            String desencriptado = aes.desencriptar(encriptado);
            System.out.println("Desencriptado: " +desencriptado);
        }catch(Exception e){
            System.out.println(e);
        }
    }*/
    
}
