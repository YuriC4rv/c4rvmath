package com.c4rvmath.commercial;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public final class CommercialUtils {

    private static final int ESCALA_MONETARIA = 2;

    private static final RoundingMode ARREDONDAMENTO_PADRAO =
            RoundingMode.HALF_EVEN;

    private CommercialUtils() {
        // Impede a instanciação
    }

    public static BigDecimal calcularPercentual(
            BigDecimal valor,
            BigDecimal percentual) {

        validarValor(valor);
        validarPercentual(percentual);

        return valor
                .multiply(percentual)
                .divide(
                        BigDecimal.valueOf(100),
                        ESCALA_MONETARIA,
                        ARREDONDAMENTO_PADRAO
                );
    }

    public static BigDecimal calcularDesconto(
            BigDecimal valor,
            BigDecimal percentual) {

        return calcularPercentual(valor, percentual);
    }

    public static BigDecimal aplicarDesconto(
            BigDecimal valor,
            BigDecimal percentual) {

        validarValor(valor);
        validarPercentual(percentual);

        BigDecimal desconto =
                calcularDesconto(valor, percentual);

        return arredondar(valor.subtract(desconto));
    }

    public static BigDecimal calcularAcrescimo(
            BigDecimal valor,
            BigDecimal percentual) {

        return calcularPercentual(valor, percentual);
    }

    public static BigDecimal aplicarAcrescimo(
            BigDecimal valor,
            BigDecimal percentual) {

        validarValor(valor);
        validarPercentual(percentual);

        BigDecimal acrescimo =
                calcularAcrescimo(valor, percentual);

        return arredondar(valor.add(acrescimo));
    }

    public static BigDecimal calcularSubtotal(
            BigDecimal preco,
            BigDecimal quantidade) {

        validarValor(preco);
        validarValor(quantidade);

        if (quantidade.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "A quantidade não pode ser negativa."
            );
        }

        return arredondar(preco.multiply(quantidade));
    }

    public static BigDecimal calcularTroco(
            BigDecimal valorPago,
            BigDecimal valorTotal) {

        validarValor(valorPago);
        validarValor(valorTotal);

        if (valorPago.compareTo(valorTotal) < 0) {
            throw new IllegalArgumentException(
                    "O valor pago é menor que o valor total."
            );
        }

        return arredondar(valorPago.subtract(valorTotal));
    }

    public static List<BigDecimal> calcularParcelas(
            BigDecimal valor,
            int quantidadeParcelas) {

        validarValor(valor);

        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "O valor não pode ser negativo."
            );
        }

        if (quantidadeParcelas <= 0) {
            throw new IllegalArgumentException(
                    "A quantidade de parcelas deve ser maior que zero."
            );
        }

        BigDecimal valorArredondado = arredondar(valor);

        BigInteger totalCentavos = valorArredondado
                .movePointRight(ESCALA_MONETARIA)
                .toBigIntegerExact();

        BigInteger[] divisao = totalCentavos.divideAndRemainder(
                BigInteger.valueOf(quantidadeParcelas)
        );

        BigDecimal parcelaBase = new BigDecimal(
                divisao[0],
                ESCALA_MONETARIA
        );

        int centavosRestantes = divisao[1].intValueExact();

        List<BigDecimal> parcelas =
                new ArrayList<>(quantidadeParcelas);

        for (int i = 0; i < quantidadeParcelas; i++) {

            BigDecimal parcela = parcelaBase;

            if (i < centavosRestantes) {
                parcela = parcela.add(
                        BigDecimal.valueOf(0.01)
                );
            }

            parcelas.add(parcela);
        }

        return parcelas;
    }

    public static BigDecimal arredondar(BigDecimal valor) {

        validarValor(valor);

        return valor.setScale(
                ESCALA_MONETARIA,
                ARREDONDAMENTO_PADRAO
        );
    }

    public static BigDecimal arredondar(
            BigDecimal valor,
            int escala,
            RoundingMode modo) {

        validarValor(valor);

        if (escala < 0) {
            throw new IllegalArgumentException(
                    "A escala não pode ser negativa."
            );
        }

        if (modo == null) {
            throw new IllegalArgumentException(
                    "O modo de arredondamento não pode ser nulo."
            );
        }

        return valor.setScale(escala, modo);
    }

    private static void validarValor(BigDecimal valor) {

        if (valor == null) {
            throw new IllegalArgumentException(
                    "O valor não pode ser nulo."
            );
        }
    }

    private static void validarPercentual(
            BigDecimal percentual) {

        if (percentual == null) {
            throw new IllegalArgumentException(
                    "O percentual não pode ser nulo."
            );
        }

        if (percentual.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "O percentual não pode ser negativo."
            );
        }
    }
}