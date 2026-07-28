package aula10;

/*
    Nessa classe vamos definir a estrutura 
    dos nossos dados
*/

public class Avaliacao {
    
    // Atributos
    String cliente;
    String comentario;
    int nota; // Entre 1 a 5

    // Construtor
    public Avaliacao(String cliente, String comentario, int nota) {
        this.cliente = cliente;
        this.comentario = comentario;
        this.nota = nota;
    }

    

}
