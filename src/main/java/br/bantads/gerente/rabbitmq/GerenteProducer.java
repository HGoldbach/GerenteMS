package br.bantads.gerente.rabbitmq;

import br.bantads.gerente.model.Gerente;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class GerenteProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/gerente")
    ResponseEntity<?> enfileirarGerente(@RequestBody Gerente g) throws JsonProcessingException {

        var json = objectMapper.writeValueAsString(g);
        rabbitTemplate.convertAndSend("GERENTE", json);
        return new ResponseEntity<>("Enfileirado: " + json, HttpStatus.OK);
    }
}
