//package com.eurodyn.controller.people;
//
//import com.eurodyn.dto.ResponseApi;
//import com.eurodyn.model.people.Producer;
//import com.eurodyn.service.people.ProducerService;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@AllArgsConstructor
//@RequestMapping("/producer")
//public class ProducerController {
//    private final ProducerService producerService;
//
//    @PostMapping("/create")
//    public Producer createProducer(@RequestBody Producer producer) {
//
//        return producerService.create(producer);
//    }
//
//    @GetMapping()
//    public ResponseApi<List<Producer>> readProducer() {
//        ResponseApi<List<Producer>> producer =  new ResponseApi<>();
//        producer.setData(producerService.read());
//
//        return producer;
//    }
//
//    @GetMapping("/{producerId}")
//    public ResponseApi<Producer>  getProducer(@PathVariable long producerId) {
//        ResponseApi<Producer> producer =  new ResponseApi<>();
//        producer.setData(producerService.read(producerId));
//        return producer;
//    }
//
//    @PutMapping("/{producerId}")
//    public ResponseApi<Producer> updateProducer(@PathVariable long producerId, @RequestBody Producer newProducer) {
//        ResponseApi<Producer> producer =  new ResponseApi<>();
//        producer.setData(producerService.update(producerId, newProducer));
//        return producer;
//    }
//
//
//    @DeleteMapping("/{producerId}")
//    public ResponseApi<Producer> deleteProducer(@PathVariable long producerId) {
//        ResponseApi<Producer> producer =  new ResponseApi<>();
//        producer.setData(producerService.delete(producerId));
//        return producer;
//    }
//
//
//}
