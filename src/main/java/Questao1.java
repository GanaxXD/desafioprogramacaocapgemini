import javax.swing.*;

public class Questao1 {
    
    
    public static void main(String[] args) {
        //Definindo variaveis utilizadas
        int numero=0; //número inserido pelo usuário
        boolean saida = false; //auxiliar de validação do número digitado
        String entrada = ""; //valor digitado pelo usuário em string
        String resultado = "";//resultado desejado
        
        /*
        * Verifica se o valor informado pelo usuário é válido.
        * Só são aceitos valores inteiros maiores que 0.
        * Caso o usuário não digite um valor válido, ele ficará
        * preso nesse loop até satisfazer a condição.
         */
        while(saida==false){
            entrada = JOptionPane.showInputDialog("Digte um valor: ");
            if(!entrada.matches("[0-9]+") || Integer.parseInt(entrada) < 0){
                JOptionPane.showMessageDialog(null,"Voce digitou um valor invalido. Apenas numeros sao aceitos.");
                saida = false;
            } else {
                numero = Integer.parseInt(entrada);
                saida = true;
            }
        }
        
        /*
        * Laço para iterar o número de vezes igual ao digitado pelo usuário.
        * Nele, são contabilizados os espaços em branco necessários
        * da escada, além da concatenação destes espações com os asteríscos,
        *  fundamentais para seguir a regra imposta.
        *
        *
        * Variáveis usadas:
        * int espacos: indica quantos espaços cada linha da escada usará
        * int linha: indica qual linha da escada está sendo desenhada
        *
         */
        for (int linha = 0; linha < numero; linha++){
            int espacos = 0;
            //verificando se é a última linha
            if(linha == numero -1){
                espacos=0;
                //desenhando a última linha
                while(espacos<numero){
                    resultado+="*";
                    espacos++;
                }
                System.out.println(resultado);
                resultado="";
                
            //desenhando as outras linhas da escada
            } else {
                espacos=0;
                while(espacos<=numero){
                    //Se o espaço da linha analisado for maior ou igual ao número digitado - número da linha
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
