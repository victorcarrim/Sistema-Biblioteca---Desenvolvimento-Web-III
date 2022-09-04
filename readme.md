# Sistema Gerenciador de Biblioteca

> Atividade avaliativa proposta pelo Prof. ME. Jefferson de Oliveira Chaves na matéria Desenvolvimento Web III
>
> Sistema desenvolvido na linguagem java utilizando Servlets para lidar com as requesições HTTP enviadas pelas jsp. Utilizado modelo DAO como mecanismo de data storage em comunicação com o MySQL, alem de MVC como design pattern.



## Objetivo Geral

Desenvolver uma aplicação para gestão de livros



## Objetivos Específicos 

- Na listagem de livros, devera ser apresentado o identificador, nome, autor, a data e status do livro.
- Deve ser possivel modificar e excluir um livro que não está mais disponível na própria listagem.
- O status do livro devera ser representado por uma enumeração, com os estados: disponível, emprestado e indisponível.
- A aplicação deve ser acessada por um usuário devidamente cadastrado.
- Somente um usuário do tipo administrador poderá registrar outros usuários.
- O formulário de cadastro de livros de ser validade.
- A aplicação deve ser implementada usando o padrão arquitetural MVC.
- Os dados deverão ser salvos em uma base de dados.



## Diagrama De Classes De Exemplo

![Diagrama de Classes de exemplo](/Users/victorferrari/Desktop/Screen Shot 2022-09-04 at 20.04.31.png)



## Usuários Inicialmente Cadastrados 

| Usuário           | Senha   | Tipo          |
| ----------------- | ------- | ------------- |
| cliente@email.com | cliente | Cliente       |
| admin@email.com   | admin   | Administrador |



## Print de Telas 

### Tela Login

![Login](/Users/victorferrari/Library/Application Support/typora-user-images/image-20220904200909261.png)

### Tela Inicial Com Listagem De Livros

![Tela Inicial](/Users/victorferrari/Library/Application Support/typora-user-images/image-20220904201010351.png)

### Tela De Cadastro De Autores

![Cadastro Autores](/Users/victorferrari/Library/Application Support/typora-user-images/image-20220904201051283.png)

### Tela De Cadastro De Livros

![Cadastro de Livros](/Users/victorferrari/Library/Application Support/typora-user-images/image-20220904201253303.png)

### Tela De Cadastro De Usuários

![Cadastro de Usuários](/Users/victorferrari/Library/Application Support/typora-user-images/image-20220904201349512.png)

### Tela Com Listagem De Autores

![Listagem de Autores](/Users/victorferrari/Library/Application Support/typora-user-images/image-20220904201518238.png)

### Tela Com Listagem de Usuários

![Listagem de Usuarios](/Users/victorferrari/Library/Application Support/typora-user-images/image-20220904201607051.png)