package by.intexsoft.importexport.service.impl;

import by.intexsoft.importexport.pojo.Mms;
import by.intexsoft.importexport.pojo.TypeEvent;
import by.intexsoft.importexport.repositories.MmsRepository;
import by.intexsoft.importexport.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IMmsService implements EventService<Mms> {
    private final MmsRepository mmsRepository;

    @Override
    public List<Mms> getAll() {
        return mmsRepository.findAll();
    }

    @Override
    public void save(List list) {
        System.out.println("mms " + list);
    }

    @Override
    public TypeEvent getType() {
        return TypeEvent.Mms;
    }
}
