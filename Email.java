package aula10;

public class Email {
    
    // Atributos
    String remetente;
    String assunto;
    boolean contentSuspeito;

    // Construtor
    public Email (String remetente, String assunto, boolean contentSuspeito) {
        this.remetente = remetente;
        this.assunto = assunto;
        this.contentSuspeito = contentSuspeito;
    }
}


