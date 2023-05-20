package Controller;

import Clases.Longitud;
import Clases.Moneda;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Convertir_Longitud {
    public static Longitud[] longitudes = Longitud.values();
    public static BigDecimal[][] unidades_longitud = {
            {new BigDecimal(1),new BigDecimal(1000),new BigDecimal(0.621371),new BigDecimal(1093.61), new BigDecimal(3280.84), new BigDecimal(39370.1)},
            {new BigDecimal(0.001),new BigDecimal(1),new BigDecimal(0.000621371),new BigDecimal(1.09361), new BigDecimal(3.28084), new BigDecimal(39.3701)},
            {new BigDecimal(1.60934),new BigDecimal(1609.34),new BigDecimal(1),new BigDecimal(1760), new BigDecimal(5280), new BigDecimal(63360)},
            {new BigDecimal(0.00009144),new BigDecimal(0.9144),new BigDecimal(0.000568182),new BigDecimal(1), new BigDecimal(3), new BigDecimal(36)},
            {new BigDecimal(0.0003048),new BigDecimal(0.3048),new BigDecimal(0.000189394),new BigDecimal(0.3333333), new BigDecimal(1), new BigDecimal(12)},
            {new BigDecimal(0.0000254),new BigDecimal(0.0254),new BigDecimal(0.000015783),new BigDecimal(0.0277778), new BigDecimal(0.083333333), new BigDecimal(1)}
    };

    public BigDecimal Conversion_Longitud(BigDecimal cantidad, Longitud unidad_presente, Longitud unidad_a_convertir){
        for(int i= 0; i< longitudes.length; i++){
            for(int j= 0; j< longitudes.length; j++){
                if(unidad_presente == longitudes[i] && unidad_a_convertir == longitudes[j]){
                    return cantidad.multiply(unidades_longitud[i][j]).setScale(5, RoundingMode.HALF_UP);
                }
            }
        }
        return BigDecimal.ZERO;
    }
}
