# Como entregar suas tarefas (fluxo de Pull Request)

Este é o mesmo fluxo que você vai usar trabalhando em qualquer empresa. Parece muita coisa na primeira vez, e depois vira automático. Se travar em qualquer passo, posta o print no Discord que a gente destrava junto.

---

## Passo 0 (uma vez só): crie o SEU repositório

Você não trabalha no repositório-modelo do professor. Você cria uma cópia sua.

1. Abra o repositório-modelo do TaskForge no GitHub (link que o professor enviou).
2. Clique no botão verde **"Use this template"** e depois em **"Create a new repository"**.
3. Dê um nome (pode ser `taskforge`) e deixe a visibilidade em **Public**. É importante ser público: é assim que o professor consegue ver e revisar suas entregas sem você precisar dar permissão, e é isso que vira o seu portfólio.
4. Clique em **Create repository**. Pronto, agora esse repositório é seu.

Depois, traga o repositório pro seu computador (clone). No terminal, na pasta onde você guarda seus projetos:

```bash
git clone git@github.com:SEU-USUARIO/taskforge.git
cd taskforge
```

Troque `SEU-USUARIO` pelo seu usuário do GitHub. Use o endereço SSH (começa com `git@github.com:`), que é o que a gente usa no curso. No GitHub, o botão **Code** mostra as duas opções, HTTPS e SSH: escolha a aba **SSH**.

> Se aparecer `Permission denied (publickey)`, sua chave SSH ainda não está configurada no GitHub. Isso é setup de uma vez só; me chama no Discord que a gente resolve rapidinho.

---

## O fluxo de cada entrega

Repita estes passos a cada tarefa (cada aula).

### 1. Crie um branch pra tarefa

Um branch é uma "linha de trabalho" separada, pra você mexer sem bagunçar a versão principal.

```bash
git checkout -b aula-01-1-desafio
```

### 2. Faça o código

Edite o `TaskForge.java` e resolva o desafio da aula.

### 3. Salve no Git

```bash
git add .
git commit -m "Desafio aula 1.1: novos campos na tarefa"
```

`git add .` prepara os arquivos alterados. `git commit` salva um ponto no histórico com uma mensagem.

### 4. Envie pro GitHub

```bash
git push origin aula-01-1-desafio
```

### 5. Abra o Pull Request

1. Vá no seu repositório no GitHub. Vai aparecer um aviso amarelo com o botão **"Compare & pull request"**. Clique nele.
2. O PR vai ser do seu branch (`aula-01-1-desafio`) para a sua `main`. Isso está certo.
3. Escreva um título e clique em **Create pull request**.

### 6. Entregue o link

Copie o link do Pull Request (a URL da página do PR) e cole no canal de **entregas** do Discord.

---

## E agora?

O professor abre o seu PR, revisa, comenta ali mesmo (é assim que você recebe feedback) e aprova. Depois disso, **você** clica em **"Merge pull request"** pra juntar sua tarefa na `main`.

Pra começar a próxima tarefa, volte pra `main` e atualize antes de criar o próximo branch:

```bash
git checkout main
git pull
```

---

## Regra de ouro

O mais importante é **entregar**, mesmo que não saia perfeito. Entregou, aprendeu. Travou? Discord.
