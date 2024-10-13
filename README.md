# TOPcar - Concessionária

Este projeto é uma aplicação de gerenciamento de concessionária de veículos, onde vendedores podem adicionar, editar e deletar informações sobre veículos e clientes. A aplicação é desenvolvida utilizando Java e JavaFX para a interface gráfica, proporcionando uma experiência de usuário moderna e intuitiva.

## Autores
- **lukemew**

## Tecnologias Utilizadas
- **Java**: Linguagem de programação utilizada para o desenvolvimento da aplicação.
- **JavaFX**: Biblioteca de Java para a construção da interface gráfica com design moderno e interativo.
- **JDBC**: API de Java para a conexão e manipulação de bancos de dados.
- **MySQL**: Sistema de gerenciamento de banco de dados utilizado para armazenar informações sobre veículos e clientes.

## Estrutura do Projeto
- **src/**
  - **model/**: Contém as classes que representam as entidades do sistema, como `Veiculo` e `Cliente`.
  - **model/dao/**: Contém as interfaces e implementações para a manipulação de dados no banco de dados, como `VeiculoDaoJDBC` e `ClienteDaoJDBC`.
  - **db/**: Contém a classe de conexão com o banco de dados.
  - **gui/**: Contém as classes de interface gráfica, como `TelaVendedor` e `TelaCliente`.

## Funcionalidades
- **Tela do Vendedor**: Permite ao vendedor adicionar, editar e deletar veículos. O vendedor pode inserir o modelo, ano e cor do veículo.
- **Tela do Cliente**: Exibe uma lista de veículos disponíveis, permitindo que o cliente agende test drives.
- **Banco de Dados**: Utiliza um banco de dados MySQL para armazenar e gerenciar dados sobre veículos e clientes.
- **Modo Escuro**: A interface foi projetada com um tema escuro, proporcionando uma melhor experiência visual.

## Screenshots
*Aqui o usuário seleciona se ele é um vendedor ou cliente, e loga no sistema.*

![Tela de Login](src/imagens/screenshots/TelaDeLogin.png)

*Aqui o cliente tem a opção de sair (deslogar da conta) ou escolher algum dos carros disponíveis para que possa fazer um test drive ou até mesmo adquirí-los.*

![Tela do Cliente](src/imagens/screenshots/TelaDoCLiente.png)

*Aqui o vendedor poderá editar informações que o cliente vê, como deletar o carro, ou editar o modelo, ano e cor do carro. Editando também o banco de dados do projeto.*

![Tela do Vendedor](src/imagens/screenshots/TelaDoVendedor.png)

## Finalidade do Projeto
Este projeto foi desenvolvido como segunda parte do projeto final da disciplina de Programação Orientada a Objetos (POO) do IFCE Campus Boa Viagem. O objetivo principal é aplicar conceitos fundamentais da POO, incluindo herança, encapsulamento e polimorfismo, bem como implementar técnicas de persistência de dados utilizando JDBC e interface gráfica com JavaFX.

O projeto serve como um exemplo prático de como integrar a teoria da programação com a construção de uma aplicação real, demonstrando a importância dos conceitos aprendidos ao longo do curso.
