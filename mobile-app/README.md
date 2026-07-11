# 🏆 Álbum de Figurinhas - Mobile App

Aplicativo Android focado no consumo de dados de times e jogadores, construído sob o padrão arquitetural **Offline-First**.

---

## 🏗️ Arquitetura de Dados (Data Layer)

A camada de dados foi estruturada para garantir que a aplicação funcione de forma fluida, mesmo sob condições de rede instáveis. O aplicativo prioriza a leitura do banco de dados local (Room) para garantir uma resposta imediata na interface, realizando a sincronização com a API (Retrofit) em segundo plano.

### Tecnologias Utilizadas
*   **Injeção de Dependências:** Dagger Hilt
*   **Serialização de Dados:** Kotlinx.serialization (Nativo)
*   **Camada de Rede:** Retrofit + OkHttp
*   **Persistência Local:** Room Database (SQLite)
*   **Concorrência e Reatividade:** Kotlin Coroutines & Flow

---

## 🧩 Estrutura de Infraestrutura

*   **Modelos de Dados:** Entidades blindadas e serializáveis configuradas nativamente.
*   **Camada de Rede (`AlbumApiService`):** Cliente HTTP configurado para buscar a lista atualizada de times no servidor remoto.
*   **Camada de Persistência (`TeamDao`):** Banco de dados local embutido para cache, garantindo o funcionamento do app sem internet.
*   **A Fonte da Verdade (`TeamRepositoryImpl`):** O maestro da arquitetura. Ele intercepta as chamadas da rede, salva no banco local e expõe um fluxo reativo contínuo de dados.
*   **Gestão de Estado (`TeamViewModel`):** O ponto de contato exclusivo para a equipe de Front-end. Traduz os dados brutos em estados visuais de interface.

---

## 🚀 Guia de Consumo para o Front-end (Jetpack Compose)

Para conectar a interface visual com a infraestrutura de dados, a equipe de UI **não deve** instanciar repositórios ou bancos de dados diretamente. Todo o consumo deve ser feito exclusivamente através da `TeamViewModel`.

### 1. Injeção da ViewModel
Na raiz da sua tela em Compose, injete a ViewModel utilizando o Hilt:

`viewModel: TeamViewModel = hiltViewModel()`

### 2. Observação de Estados (StateFlow)
A ViewModel expõe uma variável reativa chamada `uiState`. A tela deve "assinar" essa variável. A partir desse momento, qualquer mudança no banco de dados atualizará a interface automaticamente:

`val state by viewModel.uiState.collectAsState()`

### 3. Mapeamento de UI (Os 3 Estados Possíveis)
O fluxo de tela foi desenhado em uma interface selada (`TeamUiState`). A equipe de UI deve prever o design para três cenários exatos:

*   ⏳ **`TeamUiState.Loading`**: Disparado enquanto os dados estão sendo lidos ou sincronizados. Recomenda-se o uso de *Shimmer Effects* ou *Progress Indicators*.
*   ✅ **`TeamUiState.Success`**: Retorna a `List<Team>` validada. É o estado principal onde a `LazyColumn` deve ser desenhada.
*   ❌ **`TeamUiState.Error`**: Disparado em caso de falha crítica (ex: banco corrompido e sem rede). Retorna uma `message` em texto que deve ser mapeada para um *Snackbar* ou tela de falha.

> 💡 **Nota aos desenvolvedores de UI:** O arquivo `TeamScreen.kt` foi mantido no repositório como uma Prova de Conceito (PoC) documentada. Sintam-se livres para refatorar, aplicar os guias de estilo (Material 3) e integrá-lo à navegação principal na `MainActivity`.