package br.bantads.gerente.rabbitmq;

import br.bantads.gerente.repository.GerenteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class GerenteConsumer {

    @RabbitListener(queues = "GERENTE")
    public void receiveMessage(String message) {
        System.out.println("Mensagem recebida: " + message);
        // A FAZER
    }





}
