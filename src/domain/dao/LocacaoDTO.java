package domain.dao;

import java.time.LocalDateTime;

public record LocacaoDTO (String id, String idCliente, String idVeiculo, LocalDateTime data) {
    
}
