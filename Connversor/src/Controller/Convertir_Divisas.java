package Controller;

import Clases.Moneda;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Convertir_Divisas {
    public static Moneda[] monedas = Moneda.values();
    public static BigDecimal[][] values_monedas = {{new BigDecimal(1), new BigDecimal(0.13), new BigDecimal(0.12), new BigDecimal(0.10), new BigDecimal(17.69), new BigDecimal(169.87)}
            , {new BigDecimal(7.81), new BigDecimal(1), new BigDecimal(0.92), new BigDecimal(0.80), new BigDecimal(137.96), new BigDecimal(1325.20)}
            , {new BigDecimal(8.45), new BigDecimal(1.08), new BigDecimal(1), new BigDecimal(0.87), new BigDecimal(149.33), new BigDecimal(1434.20)}
            , {new BigDecimal(9.72), new BigDecimal(1.24), new BigDecimal(1.15), new BigDecimal(1), new BigDecimal(171.77), new BigDecimal(1649.42)}
            , {new BigDecimal(0.057), new BigDecimal(0.0072), new BigDecimal(0.0067), new BigDecimal(0.0058), new BigDecimal(1), new BigDecimal(9.61)}
            , {new BigDecimal(0.0059), new BigDecimal(0.00075), new BigDecimal(0.00070), new BigDecimal(0.0000061), new BigDecimal(0.10), new BigDecimal(1)}
    };

    public BigDecimal Conversion_Monedas(BigDecimal cantidad, Moneda moneda_presente, Moneda moneda_a_convertir){
        for(int i= 0; i< monedas.length; i++){
            for(int j= 0; j< monedas.length; j++){
                if(moneda_presente == monedas[i] && moneda_a_convertir == monedas[j]){
                    return cantidad.multiply(values_monedas[i][j]).setScale(2, RoundingMode.HALF_UP);
                }
            }
        }
        return BigDecimal.ZERO;
    }
}
