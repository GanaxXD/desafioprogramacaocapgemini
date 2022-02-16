import javax.swing.*;
import java.util.regex.Pattern;

public class Questao2 {
    public static void main(String[] args) {
        String senhaDigitada = "";
        int numero = 0, minuscula=0, maiuscula =0, especial=0;
        
        senhaDigitada = JOptionPane.showInputDialog(null, "Digite uma senha: ");
        
        if(senhaDigitada.length()>=6){
            for (int i =0; i<senhaDigitada.length(); i++){
                if(Pattern.matches("[0-9]", senhaDigitada.substring(i,i+1))){
                    numero++;
                }else if(Pattern.matches("[a-z]", senhaDigitada.substring(i,i+1))){
                    minuscula++;
                }else if(Pattern.matches("[A-Z]", senhaDigitada.substring(i,i+1))){
                    maiuscula++;
                }else if(Pattern.matches("[!@#$%^&*()\\-+]", senhaDigitada.substring(i,i+1))){
                    especial++;
                }
            }
            
            if(numero>0 && minuscula>0 && maiuscula>0 && especial>0){
                JOptionPane.showMessageDialog(null, "Senha válida!");
            }
            /*
            if(
                senhaDigitada.matches("[0-9]+") &&
                senhaDigitada.matches("[a-z]+") &&
                senhaDigitada.matches("[A-Z]+") &&
                senhaDigitada.matches("[!@#$%^&*()\\-+]+")
            ){
                JOptionPane.showMessageDialog(null, "Senha válida!");
            }*/
        } else {
            JOptionPane.showMessageDialog(null, " "+(6-senhaDigitada.length()));
        }
        
    }
}
