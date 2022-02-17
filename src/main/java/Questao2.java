import javax.swing.*;
import java.util.regex.Pattern;

public class Questao2 {
    public static void main(String[] args) {
        String senhaDigitada = "";
        int numero = 0, minuscula=0, maiuscula =0, especial=0;
        
        senhaDigitada = JOptionPane.showInputDialog(null, "Digite uma senha: ");
        
        /*
        * Depois d recebida a senha, serão feitas as verificações indicadas.
        * Para isso, foram utilizadas expresões regulares, por facilitar a busca
        *  dos caracteres indicados como obrigatórios.
        *
        * O primeiro teste ferifica se a senha tem, pelo menos, 6 dígitos. Se sim, todas as demais verificações
        * são feitas:
        * para cada match de cada letra da senha informada, é adicionado +1 na variável correspondente a
        * cada regra (se possui número,  uma minúscula, uma letra maiúscula e um caracter especial). Desta
        *  forma, se cada uma dessas variáveis inteiras (numero, minuscula, maiuscula e especial) possuir
        *  valor maior que zero, as exigências da senha forte foram atendidas.
        *
        * Caso a senha não possua pelo menos 6 dígitos, é informado ao usuário quantos dígitos faltam
        * para a senha ser forte.
         */
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
        } else {
            JOptionPane.showMessageDialog(null, " "+(6-senhaDigitada.length()));
        }
        
    }
}
