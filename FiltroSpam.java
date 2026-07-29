package aula10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class FiltroSpam {

    public static void main(String args[]) {

        List<Email> baseEmails = new ArrayList<>();
        // Base de dados de entrada
        baseEmails.add(new Email("diretoria@escola.com", "Reunião de Planejamento", false));
        baseEmails.add(new Email("premio@spambot.net", "URGENTE: Você ganhou um iPhone! Clique aqui", true));
        baseEmails.add(new Email("premio@spambot.net", "URGENTE: Você ganhou um iPhone! Clique aqui", true));
        baseEmails.add(new Email("pedagogico@escola.com", "Aviso de Férias", false));
        baseEmails.add(
                new Email("suporte-falso@banco.com", "Sua conta foi bloqueada. Atualize seus dados no link", true));
        baseEmails.add(new Email("aluno.representante@email.com", "Dúvida sobre o projeto", false));
        baseEmails.add(new Email("scrum.master@projeto-fome.org",
                "Atualização do Product Backlog: App de Combate à Fome", false));
        baseEmails.add(new Email("promocao@desconto-milagroso.com",
                "Perca 10kg em 3 dias com esta pílula mágica! Compre agora", true));
        baseEmails.add(new Email("coordenacao@tecnico.edu.br", "Envio do Relatório de Atividades do Terceiro Trimestre",
                false));
        baseEmails.add(new Email("cobranca@falsa-operadora.net",
                "AVISO: Sua fatura está vencida. Baixe o boleto em anexo urgente", true));
        baseEmails.add(new Email("acessibilidade@escola.com",
                "Configuração do leitor de tela para estudante com deficiência visual", false));

        // Mapa para a classificação dos emails
        Map<String, List<Email>> analiseSpam = new HashMap<>();
        analiseSpam.put( "Caixa de Entrada", new ArrayList<>());
        analiseSpam.put("Lixo Eletrônico (Spam)", new ArrayList<>());

        // Regra do Negócio
        for (Email email : baseEmails) {
            if (email.contentSuspeito) {
                analiseSpam.get("Lixo Eletrônico (Spam)").add(email);
            } else {
                analiseSpam.get("Caixa de Entrada").add(email);
            }
        }

        // Exibindo os resultados
        System.out.println("--- RESULTADO DO FILTRADOR DE SPAM ---");
        for (String categoria: analiseSpam.keySet()) {
            System.out.println("Categoria: " + categoria);
            for (Email email : analiseSpam.get(categoria)){
                System.out.println(email.remetente + ": " + email.assunto);
            }

            System.out.println("*".repeat(50));
            System.out.println();
        }
    }

}
