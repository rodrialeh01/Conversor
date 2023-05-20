package Controller;

import Clases.Longitud;
import Clases.Masa;
import Clases.Moneda;
import Clases.Temperatura;

import java.math.BigDecimal;

public class Controller {

    public Controller() {
    }

    public BigDecimal Conversor_De_Divisas(String cantidad_inicial, Moneda moneda_presente, Moneda moneda_a_convertir){
        BigDecimal cantidad_a_convertir = cantidad_inicial.isEmpty() || cantidad_inicial.equals("-") ? BigDecimal.ZERO : new BigDecimal(cantidad_inicial);
        return new Convertir_Divisas().Conversion_Monedas(cantidad_a_convertir,moneda_presente,moneda_a_convertir);
    }

    public BigDecimal Conversor_De_Temperatura(String valor_inicial, Temperatura temperatura_actual, Temperatura temperatura_a_convertir){
        BigDecimal valor_a_convertir = valor_inicial.isEmpty() || valor_inicial.equals("-")? BigDecimal.ZERO : new BigDecimal(valor_inicial);
        return new Convertir_Temperatura().Conversion_Temperatura(valor_a_convertir, temperatura_actual, temperatura_a_convertir);
    }

    public BigDecimal Conversor_De_Longitud(String valor_inicial, Longitud unidad_actual, Longitud unidad_a_convertir){
        BigDecimal valor_a_convertir = valor_inicial.isEmpty()? BigDecimal.ZERO : new BigDecimal(valor_inicial);
        return new Convertir_Longitud().Conversion_Longitud(valor_a_convertir, unidad_actual, unidad_a_convertir);
    }

    public BigDecimal Conversor_De_Masa(String valor_inicial, Masa unidad_actual, Masa unidad_a_convertir){
        BigDecimal valor_a_convertir = valor_inicial.isEmpty()? BigDecimal.ZERO : new BigDecimal(valor_inicial);
        return new Convertir_Masa().Conversion_Masa(valor_a_convertir, unidad_actual, unidad_a_convertir);
    }
}
