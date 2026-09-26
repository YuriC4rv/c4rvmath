# c4rvmath

Uma biblioteca Java modular para operações matemáticas e cálculos comerciais, desenvolvida com foco em **reutilização, desacoplamento e facilidade de integração** em aplicações Java.

A C4RVMATH separa a lógica de cálculo da entrada e apresentação de dados, permitindo que suas funcionalidades sejam utilizadas em diferentes ambientes, como aplicações de console, interfaces gráficas com Swing ou JavaFX e outros sistemas desenvolvidos em Java.

---

## Funcionalidades

### `MathUtils`

O núcleo matemático da C4RVMATH fornece operações fundamentais:

* Soma
* Subtração
* Multiplicação
* Divisão
* Resto da divisão
* Potência
* Raiz quadrada
* Motor de cálculo por operador

Exemplo:

```java
import com.c4rvmath.core.MathUtils;

public class Exemplo {

    public static void main(String[] args) {

        double resultado =
                MathUtils.calcular(45.5, "+", 4.5);

        System.out.println(resultado);
    }
}
```

Resultado:

```text
50.0
```

Também é possível utilizar os métodos individualmente:

```java
double soma = MathUtils.somar(10, 5);
double subtracao = MathUtils.subtrair(10, 5);
double multiplicacao = MathUtils.multiplicar(10, 5);
double divisao = MathUtils.dividir(10, 5);
```

### `CommercialUtils`

A camada comercial fornece operações voltadas a situações comuns em sistemas comerciais e financeiros:

* Cálculo de percentuais
* Descontos
* Acréscimos
* Subtotais
* Troco
* Parcelamento
* Arredondamento
* Validação de valores e percentuais

Exemplo:

```java
import java.math.BigDecimal;

import com.c4rvmath.commercial.CommercialUtils;

public class Exemplo {

    public static void main(String[] args) {

        BigDecimal valor =
                new BigDecimal("250.00");

        BigDecimal percentual =
                new BigDecimal("10");

        BigDecimal resultado =
                CommercialUtils.aplicarDesconto(
                        valor,
                        percentual
                );

        System.out.println(resultado);
    }
}
```

Resultado:

```text
225.00
```

---

## Parcelamento

O método `calcularParcelas()` retorna uma `List<BigDecimal>` contendo cada parcela individualmente.

A biblioteca distribui eventuais diferenças de centavos causadas pelo arredondamento, preservando o valor total da operação.

Exemplo:

```java
import java.math.BigDecimal;
import java.util.List;

import com.c4rvmath.commercial.CommercialUtils;

public class Exemplo {

    public static void main(String[] args) {

        List<BigDecimal> parcelas =
                CommercialUtils.calcularParcelas(
                        new BigDecimal("100.00"),
                        3
                );

        for (BigDecimal parcela : parcelas) {
            System.out.println(parcela);
        }
    }
}
```

Resultado:

```text
33.34
33.33
33.33
```

A soma das parcelas permanece:

```text
33.34 + 33.33 + 33.33 = 100.00
```

---

## Precisão e arredondamento

A camada comercial utiliza `BigDecimal` para representar valores decimais.

O arredondamento padrão utiliza:

```java
RoundingMode.HALF_EVEN
```

A escala monetária padrão é de duas casas decimais.

Exemplo:

```java
BigDecimal resultado =
        CommercialUtils.arredondar(valor);
```

Também é possível definir manualmente a escala e o modo de arredondamento:

```java
BigDecimal resultado =
        CommercialUtils.arredondar(
                valor,
                2,
                RoundingMode.HALF_EVEN
        );
```

---

## Desacoplamento

A C4RVMATH não depende de `Scanner`, `System.in`, `System.out` ou de uma interface específica para executar seus cálculos.

A aplicação cliente é responsável por:

* Capturar os dados
* Validar entradas relacionadas à interface
* Apresentar os resultados

A C4RVMATH é responsável por:

* Executar os cálculos
* Aplicar as regras matemáticas disponíveis
* Retornar os resultados
* Informar erros por meio de exceções

A estrutura pode ser representada da seguinte forma:

```text
Aplicação
    │
    ├── Console
    ├── Swing
    ├── JavaFX
    └── Outros sistemas Java
            │
            ▼
        C4RVMATH
            │
            ├── MathUtils
            │
            └── CommercialUtils
```

