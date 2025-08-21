# Observer Pattern Implementation in Java

Este projeto implementa o padrão de projeto Observer para gerenciar usuários com roles e notificações, conforme representado no diagrama UML fornecido.

## Estrutura do Projeto

### Componentes Principais

1. **Subject (Assunto)**: `Roles`
   - Mantém uma lista de observadores (`usersWithRole`)
   - Fornece métodos para adicionar/remover observadores
   - Notifica observadores quando ocorre uma mudança de estado

2. **Observers (Observadores)**:
   - Interface: `UserWithRole`
   - Implementação concreta: `UsersAllowMention`

### Fluxo de Operação

1. **Registro de Observadores**: 
   - Objetos `UsersAllowMention` registram-se no subject `Roles` usando `addRole()`

2. **Notificação**:
   - Quando `mentionUsersWithRole()` é invocado, todos os observadores registrados são notificados
   - Cada observador executa sua implementação específica do método `update()`

3. **Gerenciamento de Observadores**:
   - Observadores podem ser dinamicamente adicionados/removidos durante a execução

---
### Vantagens do Padrão Observer

- **Acoplamento fraco**: Subject e Observadores não precisam conhecer detalhes de implementação uns dos outros
- **Extensibilidade**: Novos observadores podem ser adicionados sem modificar o subject
- **Comunicação eficiente**: Notificações são propagadas automaticamente para todos os observadores registrados

### Casos de Uso

Este padrão é particularmente útil para:
- Sistemas de notificação em tempo real
- Implementação de publish-subscribe
- Atualizações de estado em aplicações distribuídas
- Mecanismos de event-handling

A implementação segue os princípios SOLID, particularly o Princípio de Aberto/Fechado (OCP) e o Princípio de Segregação de Interface (ISP).