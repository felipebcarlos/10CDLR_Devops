public class ExemploVulnerabilidade {

    public static void main(String[] args) {
        // ... algum código anterior ...

        String userInput = "valor1"; // Declaração inicial
        Statement statement = connection.createStatement(); // Declaração inicial

        // ... algum código no meio ...

        userInput = "valor2"; // Apenas reatribuição (sem 'String' na frente)
        statement = connection.createStatement(); // Apenas reatribuição (sem 'Statement' na frente)

        // ...
    }
}
