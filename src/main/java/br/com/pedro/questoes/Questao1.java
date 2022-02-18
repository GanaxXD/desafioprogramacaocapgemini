package br.com.pedro.questoes;

import br.com.pedro.funcoes.FuncoesQuestao1;

import javax.swing.*;

public class Questao1 {
    
    public static void main(String[] args) {
        //Definindo variaveis utilizadas
        
        int numero=0; //número inserido pelo usuário
        String entrada = ""; //valor digitado pelo usuário em string
        String resultado = "";//resultado desejado
        
        entrada = JOptionPane.showInputDialog("Digte um valor: ");
        numero = FuncoesQuestao1.validaNumeroDigitado(entrada);
        
        FuncoesQuestao1.desenhaEscada(numero);
        
    }
    
}
