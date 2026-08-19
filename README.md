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
## Como usar a c4rvmath no seu projeto

Para começar a usar as funções matemáticas da biblioteca, você precisa baixar o arquivo .jar e adicioná-lo às dependências do seu projeto.

### Pré-requisito
* Java JDK 17 ou superior instalado na máquina.

---

### Passo 1: Baixar o arquivo
Acesse a página da versão estável no link abaixo, vá até a seção Assets no final da página e faça o download do arquivo c4rvmath.jar:

https://github.com/YuriC4rv/c4rvmath/releases/tag/v1.0.0

---

### Passo 2: Configurar na sua IDE

Siga as instruções abaixo de acordo com o ambiente de desenvolvimento que você utiliza:

#### No Eclipse
1. Na barra lateral (Package Explorer), clique com o botão direito no seu projeto e selecione Properties.
2. No menu esquerdo, selecione Java Build Path.
3. Clique na aba Libraries na parte superior da janela.
4. Clique na opção Classpath para selecioná-la.
5. No lado direito, clique em Add External JARs... e selecione o arquivo c4rvmath.jar que foi baixado.
6. Clique em Apply and Close para salvar.

#### No VS Code
1. Na barra lateral esquerda, navegue até a aba Java Projects.
2. Localize a seção Referenced Libraries.
3. Clique no botão de + (Plus) que aparece ao passar o ponteiro do mouse sobre ela.
4. Selecione o arquivo c4rvmath.jar no seu computador.

#### No IntelliJ IDEA
1. Abra as configurações do projeto em File > Project Structure.
2. No menu esquerdo, clique em Modules e mude para a aba Dependencies.
3. Clique no botão de + do lado direito e escolha JARs or Directories...
4. Selecione o arquivo c4rvmath.jar e clique em Apply.

---

### Passo 3: Executar via Linha de Comando (Sem IDE)
Se você compila e executa seus programas manualmente pelo terminal, inclua o arquivo JAR utilizando o parâmetro de classpath (-cp):

No Linux ou Mac:
```bash
# Para compilar
javac -cp ".:c4rvmath.jar" Main.java

# Para rodar
java -cp ".:c4rvmath.jar" Main
```

No Windows:
```cmd
# Para compilar
javac -cp ".;c4rvmath.jar" Main.java

# Para rodar
java -cp ".;c4rvmath.jar" Main
```
(Para saber todos os cálculos disponíveis, use MathUtils.exibirManual();
