package aula09;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/*
    Nessa classe vamos criar um vetor dinâmico que cresce sózinho 
    É a implementação mais usada para listas, sendo excelente para 
    buscas rápidas por posição
*/ 
public class CategorizadorDados {
    
    public static void main(String args[]) {

        // Criando um conjunto de dados estruturado
        List<Pessoa> baseDados = new ArrayList<>();
        baseDados.add(new Pessoa("Wellington", 44));
        baseDados.add(new Pessoa("Maria", 10));
        baseDados.add(new Pessoa("John", 65));
        baseDados.add(new Pessoa("Wesley", 33));
        baseDados.add(new Pessoa("Eduardo", 02));
        baseDados.add(new Pessoa("Monica", 47));
        baseDados.add(new Pessoa("Ana", 19));
        baseDados.add(new Pessoa("Michael", 26));
        baseDados.add(new Pessoa("William", 16));
        baseDados.add(new Pessoa("Tank", 56));

        // Criando um mapa (HashMap) para categorizar (Classificar) 
        // A chave (String) será a categoria ("Maior de idade" ou "Menor de idade")
        // O valor será uma lista de pessoas que pertencem a essa categoria

        Map<String, List<Pessoa>> dadosCategorizados = new HashMap<>();
        dadosCategorizados.put("Maior de idade", new ArrayList<>());
        dadosCategorizados.put("Menor de idade", new ArrayList<>());

        // Processamento lendo os dadosbrutos e classificando
        for(Pessoa p: baseDados) {
            if(p.idade >= 18) {
                // Adiciona na categoria "Maior de idade"
                dadosCategorizados.get("Maior de idade").add(p);
            }else {
                dadosCategorizados.get("Menor de idade").add(p);
            }
        }

        // Exibir a informação categorizada
        System.out.println("--- Dados Classificados ---");
        for(String categoria: dadosCategorizados.keySet()) {
            System.out.println("Categoria: " + categoria);
            for(Pessoa p: dadosCategorizados.get(categoria)) {
                System.out.println(" - " + p.nome + " (" + p.idade + " anos)");
            }
            System.out.println();
        }
    }
}
