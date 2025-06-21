## Analise léxica

### O que ela deve fazer
* função para ler o arquivo
* ler cada palavra do arquivo para identificar as palavras (tokens)
* relatar erros de formação desses tokens

```c
int x = 2;
```

onde:
    int -> tipo
    x -> id
    = -> simbolo_atribuicao
    2 -> num
    ; -> simbolo_fim_instrucao

* os tokens podem ser simbolizados por codigos numericos, atribuindo um código numerico associado a um tipo de de token (ENUMS)

* um programa inteiro pode ser decomposto em seus tokens, que identificam todos os seus tokens, inclusive indicando onde começa e termina, parentesis, numeros, ids, atribuicao, operações matematicas, etc.

### Definições lexicas
* O que delimita um token?
* É case sensitive?
* Qual o conjunto de palavras reservadas?
* Quais as regras de formação de identificadores?
* Quais operadores são aceitos?
* Quais são os delimitadores aceitos? () [] {} . ; : ?
* Quais as regras de formação de números?
* Quais as regras para formação de comentários?

### Gramaticas e regras de formação dos itens lexicos
* Um mesmo token pode possuir vários simbolos:
    * if -> if
    * else -> else
    * rel_op -> < | > | <= | >= | == | != ....

* uma gramática pode ser pensado da seguinte forma:

    * comando -> if expressao then comando | if expr then comando else comando

    * expressao -> termo rel_op termo | termo
    * termo -> id | num

### Como fazer?
* analisador lexico deve ser subordinado ao analisador sintatico, como se fosse uma pequena classe chamada sob demanda
* melhor que o analisador sintatico faça solicitacoes sob demanda, logo o lexer é uma "biblioteca"
* isso simplifica o desenvolvimento.

#### Por que separar analisador léxico de sintático?
* Modulariação
* Projeto mais simples de cada etapa
* Maior eficiencia de cada processo: uso de tecnicas especificas e metodos de otimização locais
* Maior portabilidade: especificidades da linguagem podem ser resolvidas na analise léxica
* Facil de dar manutenção
* Mais fácil para o analisador léxico separar identificadores de palávras reservadas

#### Outras funcoes do analisador léxico
* Consumir comentário, caractéres não imprimiveis (\s, \crlf, \t)
* manipu;ação de tabela de símbolos
* relacionar mensagens de erro emitidas pelo compilador
* diagnóstico de tratamento de erros.

### Tipos de erros léxicos
* Simbolos nao pertencem a simbolos terminais da linguagem
* identificador mal formado
* tamanho do identificador muito grande
* numero mal formado
* tamanho muito grande de numero
* fim de arquivo inesperado (estado final do automato de comentario nao atingido)
* string mal formada (estado final do automato string nao formado)

### Projeto de analisador léxico
* utilizar gramaticas ou expressoes regulares para especificar os tokens
* a partir da especificacao, extraimos o automato que reconhece esses tokens

#### Regex
* Determinam as cadeias válidas para aquele token (cada token tem a sua regex)
* ao juntar todas as regex, temos a representação teorica do analisador lexico

* Exemplo:
    * Identificador: \w(\w|\d)*
    * Inteiro sem sinal: \d+
    * Inteiro com sinal: (\+ | \-)\d+

onde * -> 0 ou mais; + -> 1 ou mais

#### Automatos finitos
* Modelos matemáticos, formados por:
    * Conjunto de estados S
    * Conjunto de simbolos de entrada $$\Epsilon$$
    * Funções de transição, que mapeiam a transição para um estado, a partir de um estado com um simbolo
    * Estado inicial $$S_{0}$$
    * Conjunto de estados finais F para aceitar cadeias
* Uma cadeia é reconhecida válida se existir percurso do estado inicial até um estado final

Exemplo:
* Automato que interpreta cadeia (a | b)* abb pode ser escrito na tabela:
Estado  | Simbolo de entrada
        |   a   |   b       |
    0   | {0,1} |  {0}      |
    1   |   --  |  {2}      |
    2   |   --  |  {3}      |

* Vantagens: elegante e geral
* Desvantagens: Pode ocupar muito espaço e ter processamento lento
* Esse automato é não determimistico, pois a partir de um estado, lendo um caractere, posso ir para mais de um estado, isso causa confusão

* Verificar: Andando na string, realizando as operações de estados, ao final da cadeia, estou em um estado final?

* Podemos converter um automato nao deterministico para um automato deterministico. Em geral, para compiladores, é facil construir um automato determinístico.

##### Como não utilizar uma tabela de transição
* Incorporar no codigo, com um select-case no estado, a partir do  inicial
* o problema é que preciso saber todo o automato de antemao

### Tokens de um programa
* Ao fim de cada token, resetamos para o estado inicial
* exemplos de tokens possiveis (ids, palavras reservadas e simbolos especiais, numeros)
* Nao basta identificar o token e sim retornalo tambem ao analisador sintatico, com a cadeia correspondente:
    * Concatenacao da cadeia conforme o automato é percorrido
    * associacao de ações aos estados finais do automato

* As vezes, para se decidir por um token, tem-se que ler um caractere a mais, que deve ser devolvido a cadeia depois
    * Retroceder() , por exemplo

### Analisador lexico
* Conjunto de procedimentos (switch-case) que reconhecem cadeias validas e em associam as cadeias a tokens
* sempre que chamado, retorna o par (cadeia, token) para o analisador sintatico, consome espaços nao imprimiveis (\s, \t, \n)
* Gera mensagens de erro apropriadas uando cadeia nao é reconhecida por algum automato, ou seja, nao se atinge o estado final do automato. Tratamento apropriado na implementação do analisador léxico.

### Tratamento de erros
* Interrompe o programa ao identificar um erro lexico
* podemos associar tratativas de erro por estado, assim sabemos em qual tipo de erro exatamente nos estamos, e em qual conjunto de tokens estamos:
    * Ex, se colocarmos \d.\w, podemos dizer que é um erro de formação do numero real, pois sabemos que ja estamos nessa regra
* Outra possiblidade é criar estados de erros, que permitem maior clareza
* Queremos aumentar o numero de mensagens de erro específicas

### Tabela de palavras reservadas
* Carregada no inicio de execução do compilador
* Busca deve ser feita por tabela hash, sem colisões
* Erros devem ser tratados devidamente, com mensagens de erros precisas e significativas para o usuário.
