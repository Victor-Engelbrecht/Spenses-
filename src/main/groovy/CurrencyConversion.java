package spending;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

@Introspected
public class CurrencyConversion{

    @JsonProperty("USD")
    private float usValue;
    @JsonProperty("ZAR")
    private float zaValue;

    CurrencyConversion(){

    }
    public float getUsValue(){
        return usValue;
    }
    public void setUsValue(float newUs){
        this.usValue = newUs;
    }

    public float getZaValue(){
        return usValue;
    }
    public void setZaValue(float newZa){
        this.zaValue = newZa;
    }
}