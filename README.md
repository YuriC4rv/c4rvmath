# c4rvmath

Uma biblioteca Java de alta performance e usabilidade simplificada, desenvolvida para fornecer um motor de cálculo matemático puro e otimizado.

A c4rvmath elimina os códigos repetitivos (boilerplate) e a verbosidade tradicional do ecossistema Java, entregando respostas rápidas através de métodos estáticos limpos. Por isolar completamente a lógica matemática da entrada de dados, a arquitetura torna-se flexível e pronta para integração em qualquer ambiente, incluindo aplicações via terminal, interfaces gráficas desktop (Swing/JavaFX), aplicativos móveis (Android) ou APIs Web.

## Funcionalidades Principais

* **Motor de Cálculo Puro:** Processamento direto através de chamadas estáticas rápidas, eliminando a necessidade de instanciação de objetos (new).
* **Segurança DX (Developer Experience):** Tratamento interno de strings com remoção de espaços acidentais através do método trim e validações nativas.
* **Arquitetura Desacoplada:** Independência total de fluxos rígidos de entrada e saída (como Scanner ou System.out), garantindo integração imediata com qualquer arquitetura de software.

## Como Usar a Biblioteca

Após adicionar o arquivo c4rvmath.jar às dependências do seu projeto, a utilização do motor pode ser feita de duas formas.

### 1. Chamada Direta (Variáveis Prontas ou Interface Gráfica)
Se os dados já foram capturados por um formulário web, uma janela Swing ou variáveis do sistema, basta disparar o motor em uma única linha de código:

```java
import com.c4rvmath.core.MathUtils;

public class ExemploDireto {
    public static void main(String[] args) {
        double valor1 = 45.5;
        double valor2 = 4.5;

        // Execução limpa e direta
        double resultadoSoma = MathUtils.calcular(valor1, "+", valor2); // Retorna 50.0
        double resultadoSub  = MathUtils.calcular(valor1, "-", valor2); // Retorna 41.0
    }
}
```

### 2. Integração Customizada (Terminal Interativo)
Por não possuir amarração com o teclado dentro do core, o desenvolvedor possui total liberdade para criar a sua própria lógica de captura personalizada antes de acionar o motor:

```java
import java.util.Scanner;
import com.c4rvmath.core.MathUtils;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Informe o valor A: ");
        double a = teclado.nextDouble();
        
        System.out.print("Informe o operador (+ ou -): ");
        String op = teclado.next();
        
        System.out.print("Informe o valor B: ");
        double b = teclado.nextDouble();
        
        // O motor da c4rvmath processa os parâmetros limpos instantaneamente
        double resultado = MathUtils.calcular(a, op, b);
        
        System.out.println("\n[c4rvmath] Resultado: " + resultado);
        teclado.close();
    }
}
```

## Como Contribuir e Evoluir o Projeto

A c4rvmath é um projeto de código aberto e incentiva a evolução contínua da comunidade. Para adicionar novos operadores (como multiplicação e divisão) ou funções avançadas (raízes, potências), siga o fluxo padrão:

1. Realize um Fork deste repositório.
2. Crie uma branch para a sua funcionalidade (git checkout -b feature/NovaOperacao).
3. Desenvolva as otimizações na sua classe de forma isolada e estática.
4. Abra um Pull Request detalhando as melhorias aplicadas para revisão.

---
:)
