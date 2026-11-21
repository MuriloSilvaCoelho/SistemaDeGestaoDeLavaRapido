# Diagramas UML

Os diagramas também estão disponíveis nos arquivos `.puml` para edição no PlantUML.

## 1. Diagrama de Classes

```mermaid
classDiagram
    class Cliente {
        -int id
        -String nome
        -String cpf
        -String telefone
        -String email
    }
    class Veiculo {
        -int id
        -Cliente cliente
        -String placaVeiculo
    }
    class TipoServico {
        -int id
        -String nome
        -String descricao
        -double preco
    }
    class Agendamento {
        -int id
        -Veiculo veiculo
        -TipoServico tipoServico
        -LocalDateTime dataHora
        -StatusAgendamento status
    }
    class StatusAgendamento {
        <<enumeration>>
        AGENDADO
        CANCELADO
        CONCLUIDO
    }
    class ServicoCliente
    class ServicoVeiculo {
        +listarTodos()
        +listarPorCliente()
        +adicionar()
        +atualizar()
        +excluir()
    }
    class ServicoTipoServico
    class ServicoAgendamento
    class TelaCliente
    class TelaVeiculo
    class TelaServico
    class TelaAgenda
    class ControladorCliente
    class ControladorVeiculo
    class ControladorServico
    class ControladorAgendamento

    Cliente "1" <-- "0..*" Veiculo : proprietário
    Veiculo "1" <-- "0..*" Agendamento : recebe agendamentos
    TipoServico "1" <-- "0..*" Agendamento : selecionado
    Agendamento --> StatusAgendamento
    ControladorCliente --> TelaCliente
    ControladorCliente --> ServicoCliente
    ControladorVeiculo --> TelaVeiculo
    ControladorVeiculo --> ServicoVeiculo
    ControladorVeiculo --> ServicoCliente
    ControladorAgendamento --> TelaAgenda
    ControladorAgendamento --> ServicoAgendamento
    ControladorAgendamento --> ServicoVeiculo
    ControladorAgendamento --> ServicoTipoServico
```

**Relacionamento principal:** um cliente pode possuir vários veículos (`1:N`). Cada veículo pertence a um único cliente. Cada agendamento é feito para um veículo específico.

## 2. Diagrama de Sequência — Agendamento

```mermaid
sequenceDiagram
    actor Usuario
    participant View as TelaAgenda
    participant Controller as ControladorAgendamento
    participant Service as ServicoAgendamento
    participant Model as Agendamento

    Usuario->>View: Seleciona veículo, serviço e data/hora
    Usuario->>View: Clica em Agendar
    View->>Controller: Evento do botão
    Controller->>View: Obtém os dados preenchidos
    View-->>Controller: Veiculo, TipoServico e LocalDateTime
    Controller->>Service: agendar(veiculo, serviço, dataHora)
    Service->>Service: Valida dados e verifica conflito

    alt Horário disponível
        create participant Model
        Service->>Model: Cria Agendamento
        Service-->>Controller: Agendamento criado
        Controller->>Service: listarTodos()
        Service-->>Controller: Lista atualizada
        Controller->>View: Atualiza JTable
        View-->>Usuario: Exibe confirmação
    else Horário ocupado ou dados inválidos
        Service-->>Controller: Erro de validação
        Controller->>View: Exibe mensagem de erro
        View-->>Usuario: Solicita correção
    end
```