A mesma biblioteca pode ser utilizada por diferentes aplicações sem alterações em sua camada de cálculo.

---

## Utilização com interface gráfica

A C4RVMATH pode ser integrada a interfaces gráficas.

Exemplo utilizando Swing:

```java
import java.math.BigDecimal;

import com.c4rvmath.commercial.CommercialUtils;

double valor =
        Double.parseDouble(txtValor.getText());

double percentual =
        Double.parseDouble(txtPercentual.getText());

BigDecimal resultado =
        CommercialUtils.aplicarDesconto(
                BigDecimal.valueOf(valor),
                BigDecimal.valueOf(percentual)
        );

lblResultado.setText(
        "R$ " + resultado
);
```

A interface captura os dados e apresenta o resultado, enquanto o cálculo permanece na biblioteca.

---

## Estrutura do projeto

```text
c4rvmath
└── com.c4rvmath
    ├── core
    │   └── MathUtils
    │
    └── commercial
        └── CommercialUtils
```

### `core`

Contém as operações matemáticas fundamentais da biblioteca.

### `commercial`

Contém funcionalidades matemáticas direcionadas a aplicações comerciais.

---

## Como usar a biblioteca

### Pré-requisito

* Java JDK 17 ou superior

### Download

A versão atual da biblioteca pode ser encontrada na página de releases:

[Releases](https://github.com/YuriC4rv/c4rvmath/releases)

Arquivo:

```text
c4rvmath-1.1.0.jar
```

---

## Adicionando o JAR ao projeto

### Eclipse

1. Clique com o botão direito no projeto.
2. Selecione **Properties**.
3. Acesse **Java Build Path**.
4. Abra a aba **Libraries**.
5. Selecione **Classpath**.
6. Clique em **Add External JARs...**.
7. Selecione `c4rvmath-1.1.0.jar`.
8. Clique em **Apply and Close**.

### VS Code

1. Abra a seção **Java Projects**.
2. Localize **Referenced Libraries**.
3. Clique em **+**.
4. Selecione `c4rvmath-1.1.0.jar`.

### IntelliJ IDEA

1. Acesse **File → Project Structure**.
2. Abra **Modules → Dependencies**.
3. Clique em **+**.
4. Selecione **JARs or Directories...**.
5. Escolha `c4rvmath-1.1.0.jar`.
6. Clique em **Apply**.

---

## Utilização via linha de comando

### Linux / macOS

```bash
javac -cp ".:c4rvmath-1.1.0.jar" Main.java
java -cp ".:c4rvmath-1.1.0.jar" Main
```

### Windows

```cmd
javac -cp ".;c4rvmath-1.1.0.jar" Main.java
java -cp ".;c4rvmath-1.1.0.jar" Main
```

---

## Exemplo completo

```java
import java.math.BigDecimal;

import com.c4rvmath.commercial.CommercialUtils;

public class Exemplo {

    public static void main(String[] args) {

        BigDecimal valor =
                new BigDecimal("500.00");

        BigDecimal percentual =
                new BigDecimal("15");

        BigDecimal resultado =
                CommercialUtils.aplicarDesconto(
                        valor,
                        percentual
                );

        System.out.println(
                "Valor final: R$ " + resultado
        );
    }
}
```

Resultado:

```text
Valor final: R$ 425.00
```

---

## Objetivo do projeto

A C4RVMATH busca fornecer uma biblioteca Java **modular, reutilizável e independente da camada de apresentação**, permitindo que operações matemáticas sejam incorporadas a diferentes aplicações.

A evolução do projeto está direcionada à ampliação gradual de suas funcionalidades e à avaliação de sua utilização em aplicações reais, especialmente em cenários que envolvam cálculos comerciais e financeiros.

---

## Como contribuir

A C4RVMATH é um projeto aberto à evolução e colaboração.

1. Faça um **Fork** deste repositório.
2. Crie uma branch para sua funcionalidade.
3. Desenvolva e teste as alterações.
4. Abra um **Pull Request** descrevendo as modificações realizadas.

---

## Licença

Consulte o arquivo de licença deste repositório para informações sobre uso, modificação e distribuição da C4RVMATH.
