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
* **Botões de Pontuação Rápida:** Botões grandes para +1, +3, +6, +9 e Queda, minimizando erros.
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
* **Roleta Dinâmica:** Ferramenta divertida para sortear os jogadores e formar as duplas.
* **Roleta de Equipes:** Garante que as duplas sejam formadas de maneira **aleatória e justa** a cada nova partida.

## :bar_chart: Regras de Pontuação Suportadas

O aplicativo gerencia a progressão de pontos baseada nas apostas mais comuns do Truco:

| Ação | Pontos na Mão |
| :--- | :--- |
| Vitória Simples (Mão Inicial) | **1** ponto |
| Truco Aceito / Pedido | **3** pontos |
| Seis Aceito / Pedido | **6** pontos |
| Nove Aceito / Pedido | **9** pontos |
| Queda / Doze Aceito | **12** pontos (Fim do Jogo) |
| Desistência (Correr) | Time que pediu ganha os pontos **atuais** da mão. |

------------------------------------------------------------------------------------------------------------------------------------------------------

## :tools: Instalação e Execução

Para rodar este marcador de pontos em seu ambiente de desenvolvimento:

### Pré-requisitos

1.  **Android Studio** instalado.
2.  Um Emulador ou Dispositivo Android com **API 24+**.

### 1. Clonar o Repositório

git clone [https://github.com/CelebroPensante/ContadorDeTrucoV2](https://github.com/CelebroPensante/ContadorDeTrucoV2)
cd Truco-Placar
------------------------------------------------------------------------------------------------------------------------

##  :family_wwbb:  Autores
* Kauã Almeida (KauaNorris) 
    * Organização
    * Readme
    * Sorteador de Equipes
* Pedro Lima (pedrolbp)
    * Tela Principal(hub)
    * Estatísticas
* Rafael Lucena (RafaelLcN)
    * Criador de perfil(tela de Login/Cadastro)
    * Configurações
* Vitor Carvalho (CelebroPensante)
    * Contador de Pontos
    * Tela de Vitoria
    * Banco de Dados
    * 
