package com.eurodyn.service.people;

import com.eurodyn.model.people.Director;
import com.eurodyn.model.people.Producer;
import com.eurodyn.repository.DirectorRepository;
import com.eurodyn.repository.ProducerRepository;
import com.eurodyn.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {
    private final ProducerRepository producerRepository;

    @Override
    public Producer create(Producer producer) {
        return producerRepository.save(producer);

    }

    @Override
    public List<Producer> read() {
        return producerRepository.findAll();
    }

    @Override
    public Producer read(Long producerId) {
        Optional<Producer> producer = producerRepository.findById(producerId);
        if(producer.isEmpty()){
            return null;
        }
        return producer.get();
    }

    @Override
    public Producer update(Long producerId, Producer newProducer) {
        Optional<Producer> producer = producerRepository.findById(producerId);
        if (producer.isEmpty()) {
            return null;
        }
        Producer currentProducer = producer.get();
        newProducer.setId(currentProducer.getId());
        return producerRepository.save(newProducer);
    }

    @Override
    public Producer delete(Long producerId) {
        Optional<Producer> producer = producerRepository.findById(producerId);
        if (producer.isEmpty()) {
            return null;
        }
        producerRepository.delete(producer.get());
        return producer.get();
    }
    }
}
