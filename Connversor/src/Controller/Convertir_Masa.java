package Controller;

import Clases.Masa;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Convertir_Masa {
    public static Masa[] masas = Masa.values();
    public static BigDecimal[][] unidades_masa = {
            {new BigDecimal(1),new BigDecimal(2.20462),new BigDecimal(35.274),new BigDecimal(1000)},
            {new BigDecimal(0.453592),new BigDecimal(1),new BigDecimal(16),new BigDecimal(453.592)},
            {new BigDecimal(0.0283495),new BigDecimal(0.0625),new BigDecimal(1),new BigDecimal(28.3495)},
            {new BigDecimal(0.001),new BigDecimal(0.00220462),new BigDecimal(0.035274),new BigDecimal(1)},
    };

    public BigDecimal Conversion_Masa(BigDecimal cantidad, Masa unidad_presente, Masa unidad_a_convertir){
        for(int i= 0; i< masas.length; i++){
            for(int j= 0; j< masas.length; j++){
                if(unidad_presente == masas[i] && unidad_a_convertir == masas[j]){
                    return cantidad.multiply(unidades_masa[i][j]).setScale(5, RoundingMode.HALF_UP);
                }
            }
        }
        return BigDecimal.ZERO;
    }
}
