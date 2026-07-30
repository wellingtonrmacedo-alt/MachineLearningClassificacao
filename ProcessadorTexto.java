package aula12;
import java.util.HashMap;
import java.util.Map;

/**
 *  nessa classe vamos analisar dados não estruturados a partir 
 * de um texto sob a impressão de alguns clientes com relação a um leitor de tela
 */

public class ProcessadorTexto {
    
    public static void main(String args[]){

        // Dado não estruturado: um texto bruto continuo retirado de uma transcrição ou audio
        String feedbackBruto = "O leitor de tela é muito bom.";
        feedbackBruto += "O leitor ajuda na leitura do material.";
        feedbackBruto += "Preciso de ajuda com o leitor em algumas páginas.";
        feedbackBruto += "Não consegui usar o leitor no texto.";
        feedbackBruto += "O leitor não me ajudou no dia a dia.";

        System.out.println("--- Dado não estruturado ---");
        System.out.println(feedbackBruto + "\n");

        // Limpeza dos dados (Date Preparation)
        // Converter tudo para letras minúsculas
        String textoLimpo = feedbackBruto.toLowerCase();

        System.out.println("--- Texto em letras minúsculas ---");
        System.out.println(textoLimpo + "\n");

        // Remover pontos finais das frases
        textoLimpo = textoLimpo.replace(".", " ");
        System.out.println("--- Texto sem ponto final ---");
        System.out.println(textoLimpo + "\n");

        //Estruturação do texto: quebrando o texto em um vetor (array)
        String[] palavras = textoLimpo.split(" ");
        
        // Criando a estrutura de dados (HashMap) para armazenar a frequência de cada palavra
        // Chave (String): a palavra
        // Valor (Integer): Quantas vezes a palavra aparece no texto
        Map<String, Integer> frequenciaPalavras = new HashMap<>();

        // processamento: contando as palavras
        for (String palavra: palavras) {
            // Se a palavra já estiver no Mapa, somamos ao valor atual
            if(frequenciaPalavras.containsKey(palavra)){
                int contagemAtual = frequenciaPalavras.get(palavra);
                frequenciaPalavras.put(palavra, contagemAtual + 1);                
            }else {
                frequenciaPalavras.put(palavra, 1);
            }
        }

        // Exibindo o dado agora estruturado
        System.out.println("--- Dados estruturados (frequência de palavras) ---");
        for (String chave : frequenciaPalavras.keySet()) {
            System.out.println("Palavra: " + chave + " -> Apareceu: " + frequenciaPalavras.get(chave) + " vez(es).");
        }

    }
}
