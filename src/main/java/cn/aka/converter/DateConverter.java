package cn.aka.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    private String dateFormate;

    public DateConverter(String dateFormate) {
        this.dateFormate = dateFormate;
    }

    public Date convert(String s) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormate);
        try {
            Date date = format.parse(s);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
