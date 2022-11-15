# A3 - PCS(doc)

<aside>
🍩 Etapa 1 - Criação de um metodo que insere objetos

</aside>

# Estrutura do projeto

![Untitled](A3%20-%20PCS(doc)%20b0ca1ab067a14c6197de3ef821fc8671/Untitled.png)

A classe principal que sera responsavel por receber os metodos e atribuições da interface grafica está separado da classe “Donut” por um pacote chamado Donut Management que comportará todos os elementos necessarios para o funcionamento do programa. Escolhi essa estrutura para melhor organização da aba “projeto”

# Interface ManagerInterface

![Untitled](A3%20-%20PCS(doc)%20b0ca1ab067a14c6197de3ef821fc8671/Untitled%201.png)

Essa interface serve para atribuir os metodos obrigatórios para o fucionamento da classe “Donut”

# Métodos

> 1. InsertObject();
> 
> - Metodo responsavel por inserir objetos dentro de um array e fazer o redimensionamento dele caso necessário
> 1. removeObject();
>     1. remove um objeto e redimensiona o arary automaticamente
> 2. UpdateObject();
>     1. metodo responsavel por atualizar atributos de um objeto ja criado
> 3. returnObject();
>     1. retorna todas as informações de um objeto
> 4. returnObjectIndex();
>     1. retorna a posição de um objeto dentro do array da classe pelo id, para que seja usado na operação de remoção

# Classe “Donut”

![Untitled](A3%20-%20PCS(doc)%20b0ca1ab067a14c6197de3ef821fc8671/Untitled%202.png)

> Contem em si todos os atributos e metodos que usaremos na manipulação de cada objeto
> 

> Em vermelho são todos os atributos privados, ID, nome, cobertura, preco, recheio, tamanho e o array da classe que sera usado para receber os objetos diferentes.
> 

> Em verde todos os metodos publicos que serão usados para manipular os atributos, gerenciar o array e definir as regras de implementação
> 

# Situação atual do projeto:

A logica por trás do metodo InsertObject esta quase pronta, precisamos automatizar o metodo, para que o array seja redimencionado caso necessario e a seleção da posição do array ao ser adicionado seja sequencial, mas ja conseguimos instanciar um objeto com todas os atributos necessarios

![Untitled](A3%20-%20PCS(doc)%20b0ca1ab067a14c6197de3ef821fc8671/Untitled%203.png)

todas as atrubuições estão funcionando corretamente e precisamos pensar em como vamos coloca-las na interface grafica, ainda não estão automatizadas

![Untitled](A3%20-%20PCS(doc)%20b0ca1ab067a14c6197de3ef821fc8671/Untitled%204.png)

resultado no console

![Untitled](A3%20-%20PCS(doc)%20b0ca1ab067a14c6197de3ef821fc8671/Untitled%205.png)

Metodo de retorno mostrando que o que esta sendo chamado são os atributos do objeto dentro do array e não da classe, demonstração de como serão passados os argumentos para o objeto

![Untitled](A3%20-%20PCS(doc)%20b0ca1ab067a14c6197de3ef821fc8671/Untitled%206.png)

## Etapas do projeto:

- [x]  Escrever uma classe referente à entidade que deseja representar, exemplos: Aluno, Produto etc.
    - [x]  Nessa classe defina, no mínimo, seis atributos, sendo um deles obrigatoriamente *****id (int).
- [x]  Escreva os métodos getters e setters, dois construtores, um padrão e outro deve ter todos os parâmetros, exceto id.

Em uma segunda classe, defina:

- [x]  Um array de objetos (defina-o como array da classe);
- [ ]  Um método para inserir objetos, um por vez. (use uma lógica para redimensionar o array, quando estiver totalmente ocupado)
    - O id deve ser sequencial, começando a partir de um e incrementado automaticamente.
    ---
- [ ]  Um método para remover por id, um objeto do array; → precisamos definir como o id ira funcionar
- [ ]  Um método para atualizar um atributo por id.
- [ ]  Dois métodos para realizar a busca por id. Um para retornar todas as informações relacionadas ao objeto pesquisado. E outro, privativo, que retorne apenas o índice referente à posição no array, para ser usado na operação de remoção.

Na classe principal, elabore uma estrutura que tenha disponível ao usuário do sistema, todas as operações a serem realizadas no array

 Utilize interface gráfica para todas as solicitações das operações e visualização de resultados.
 
