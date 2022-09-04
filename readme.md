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

![Diagrama de Classes de exemplo](<img width="789" alt="Screen Shot 2022-09-04 at 20 04 31" src="https://user-images.githubusercontent.com/89991160/188337313-810e5854-bb81-468a-8dde-a5bdd1acfcdd.png">)



## Usuários Inicialmente Cadastrados 

| Usuário           | Senha   | Tipo          |
| ----------------- | ------- | ------------- |
| cliente@email.com | cliente | Cliente       |
| admin@email.com   | admin   | Administrador |



## Print de Telas 

### Tela Login

![Login](https://user-images.githubusercontent.com/89991160/188337329-91bc0ee9-5929-4b62-b107-50c28cf809c9.png))

### Tela Inicial Com Listagem De Livros

![Tela Inicial](![image](https://user-images.githubusercontent.com/89991160/188337344-3b61e484-18b0-4b57-a84e-bb9bdba122d5.png))

### Tela De Cadastro De Autores

![Cadastro Autores](![image](https://user-images.githubusercontent.com/89991160/188337356-a573d0fe-11f2-447a-a798-8b0eb049e69a.png))

### Tela De Cadastro De Livros

![Cadastro de Livros](![image](https://user-images.githubusercontent.com/89991160/188337366-df78a17b-40bb-4717-9aaa-f7ba168c3f04.png))

### Tela De Cadastro De Usuários

![Cadastro de Usuários](![image](https://user-images.githubusercontent.com/89991160/188337375-bf5276d1-5ecb-45a1-9a4c-ed06b485ea53.png))

### Tela Com Listagem De Autores

![Listagem de Autores](![image](https://user-images.githubusercontent.com/89991160/188337388-ac76772f-9efd-416e-8f31-0070e2e6e9d2.png))

### Tela Com Listagem de Usuários

![Listagem de Usuarios](![image](https://user-images.githubusercontent.com/89991160/188337402-2d388cd0-3028-45b6-a1dd-9a766417d7e2.png))
