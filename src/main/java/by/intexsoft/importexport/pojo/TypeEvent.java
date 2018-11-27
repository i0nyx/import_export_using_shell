package by.intexsoft.importexport.pojo;

import java.util.HashMap;
import java.util.Map;

public enum TypeEvent {
    Call, Mms, Sms;

    private static Map<TypeEvent, Event> typeEvents = new HashMap<TypeEvent, Event>(){{
        put(Call, new Call());
        put(Mms, new Mms());
        put(Sms, new Sms());
    }};

    public static Event getEvent(TypeEvent event){
        return typeEvents.get(event);
    }

}
