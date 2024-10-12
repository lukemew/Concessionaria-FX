# TOPcar - Concessionária

Este projeto é uma aplicação de gerenciamento de concessionária de veículos, onde vendedores podem adicionar, editar e deletar informações sobre veículos e clientes. A aplicação é desenvolvida utilizando Java e Swing para a interface gráfica.

## Autores
- **lukemew**

## Tecnologias Utilizadas
- **Java**: Linguagem de programação utilizada para o desenvolvimento da aplicação.
- **Swing**: Biblioteca de Java para a construção da interface gráfica.
- **MySQL**: Sistema de gerenciamento de banco de dados utilizado para armazenar informações sobre veículos e clientes.

## Estrutura do Projeto
- **src/**
  - **model/**: Contém as classes que representam as entidades do sistema, como `Veiculo` e `Cliente`.
  - **model/dao/**: Contém as interfaces e implementações para a manipulação de dados no banco de dados, como `VeiculoDao` e `ClienteDao`.
  - **db/**: Contém a classe de conexão com o banco de dados.
  - **gui/**: Contém as classes de interface gráfica, como `TelaVendedor` e `TelaCliente`.

## Funcionalidades
- **Tela do Vendedor**: Permite ao vendedor adicionar e editar veículos. O vendedor pode inserir o modelo, ano e cor do veículo.
- **Tela do Cliente**: Exibe uma lista de veículos disponíveis, permitindo que o cliente agende test drives.
- **Banco de Dados**: Utiliza um banco de dados MySQL para armazenar e gerenciar dados sobre veículos e clientes.

## Screenshots


## Como Executar o Projeto
1. Certifique-se de ter o **Java** e o **MySQL** instalados em sua máquina.
2. Clone este repositório:
   ```bash
   git clone https://github.com/username/TOPcar.git
