# Documentação: Métodos e Propriedades

Este arquivo descreve, em detalhes, cada classe, campos (propriedades), construtores e métodos das classes presentes em `Observer/anti-pattern/src`.

---

**GenshinPromocode**: classe simples que representa um objeto relacionado a um "promocode" (código promocional) para Genshin.

- **Arquivo**: `GenshinPromocode.java`
- **Campos (propriedades)**:
  - `private Roles role` : instância de `Roles` associada ao promocode. Representa o papel ou categoria da notificação.
  - `private List<UserWithRole> users` : lista de usuários associados; inicializada como `new ArrayList<>()`. Atualmente não é populada por nenhum método nesta classe (uso futuro possível).

- **Construtor**:
  - `public GenshinPromocode(Roles role)`
    - Parâmetro: `role` — objeto `Roles` inicial para este promocode.
    - Efeito: atribui `this.role = role`.

- **Métodos**:
  - `public void update(Roles role)`
    - Parâmetros: `role` — novo objeto `Roles` recebido para atualizar o estado.
    - Retorno: `void`.
    - Efeito colateral: atualiza o campo `this.role` e imprime no console uma mensagem: `You were mentioned for this role: <role.getName()>|<role.getMessage()>`.
    - Observações: comportamento simples de notificação; não usa a lista `users` para propagar a notificação.

  - `public Roles getRole()`
    - Retorno: `Roles` — retorna a referência atual em `role`.

  - `public void setRole(Roles role)`
    - Parâmetros: `role` — novo objeto `Roles` para substituir o atual.
    - Efeito: atribui `this.role = role`.

---

**Main (anti-pattern)**: classe com o método `main` para execução e demonstração do fluxo.

- **Arquivo**: `Main.java`
- **Método principal**:
  - `public static void main(String[] args)`
    - Parâmetros: `args` — argumentos de linha de comando (não utilizados).
    - Efeito: imprime `Hello and welcome!` e demonstra a criação de objetos `Roles`, `UserWithRole` e `SteamPromocode`.
    - Comportamento observado:
      - Cria `Roles steamPromocode = new Roles("PromotionCodes", "A new code for Steam has appear");`
      - Cria `UserWithRole dkaii = new UserWithRole(steamPromocode);` (o usuário é criado com um papel, mas a classe `UserWithRole` não registra esse usuário em nenhuma lista central)
      - Cria `SteamPromocode newSteamPromocode = new SteamPromocode(steamPromocode);`
      - Chama `newSteamPromocode.update(steamPromocode);` que imprime a mensagem de notificação (implementação de `SteamPromocode.update`).

---

**Roles**: classe que modela um papel (role) com nome e mensagem associada.

- **Arquivo**: `Roles.java`
- **Campos (propriedades)**:
  - `private String name` : nome do role.
  - `private String message` : mensagem associada ao role.

- **Construtor**:
  - `public Roles(String name, String role)`
    - Parâmetros: `name` e `role` (o segundo parâmetro deveria representar a mensagem), porém existe um erro na implementação atual: o construtor recebe `String role` mas atribui `this.message = message;` (usa a variável `message` não definida no escopo), portanto a `message` do objeto fica como `null` e o parâmetro `role` é ignorado.
    - Efeito esperado (correto): `this.name = name; this.message = role;` (ou renomear o parâmetro para `message`).

- **Métodos**:
  - `public String getName()` — retorna `name`.
  - `public void setName(String name)` — define `name`.
  - `public String getMessage()` — retorna `message`.
  - `public void setMessage(String message)` — define `message`.

  - `public void update(Roles role)`
    - Parâmetros: `role` — objeto `Roles` usado apenas para leitura.
    - Retorno: `void`.
    - Efeito: imprime no console: `You were mentioned for this role: <role.getName()>|<role.getMessage()>`.
    - Observações: este método parece duplicar a responsabilidade de imprimir notificações presente em outras classes (`SteamPromocode`, `GenshinPromocode`). Em um padrão Observer, `Roles` normalmente seria o sujeito (subject) e notificaria os observadores, em vez de possuir o método `update` que imprime diretamente.

  - **Bug/Nota Importante**: conserte o construtor para armazenar corretamente a `message`. Sem correção, chamadas a `getMessage()` retornam `null`.

