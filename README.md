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
*(Adicione aqui imagens de captura de tela das interfaces do usuário)*

## Como Executar o Projeto
1. Certifique-se de ter o **Java** e o **MySQL** instalados em sua máquina.
2. Clone este repositório:
   ```bash
   git clone https://github.com/username/TOPcar.git
   ```
3. Navegue até o diretório do projeto:
   ```bash
   cd TOPcar
   ```
4. Execute a aplicação:
   ```bash
   java -jar seuArquivoJar.jar
   ```
   *(Substitua `seuArquivoJar.jar` pelo nome do arquivo JAR gerado.)*

## Contribuições
Sinta-se à vontade para contribuir com melhorias e correções. Abra uma *issue* ou faça um *pull request* com suas sugestões.

## Licença
Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

Sinta-se à vontade para modificar qualquer parte do texto ou adicionar informações específicas que você achar necessárias!
