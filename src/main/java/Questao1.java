import javax.swing.*;

public class Questao1 {
    
    
    public static void main(String[] args) {
        //Definindo variaveis utilizadas
        int numero=0; //número inserido pelo usuário
        boolean saida = false; //auxiliar de validação do número digitado
        String entrada = ""; //valor digitado pelo usuário em string
        String resultado = "";//resultado desejado
        
        //Passo1:
        //Verificando se o valor digitado eh valido:
        while(saida==false){
            entrada = JOptionPane.showInputDialog("Digte um valor: ");
            if(!entrada.matches("[0-9]+")){
                JOptionPane.showMessageDialog(null,"Voce digitou um valor invalido. Apenas numeros sao aceitos.");
                saida = false;
            } else {
                numero = Integer.parseInt(entrada);
                saida = true;
            }
        }
        //Passo2: desenhando as linhas
        //Passo2.1: criando um laço com o número de linhas indicado pelo usuário
        for (int linha = 0; linha < numero; linha++){
            int espacos = 0;
            //Passo2.2: verificando se é a última linha
            if(linha == numero -1){
                espacos=0;
                //desenhando a última linha
                while(espacos<numero){
                    resultado+="*";
                    espacos++;
                }
                System.out.println(resultado);
                resultado="";
                
            //Passo2.3: desenhando as outras linhas
            } else {
                espacos=0;
                while(espacos<=numero){
                    //Se o espaço da linha analisado for maior ou igual ao número digitado - o número da linha
                    if(espacos >= numero-linha){
                        resultado+="*";
                    } else if(espacos >0){
                        resultado+=" ";
                    }
                    espacos++;
                }
                System.out.println(resultado);
                resultado="";
            }
        }
    }
    
}
