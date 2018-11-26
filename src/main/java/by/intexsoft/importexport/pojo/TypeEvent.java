package by.intexsoft.importexport.pojo;

import java.util.HashMap;
import java.util.Map;

public enum TypeEvent {
    Call, Mms, Sms;

    private static Map<TypeEvent, Object> typeEvents = new HashMap<TypeEvent, Object>(){{
        put(Call, new Call());
        put(Mms, new Mms());
        put(Sms, new Sms());
    }};

    public static Object getEvent(TypeEvent event){
        return typeEvents.get(event);
    }

}
