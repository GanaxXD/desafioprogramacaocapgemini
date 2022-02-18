package br.com.pedro.questoes;

import br.com.pedro.funcoes.FuncoesQuestao3;

import javax.swing.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Questao3 {
    public static void main(String[] args) {
        String palavraDigitada = "";
        boolean loop = true;
    
        String regex = "[a-zA-Z]";
        Pattern p = Pattern.compile(regex);
    
        palavraDigitada = JOptionPane.showInputDialog("Digite uma palavra: ");
        Matcher m = p.matcher(palavraDigitada);
    
        //Verificando se a palavra é válida
        if (!m.find()) {
            while (loop == true) {
                palavraDigitada = JOptionPane.showInputDialog("Palavra inválida! \nDigite uma palavra: ");
                m = p.matcher(palavraDigitada);
                if (m.find()) {
                    loop = false;
                }
            }
        }
        System.out.println(FuncoesQuestao3.verificaAnagramaEmPalavraDeUmaLetra(palavraDigitada) + FuncoesQuestao3.verificaAnagramaEmPalavraDeNLetra(palavraDigitada));
    }
    
}
