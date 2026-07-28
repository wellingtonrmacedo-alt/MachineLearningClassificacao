package aula10;

/*
    Nessa classe vamos treinar nosso modelo analisando o sentimento dos
    clientes em relação a um celular específico.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalisadorSentimentos {

    public static void main(String args[]) {

        // Base de dados de entrada
        List<Avaliacao> avaliacoes = new ArrayList<>();
        avaliacoes.add(new Avaliacao("Gaspar", "Excelente celular, câmera ótima", 5));
        avaliacoes.add(new Avaliacao("Luiza", "Bateria dura pouco, me arrependi", 1));
        avaliacoes.add(new Avaliacao("Jorge", "É ok, faz o básico", 3));
        avaliacoes.add(new Avaliacao("Anabela", "Muito caro pelo que entrega.", 2));
        avaliacoes.add(new Avaliacao("Galego", "Perfeito, recomendo muito", 5));
        avaliacoes.add(new Avaliacao("Blue", "O desempenho em jogos é fantástico, não trava nada.", 5));
        avaliacoes.add(new Avaliacao("Neve",
                "Acessibilidade incrível, o leitor de tela nativo ajuda muito usuários com deficiência visual.", 5));
        avaliacoes.add(new Avaliacao("Xuxu", "A tela risca co muita facilidade, material muito frágil.", 2));
        avaliacoes.add(new Avaliacao("Mel",
                "Bom custo benefício, mas o fato de vir sem o carregador na caixa é frustrante.", 4));
        avaliacoes.add(new Avaliacao("Bruce",
                "As opções de alto contraste são excelentes, porém o volume máximo do áudio deixa a desejar.", 3));

        // Mapa para a classificação dos sentimentos
        Map<String, List<Avaliacao>> analiseSentimentos = new HashMap<>();
        analiseSentimentos.put("Sentimento Positivo", new ArrayList<>());
        analiseSentimentos.put("Sentimento Neutro", new ArrayList<>());
        analiseSentimentos.put("Sentimento Negativo", new ArrayList<>());

        // Motor de Classificação
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.nota >= 4) {
                analiseSentimentos.get("Sentimento Positivo").add(avaliacao);                
            } else if (avaliacao.nota == 3) {
                analiseSentimentos.get("Sentimento Neutro").add(avaliacao);
            } else {
                analiseSentimentos.get("Sentimento Negativo").add(avaliacao);
            }
        }

        // Exibindo os resultados
        System.out.println("--- RESULTADO DO MODELO DE ANÁLISE ---");
        for (String sentimento : analiseSentimentos.keySet()) {
            System.out.println("Categoria: " + sentimento);
            for (Avaliacao avaliacao : analiseSentimentos.get(sentimento)){
                System.out.println(avaliacao.cliente + "(" + avaliacao.nota + " estrela(s)): " + avaliacao.comentario);
            }
            
            System.out.println("=".repeat(50));
            System.out.println();
        }


    }
}
