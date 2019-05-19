package net.mlike.chenhui.one.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;

public class JSON
{
    public static String toJSON(Object obj)
    {
        try
        {
            return
                    new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE).configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false).setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(obj);
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        return obj.toString();
    }

    public static Object fromJSON(String str)
    {
        try
        {
            return

                    new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false).readTree(str);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
