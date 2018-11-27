package by.intexsoft.importexport.service.impl;

import by.intexsoft.importexport.pojo.Call;
import by.intexsoft.importexport.pojo.TypeEvent;
import by.intexsoft.importexport.repositories.CallRepository;
import by.intexsoft.importexport.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ICallService implements EventService<Call> {
    private final CallRepository callRepository;

    @Override
    public List<Call> getAll() {
        return callRepository.findAll();
    }

    @Override
    public void save(List list) {
        System.out.println("call " + list);
//        callRepository.saveAll(list);
    }

    @Override
    public TypeEvent getType() {
        return TypeEvent.Call;
    }
}
