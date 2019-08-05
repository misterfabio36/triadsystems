# triadsystems

O projeto foi criado para rodar em Java 8 com SpringBoot 2.1.6. Ele pode ser executado a partir de qualquer IDE, ou, utilizar o Maven package para criar um executário "jar" para rodar sem a necessiade de uma IDE.

# Alguns pontos importantes do projeto:

**Neste arquivo (https://github.com/misterfabio36/triadsystems/blob/master/src/main/resources/data.sql) tem o script criado para o projeto, foi utilizado o h2-database para isto. OBS.: criará um arquivo no temp da máquina.**

**Neste arquivo (https://github.com/misterfabio36/triadsystems/blob/master/src/main/resources/application.properties) temos o nome e as credendenciais de acesso ao banco que será criado pelo h2-database, ú util para os testes.**

**No projeto esta disponível o Swagger2 (http://localhost:8080/BotApi/swagger-ui.html), nele é possível visualizar todos os endpoints disponíveis na Api.**

**No projeto esta disponível a UI do h2-database na url: http://localhost:8080/BotApi/h2-console. (Usuário: userTest / Senha: password)**

Criar Bot
POST: http://localhost:8080/BotApi/bots
JSON: {"name": "string"}

Atualizar Bot
PUT: http://localhost:8080/BotApi/bots
JSON: {"id": "string", "name": "string"}

Apagar Bot
DELETE: http://localhost:8080/BotApi/bots/#idToDelete#

Buscar Bot
GET: http://localhost:8080/BotApi/bots/#idToFind#

Listar as Mensagens de uma Conversa
GET: http://localhost:8080/BotApi/messages?conversationId=conversationId

Enviar uma Mensagem
POST: http://localhost:8080/BotApi/messages
JSON: {"from": "string", "text": "string", "to": "string"}

Buscar uma Mensagem
GET: http://localhost:8080/BotApi/messages/#idToFind#

OBS.: Não tive tempo de criar nada de pudesse auxiliar nos testes automáticos, mas acredito que o Banco de Dados e o swagger irão auxiliar nos mesmos.

Estou disponível para tirar as dúvidas que surgirem,

Att
Fabio Ramos