---

**SteamPromocode**: outra classe que modela um promocode (para Steam). Similar a `GenshinPromocode`.

- **Arquivo**: `SteamPromocode.java`
- **Campos (propriedades)**:
  - `private Roles role` : papel associado ao promocode.
  - `private String message` : mensagem (campo local) — quando alterado, chama `notifyUsers()`.
  - `private List<UserWithRole> users` : lista de `UserWithRole` que deveriam receber notificações. A lista é inicializada mas não há métodos públicos para adicionar/remover usuários nela atualmente.

- **Construtor**:
  - `public SteamPromocode(Roles role)` — inicializa `this.role = role`.

- **Métodos**:
  - `public void update(Roles role)`
    - Parâmetros: `role` — objeto `Roles` com as informações atualizadas.
    - Efeito: atualiza `this.role = role` e imprime no console: `You were mentioned for this role: <role.getName()>|<role.getMessage()>`.

  - `public void notifyUsers()`
    - Parâmetros: nenhum.
    - Efeito: itera sobre a lista `users` e chama `user.update(getRole())` para cada `UserWithRole`.
    - Observações: para que essa notificação tenha efeito é necessário que `users` contenha instâncias, mas não existe código no repositório atual que adicione usuários a essa lista. Além disso, o método `UserWithRole.update` está vazio (não implementado), então mesmo que `users` estivesse populada não haveria ação útil.

  - `public String getMessage()` — retorna `message`.
  - `public void setMessage(String message)` — define `message` e chama `notifyUsers()` logo em seguida.
  - `public Roles getRole()` — retorna `role`.
  - `public void setRole(Roles role)` — define `role`.

  - **Nota de design**: o fluxo pretende seguir o padrão Observer (sujeito notifica observadores), mas faltam métodos para registrar observadores (`addUser` / `removeUser`) e a implementação de `UserWithRole.update`. Sem esses elementos o mecanismo de notificação não está completo.

---

**UserWithRole**: representa um usuário que possui um `Roles` associado.

- **Arquivo**: `UserWithRole.java`
- **Campos (propriedades)**:
  - `private String name` — nome do usuário (padrão `null` até ser setado).
  - `private Roles role` — role associado ao usuário, inicializado via construtor.

- **Construtor**:
  - `public UserWithRole(Roles role)`
    - Parâmetros: `role` — atribuído a `this.role`.

- **Métodos**:
  - `public void update(Roles roles)`
    - Parâmetros: `roles` — objeto `Roles` recebido quando uma notificação é acionada.
    - Retorno: `void`.
    - Efeito atual: o método está vazio — não faz nada.
    - Efeito esperado: no padrão Observer, deveria reagir à notificação (por exemplo, imprimir uma mensagem, alterar estado interno, enviar alerta, etc.).

  - `public String getName()` — retorna `name`.
  - `public void setName(String name)` — define `name`.
  - `public Roles getRole()` — retorna `role`.

  - **Nota**: para completar o padrão Observer, implemente `update` para processar a notificação e adicione métodos em `SteamPromocode` e/ou `GenshinPromocode` para registrar `UserWithRole` na lista `users`.

---

**Resumo e recomendações rápidas**

- `Roles` possui um bug no construtor — corrija a atribuição para armazenar `message` corretamente.
- Para implementar o padrão Observer corretamente, adicione:
  - Em `SteamPromocode`/`GenshinPromocode`: métodos `addUser(UserWithRole u)` e `removeUser(UserWithRole u)` que manipulem `users`.
  - Em `UserWithRole`: implementar `update(Roles roles)` para exibir mensagens apropriadas.
  - Alternativamente, centralizar notificação em `Roles` como `subject` que mantém a lista de observadores.

- Observações de segurança/robustez: valide `null` antes de usar `role.getName()` / `role.getMessage()` para evitar `NullPointerException` se essas propriedades não forem inicializadas corretamente.

---

Se desejar, eu posso:
- 1) abrir um patch para corrigir o construtor de `Roles`;
- 2) implementar `addUser`/`removeUser` em `SteamPromocode` e `GenshinPromocode`;
- 3) implementar `UserWithRole.update` para exibir mensagens apropriadas.

Indique qual (ou quais) ações quer que eu execute a seguir.
