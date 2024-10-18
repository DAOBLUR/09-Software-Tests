package pe.com.empresa.gestionIntencion.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToNullConverter implements Converter<String, String> {

    @Override
    public String convert(String source) {
        return (source.equalsIgnoreCase("null") || source.trim().isEmpty()) ? null : source;
    }
}