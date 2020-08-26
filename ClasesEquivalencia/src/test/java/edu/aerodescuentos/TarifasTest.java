package edu.eci.cvds.tdd.aerodescuentos;

import edu.eci.cvds.tdd.aerodescuentos.CalculadorDescuentos;
import org.junit.Assert;
import org.junit.Test;

public class TarifasTest{
    private CalculadorDescuentos calculadorDescuentos = new CalculadorDescuentos();
    @Test
    public void validateTarifa(){
        long tarifabase = 2345678L;
        double valor = calculadorDescuentos.calculoTarifa(tarifabase,20,21);
        Assert.assertEquals(tarifabase, valor,0.0);
    }
    
    @Test
    public void validateAntelacion(){
        long tarifabase = 2345678L;
        double valor = calculadorDescuentos.calculoTarifa(tarifabase,30,20);
        Assert.assertEquals((tarifabase-(tarifabase*0.15)),valor,0.0);
    }
    
    @Test
    public void validateUnderAge(){
        long tarifabase = 2345678L;
        double valor = calculadorDescuentos.calculoTarifa(tarifabase,10,16);
        Assert.assertEquals((tarifabase-(tarifabase*0.05)),valor,0.0);
    }

    @Test
    public void validateOverAge(){
        long tarifabase = 2345678L;
        double valor = calculadorDescuentos.calculoTarifa(tarifabase,10,70);
        Assert.assertEquals((tarifabase-(tarifabase*0.08)),valor,0.1);
    }

    @Test
    public void validateBothUnderAge(){
        long tarifabase = 2345678L;
        double valor = calculadorDescuentos.calculoTarifa(tarifabase,30,15);
        Assert.assertEquals((tarifabase-(tarifabase*0.2)),valor,0.1);
    }

    @Test
    public void validateBothOverAge(){
        long tarifabase = 2345678L;
        double valor = calculadorDescuentos.calculoTarifa(tarifabase,30,90);
        Assert.assertEquals((tarifabase-(tarifabase*0.23)),valor,0.1);
    }


}