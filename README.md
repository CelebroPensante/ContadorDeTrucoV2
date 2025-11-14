------------------------------------------------------------------------------------------------------------------------------------------------------
# :dart: Truco Placar Digital 

## :sparkles: Destaques e Novidades

O **Truco Placar Digital** é mais do que um simples marcador de pontos. Ele é a central de organização das suas partidas, permitindo não apenas a contagem rápida, mas também o **Gerenciamento de Perfis de Jogadores** e a **Estatisticas de Jogadores**.

Desenvolvido para ser **rápido, intuitivo** e **livre de distrações**, este aplicativo foca em uma única missão: **garantir a contagem correta e visível dos tentos**, para que você e seus amigos se concentrem apenas no blefe e nas cartas.

### :writing_hand: Foco Principal

Este placar digital é configurado para as regras de pontuação do Truco.

------------------------------------------------------------------------------------------------------------------------------------------------------
## :computer: Tecnologias Utilizadas

| Categoria | Tecnologia | Objetivo |
| :--- | :--- | :--- |
| **Linguagem** | **Kotlin** | Linguagem nativa e moderna para Android. |
| **UI** | **Jetpack Compose** | Interface reativa, limpa e com **botões de toque rápido**. |
| **Persistência** | **Room Database** | Armazenamento estruturado de **Perfis de Jogadores** e **Estatísticas**. |
| **Arquitetura** | MVVM Simples | Lógica de pontuação, perfil e sorteio separada da interface. |

### :gear: Especificações Técnicas

* **Min SDK Version:** 24 (Android 7.0 - Nougat)
* **Compile SDK Version:** 34

------------------------------------------------------------------------------------------------------------------------------------------------------

## :star: Funcionalidades 
O Truco Placar Digital oferece ferramentas essenciais para levar a organização do seu jogo a um novo nível:

### 1. Contador de Pontos Inteligente (Placar)
* **Botões de Pontuação Rápida:** Botões grandes para +1, +3, +6, +9, minimizando erros.
* **Alerta de Pontuação:** Notificação sonora quando um time faz pontos.
* **Nomeação de Times:** Permite renomear os times (ex: "Nós" vs. "Eles") para maior clareza.
* **Histórico da Partida:** Desfazer jogadas e registro visual das últimas marcações de pontos.
* **Alerta de Fim de Jogo:** Notificação visual e sonora quando um time atinge 12 pontos.

### 2. Criador de Perfil e Estatísticas
* **Criação de Perfis de Jogador:** Permite registrar e salvar os apelidos dos seus amigos.
* **Estatísticas por Perfil:** O aplicativo registra o desempenho de cada jogador ao longo do tempo:
    * Vitórias / Derrotas
    * Partidas Jogadas
    * Porcentagem de Vitórias

### 3. Sorteador de Equipes com Roleta
* **Sorteador Dinâmico:** Ferramenta divertida para sortear os jogadores e formar as duplas.
* **Sorteador de Equipes:** Garante que as duplas sejam formadas de maneira **aleatória e justa** a cada nova partida.

## :bar_chart: Regras de Pontuação Suportadas

O aplicativo gerencia a progressão de pontos baseada nas apostas mais comuns do Truco:

| Ação | Pontos na Mão |
| :--- | :--- |
| Vitória Simples (Mão Inicial) | **1** ponto |
| Truco Aceito / Pedido | **3** pontos |
| Seis Aceito / Pedido | **6** pontos |
| Nove Aceito / Pedido | **9** pontos |

------------------------------------------------------------------------------------------------------------------------------------------------------
# 🧭 Fluxo de Navegação do Aplicativo Contador de Truco

A tabela abaixo detalha as transições (Ações) possíveis entre as Activities do aplicativo.

| Activity de Origem | Destinos (Ações) | Notas sobre o Fluxo |
| :--- | :--- | :--- |
| **MainActivity** | $\rightarrow$ LoginActivity | Acesso à tela de autenticação. |
| | $\rightarrow$ SorteioActivity | Acesso à tela de sorteio (ex: quem começa). |
| | $\rightarrow$ ConfiguracaoDuplasActivity | **Fluxo principal para começar a jogar.** |
| | $\rightarrow$ EstatisticasActivity | Acesso ao histórico/dados do usuário. |
| | $\rightarrow$ JogoActivity (via ConfiguracaoDuplas) | Navegação indireta (o fluxo passa por ConfiguracaoDuplas). |
| **ConfiguracaoDuplasActivity** | $\rightarrow$ JogoActivity | Iniciar a partida após configurar as duplas. |
| | $\leftarrow$ MainActivity | Voltar para a tela principal (cancelar configuração). |
| **JogoActivity** | $\rightarrow$ VitoriaActivity | Fim do jogo (alguém venceu). |
| | $\leftarrow$ ConfiguracaoDuplasActivity | Voltar para reconfigurar (se o jogo permitir). |

------------------------------------------------------------------------------------------------------------------------------------------------------

### Fluxos Secundários e de Retorno (Complemento)

| Activity de Origem | Destinos (Ações) | Notas sobre o Fluxo |
| :--- | :--- | :--- |
| **VitoriaActivity** | $\rightarrow$ JogoActivity | Iniciar a revanche (novo jogo). |
| | $\rightarrow$ SorteioActivity | Sortear para a próxima partida/revanche. |
| **LoginActivity** | $\leftarrow$ MainActivity | Voltar após login ou cancelamento. |
| **SorteioActivity** | $\leftarrow$ MainActivity | Voltar após o sorteio. |
| **EstatisticasActivity** | $\leftarrow$ MainActivity | Voltar da tela de estatísticas. |
------------------------------------------------------------------------------------------------------------------------------------------------------
# 🛠️ Instalação e Execução

Para rodar este marcador de pontos em seu ambiente de desenvolvimento:

### Pré-requisitos

1.  **Android Studio** instalado.
2.  Um Emulador ou Dispositivo Android com **API 24+**.

### 1. Abrir o Android Studio 
### 2. Clone Repository
### 3. Coloque no URL https://github.com/CelebroPensante/ContadorDeTrucoV2
### 4. Aguarde o Gradle sincronizar o projeto (pode levar alguns minutos na primeira vez).

------------------------------------------------------------------------------------------------------------------------

## 👥 Autores e Contribuições

Abaixo estão listados os principais colaboradores do projeto e suas respectivas áreas de responsabilidade:

| Autor | GitHub | Contribuições Principais |
| :--- | :--- | :--- |
| **Kauã Almeida** | `@KauaNorris` | 📝 Organização do Projeto, Documentação (`README`), Lógica do Sorteador de Equipes. |
| **Pedro Lima** | `@pedrolbp` | 🏠 Desenvolvimento da Tela Principal (`Hub`), Funcionalidades de Estatísticas. |
| **Rafael Lucena** | `@RafaelLcN` | 👤 Implementação da Tela de Login/Cadastro (Criação de Perfil). |
| **Vitor Carvalho** | `@CelebroPensante` | 🏆 Lógica do Contador de Pontos, Desenvolvimento da Tela de Vitória, Gerenciamento do Banco de Dados. |
