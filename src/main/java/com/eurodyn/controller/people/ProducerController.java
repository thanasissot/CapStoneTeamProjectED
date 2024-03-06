package com.eurodyn.controller.people;

import com.eurodyn.model.people.Producer;
import com.eurodyn.service.people.ProducerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/producer")
public class ProducerController {
    private final ProducerService producerService;

    @PostMapping("/create")
    public Producer createProducer(@RequestBody Producer producer) {

        return producerService.create(producer);
    }

    @GetMapping()
    public List<Producer> readProducer() {
        return producerService.read();
    }

    @GetMapping("/{producerId}")
    public Producer getProducer(@PathVariable long producerId) {
        return producerService.read(producerId);
    }

    @PutMapping("/{producerId}")
    public Producer updateProducer(@PathVariable long producerId, @RequestBody Producer newProducer) {
        return producerService.update(producerId, newProducer);
    }

    //    boolean deleteCustomer(int customerId);
    @DeleteMapping("/{producerId}")
    public Producer deleteProducer(@PathVariable long producerId) {
        return producerService.delete(producerId);
    }


}
