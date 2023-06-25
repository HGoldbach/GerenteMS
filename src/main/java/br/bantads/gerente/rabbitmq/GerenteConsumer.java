package br.bantads.gerente.rabbitmq;


import br.bantads.gerente.dto.GerenteDTO;
import br.bantads.gerente.model.Gerente;
import br.bantads.gerente.repository.GerenteRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class GerenteConsumer {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private GerenteRepository gerenteRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "GERENTE")
    public void registraNovoGerente(String msg) throws JsonMappingException, JsonProcessingException {
        var gerente = objectMapper.readValue(msg, GerenteDTO.class);

        try {
            Gerente g = new Gerente(
                    gerente.getId(),
                    gerente.getNome(),
                    gerente.getEmail(),
                    gerente.getCpf(),
                    gerente.getTelefone(),
                    gerente.getPerfil());
            Gerente novoGerente = gerenteRepository.save(g);
            System.out.println(objectMapper.writeValueAsString(novoGerente));

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
