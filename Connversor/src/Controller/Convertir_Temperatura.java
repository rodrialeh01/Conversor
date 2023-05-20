package Controller;

import Clases.Temperatura;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Convertir_Temperatura {
    public BigDecimal Conversion_Temperatura(BigDecimal valor, Temperatura temperatura_actual, Temperatura temperatura_a_convertir){
        if(temperatura_actual == temperatura_a_convertir){
            return valor;
        }
        if(temperatura_actual == Temperatura.CELSIUS){
            if(temperatura_a_convertir == Temperatura.KELVIN){
                return this.Celsius_a_Kelvin(valor).setScale(2, RoundingMode.HALF_UP);
            } else if (temperatura_a_convertir == Temperatura.FARENHEIT) {
                return this.Celsius_a_Farenheit(valor).setScale(2, RoundingMode.HALF_UP);
            }
        }
        if(temperatura_actual == Temperatura.FARENHEIT){
            if(temperatura_a_convertir == Temperatura.KELVIN){
                return this.Farenheit_a_Kelvin(valor).setScale(2, RoundingMode.HALF_UP);
            } else if (temperatura_a_convertir == Temperatura.CELSIUS) {
                return this.Farenheit_a_Celsius(valor).setScale(2, RoundingMode.HALF_UP);
            }
        }
        if(temperatura_actual == Temperatura.KELVIN){
            if(temperatura_a_convertir == Temperatura.CELSIUS){
                return this.Kelvin_a_Celsius(valor).setScale(2, RoundingMode.HALF_UP);
            } else if (temperatura_a_convertir == Temperatura.FARENHEIT) {
                return this.Kelvin_a_Farenheit(valor).setScale(2, RoundingMode.HALF_UP);
            }
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal Celsius_a_Farenheit(BigDecimal valor){
        return (valor.multiply(new BigDecimal(9)).divide(new BigDecimal(5), 2, RoundingMode.HALF_UP)).add(new BigDecimal(32));

    }

    private BigDecimal Farenheit_a_Celsius(BigDecimal valor){
        return (valor.subtract(new BigDecimal(32))).multiply(new BigDecimal(5).divide(new BigDecimal(9), 2, RoundingMode.HALF_UP));
    }

    private BigDecimal Celsius_a_Kelvin(BigDecimal valor){
        return valor.add(new BigDecimal(273.15));
    }

    private BigDecimal Kelvin_a_Celsius(BigDecimal valor){
        return valor.subtract(new BigDecimal(273.15));
    }

    private BigDecimal Farenheit_a_Kelvin(BigDecimal valor){
        return (this.Farenheit_a_Celsius(valor)).add(new BigDecimal(273.15));
    }

    private BigDecimal Kelvin_a_Farenheit(BigDecimal valor){
        return this.Celsius_a_Farenheit(valor.subtract(new BigDecimal(273.15)));
    }
}
