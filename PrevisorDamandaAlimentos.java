package aula11;
/*
    Nessa classe vamos criar um exemplo de Regressão Linear simples
    Esse algoritmo po de ser usado para ajudar no combate a fome, prevendo 
    a demanda de alimentos (em kg) com base no número de familias cadastradas
*/
public class PrevisorDamandaAlimentos {
    
    public static void main(String args[]){
        // Coleta dos dados estruturados (Historico dos meses anteriores)
        // Eixo x: Número de famílias cadastradas
        double[] familiasCadastradas = {10, 20, 30, 40, 50};

        // Eixo Y: KG de alimentos distribuídos
        double[] alimentosDistribuidos = {150, 300, 450, 600, 750};

        // Treinamento do modelo: encontrando a equação da reta (y = mx + b)
        // 'm' é a inclinação da reta (quando o alimento cresce por família)
        // 'b' é onde a reta corta o eixo y (valor inicial)

        double m = calcularInclinacao(familiasCadastradas, alimentosDistribuidos);

        double b = calcularIntersecao(familiasCadastradas, alimentosDistribuidos, m);

        // Predição (Regressão em ação)
        double novasFamilias = 45;
        double previsaoAlimentos = (m * novasFamilias) + b;

        System.out.println("Famílias previstas: " + novasFamilias);
        System.out.println("Previsão de alimentos: " + previsaoAlimentos);


    }

    /**
     * Método que calcula a inclinação (m) da reta de regressão. 
     * Representa o "peso" da variável independente
     */

    public static double calcularInclinacao(double[] x, double[] y) {
        int n = x.length;
        double somaX = 0;
        double somaY = 0;
        double somaXY = 0;
        double somaX2 = 0;

        for (int i = 0; i < n; i++) {
            somaX += x[i];
            somaY += y[i];
            somaXY += x[i] * y[i];
            somaX2 += x[i] * x[i];            
        }

        double resultado = ((n * somaXY) - (somaX * somaY)) / ((n * somaX2) - (somaX * somaX));
        return resultado;
    }

    /**
     * Método que calcula o ponto de interseção (b).
     * Representa o valor de Y quando X é igual a zero
     */

    public static double calcularIntersecao(double[] x, double[] y, double m) {
        double somaX = 0;
        double somaY =0;
        int n = x.length;

        for (int i = 0; i < n; i++) {
            somaX += x[i];
            somaY += y[i];
        }

        double mediaX = somaX / n;
        double mediaY = somaY / n;

        // b = Media(Y) - (m * Media(X))
        double resultado = mediaY - (m * mediaX);
        return resultado;
    }

}
