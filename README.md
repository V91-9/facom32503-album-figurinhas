# 🏆 Álbum de Figurinhas Digital - UFU

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Figma](https://img.shields.io/badge/figma-%23F24E1E.svg?style=for-the-badge&logo=figma&logoColor=white)

## 📖 Sobre o Projeto
Aplicativo Android que simula um álbum de figurinhas digital para competições esportivas (como a FIFA World Cup 26). O aplicativo permite aos usuários visualizar informações sobre competições, equipes, jogadores e treinadores, garantindo navegação intuitiva, consumo de dados via API remota e experiência offline através de cache local.

Este projeto é uma atividade avaliativa da disciplina de **Programação para Dispositivos Móveis (FACOM32503)** do Curso de Bacharelado em Sistemas de Informação da **Universidade Federal de Uberlândia (UFU)**, orientado pelo Prof. Cláudio C. Rodrigues.

## 🏗️ Arquitetura e Tecnologias
O projeto segue os princípios de separação de responsabilidades (Clean Architecture):
* **UI e Layouts:** Kotlin e Jetpack Compose para componentes visuais reativos.
* **Arquitetura Android:** MVVM (Model-View-ViewModel) dividindo Interface, Lógica de Negócio e Repositório.
* **Navegação:** `NavHost` estruturado para transições entre telas.
* **Engenharia de Dados Remota:** Consumo de REST API via `Retrofit` utilizando formatação JSON.
* **Sincronização e Cache Local:** Persistência de dados utilizando a biblioteca `Room` para garantir o acesso offline.
* **Design/Prototipagem:** Figma.

## 📂 Estrutura do Repositório (Monorepo)
Para organizar o fluxo de trabalho de um time multidisciplinar, o repositório é dividido nas seguintes frentes:

```text
facom32503-album-figurinhas-digital/
├── .github/                   # Templates de Pull Request, Issues e pipelines do GitHub Actions
├── api-backend/               # Código e mocks da API REST (JSON) e banco de dados do servidor
├── design-docs/               # Links do protótipo Figma, assets, fontes e paletas de cores
├── mobile-app/                # Código-fonte do app Android em Kotlin (UI, ViewModels, Repositórios)
└── README.md                  # Este documento de visão geral
```

## 👥 Equipe e Responsabilidades
A equipe é composta por funções específicas para garantir uma entrega de qualidade e uma boa gestão do projeto:
* **👑 Líder do Projeto (1):** Coordenação geral, gestão do cronograma (GitHub Projects), integração das entregas, gestão de branches/Pull Requests e ponte de comunicação.
* **🎨 Designers/UX (2):** Criação dos layouts responsivos, paletas de cores, ícones, prototipagem no Figma e testes de usabilidade.
* **🛠️ Engenheiros de Dados (2):** Modelagem de entidades (Competition, Team, Player, Coach), deploy da API remota, consumo via Retrofit e lógica de sincronização/cache com Room.
* **📱 Desenvolvedores Android (3):** Implementação de telas (CompetitionScreen, TeamScreen, PlayerDetailScreen) usando Jetpack Compose, fluxos de navegação e integração com as ViewModels.

## 🚀 Como Executar o Projeto

### 1. Executando a API Remota (Engenharia de Dados)
1. Navegue até a pasta `api-backend/`.
2. Siga as instruções no `README.md` local desta pasta para iniciar a API (ex: `json-server --watch db.json`).
3. Anote a URL de hospedagem gerada (ex: `http://localhost:3000`).

### 2. Executando o Aplicativo Mobile (Desenvolvimento Android)
1. Abra a pasta `mobile-app/` no **Android Studio**.
2. Aguarde a sincronização do Gradle baixar todas as dependências (`Compose`, `Retrofit`, `Room`, `ViewModel`).
3. Acesse a camada de dados remota (`data/remote/`) e atualize a variável `BASE_URL` do Retrofit para o endereço IP da sua máquina rodando a API, ou a URL hospedada.
4. Conecte um emulador ou dispositivo físico e clique em **Run**.