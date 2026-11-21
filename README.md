# Sistema de Controle de Clientes e Agenda — Lava Rápido

Aplicação desktop em Java Swing, organizada no padrão MVC.

## Requisitos
- JDK 17 ou superior
- Maven 3.8 ou superior (ou abrir como projeto Maven no NetBeans)

## Como executar no NetBeans
1. Extraia o arquivo ZIP.
2. No NetBeans, escolha **File > Open Project**.
3. Selecione a pasta `SistemaLavaRapido` que contém o `pom.xml`.
4. Aguarde o Maven carregar o projeto.
5. Execute a classe `com.lavarapido.Principal`.

## Funcionalidades
- Cadastro, edição, exclusão e listagem de clientes.
- Cadastro, edição, exclusão e listagem de veículos.
- Um cliente pode ter vários veículos cadastrados; a placa pertence à classe `Veiculo`, não à classe `Cliente`.
- Cadastro, edição, exclusão e listagem de tipos de serviço.
- Agendamento, edição e cancelamento de serviços para um veículo específico.
- Consulta da agenda por dia, por semana ou completa.
- Validação de CPF, telefone, e-mail e placa; bloqueio de placas duplicadas.
- Bloqueio de dois agendamentos ativos no mesmo dia e horário.
- Não permite excluir cliente com veículos vinculados nem veículo com agendamento ativo.

## Organização
- `model`: entidades `Cliente`, `Veiculo`, `TipoServico`, `Agendamento` e `StatusAgendamento`.
- `view`: telas Java Swing.
- `controller`: eventos e comunicação entre View e Service.
- `service`: regras de negócio e armazenamento em memória.
- `diagramas`: diagramas UML em PlantUML e Mermaid.

## Relacionamento Cliente e Veículo
O relacionamento é de um para muitos (1:N): um cliente pode estar associado a vários veículos, enquanto cada veículo pertence a um único cliente. A classe `Veiculo` possui o atributo `placaVeiculo`.

## Observação sobre os dados
A atividade permite persistência em memória. Os cadastros ficam em `ArrayList` enquanto a aplicação está aberta e são apagados quando ela é encerrada. Não há conexão com banco de dados.
