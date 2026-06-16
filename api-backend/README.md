# Documentação de Engenharia de Dados: Álbum de Figurinhas 🏆

**Disciplina:** Programação para Dispositivos Móveis (FACOM32503)
**Arquitetura:** MVVM (Model-View-ViewModel)
**Fonte de Dados Remota:** REST API (JSON)

## Visão Geral do Papel
A equipe de Engenharia de Dados é responsável pela modelagem das entidades (Competition, Team, Player, Coach), criação e consumo da API remota, sincronização e cache local.

---

## 🎯 Fase 1: Requisitos e Modelagem
**Prazo de Entrega:** 26/06/2026
**Objetivo:** Definir contratos de dados, modelar entidades e preparar a estrutura visual do fluxo de dados para a apresentação.

### Task 1.1: Definição dos Contratos da API (JSON)
* **Subtask 1.1.1:** Mapear os endpoints necessários (ex: `GET /competition`, `GET /teams`, `GET /teams/{id}/players`).
* **Subtask 1.1.2:** Estruturar o payload JSON de resposta para cada endpoint, garantindo que contenham todos os dados exigidos pelos layouts (vitórias, cores hexadecimais, estatísticas).

### Task 1.2: Modelagem das Entidades no Kotlin (Data Classes)
* **Subtask 1.2.1:** Criar a `data class Competition` contendo nome, edição e imagem do troféu.
* **Subtask 1.2.2:** Criar a `data class Team` contendo nome, vitórias, descrição, escudo, lista de cores.
* **Subtask 1.2.3:** Criar a `data class Player` contendo nome, foto, posição, número da camisa e estatísticas.
* **Subtask 1.2.4:** Criar a `data class Coach` contendo nome, foto e perfil descritivo.

### Task 1.3: Preparação para Apresentação Oral
* **Subtask 1.3.1:** Desenvolver o diagrama de fluxo de dados ilustrando como as informações saem da API REST, passam pelo Repositório e alimentam a ViewModel.
* **Subtask 1.3.2:** Criar uma coleção no Postman ou Insomnia com "Mocks" da API para demonstrar exemplos de requisições e respostas durante a apresentação.

---

## 💻 Fase 2: Desenvolvimento e Integração
**Prazo de Entrega:** 28/07/2026
**Objetivo:** Implementar o consumo real da API, persistência de dados offline e integrar com as ViewModels da equipe Android.

### Task 2.1: Desenvolvimento e Deploy da REST API
* **Subtask 2.1.1:** Codificar a API utilizando um framework leve (como Node.js/Express ou Python/FastAPI) ou configurar um JSON Server robusto.
* **Subtask 2.1.2:** Fazer o deploy da API em um serviço de hospedagem (ex: Render, Heroku) para acesso remoto pelo aplicativo.
* **Subtask 2.1.3:** Popular o banco de dados com informações reais ou verossímeis das seleções (Brasil, Argentina, França, Alemanha) e seus respectivos elencos.

### Task 2.2: Implementação do Repositório (Retrofit)
* **Subtask 2.2.1:** Configurar o `Retrofit` e os conversores (ex: Gson ou Moshi) no projeto Android.
* **Subtask 2.2.2:** Criar as interfaces de serviço da API para realizar as chamadas HTTP assíncronas.
* **Subtask 2.2.3:** Desenvolver as classes `Repository` para orquestrar a busca de dados e expor `StateFlow` ou `LiveData`.

### Task 2.3: Sincronização e Cache Local (Offline First)
* **Subtask 2.3.1:** Configurar o banco de dados local utilizando a biblioteca `Room` do Android.
* **Subtask 2.3.2:** Implementar a lógica de *Single Source of Truth* (SSOT) no repositório: o app sempre lê do banco de dados local (`Room`), enquanto o repositório busca dados novos da API REST em background e atualiza o banco local.

### Task 2.4: Testes de Integração
* **Subtask 2.4.1:** Testar os cenários de conectividade (com internet / sem internet) para garantir o funcionamento do cache local.
* **Subtask 2.4.2:** Realizar integração contínua com os Desenvolvedores Android para validar o carregamento dos dados nas telas `CompetitionScreen`, `TeamScreen` e `PlayerDetailScreen`.