## Gramáticas
    - Influenciam na construção de um compilador, pois durante a análise lexica precisamos reconhecer os tokens, e as máquinas de estado que ajudam a reconhecer esses tokens.
    - temos que desenvolver o metodo formal de reconhecer os simbolos.
### Paralelos com a língua portuguesa
    - Em portugues, temos 3 entidades diferentes:
        * letras
        * palavras
        * sentenças
    - Essas entidades possuem regras de formação para que a linguagem seja de fato portugues
        * Nem todo conjunto de palavras forma uma sequência válida
        * nem todo conjunto de letras forma uma palavra correta
    - é primordial saber distinguir sequências válidas de inválidas

    - *em linguagens de programação* é equivalente, certas strings são válidas (palavras reservadas) e tornam se *programas* quando *agrupadas* de maneira correta, que podem ser *convertidos* em uma série de comandos em *linguagem de máquina*

### Definições
    - Um automato é formato por:
        * alfabeto (caracteres validos)
        * conjunto de estados
        * funcao de transicao
        * estado inicial
        * conjunto de estados finais

    - Alfabeto sao todos os simbolos válidos na linguagem
    - Cadeias: combinacao de todas as concatenações de simbolos válidos
    - Comprimento da cadeia:  quantidade de simbolos que essa cadeia possui
    - Linguagem: conjunto de cadeias de comprimento finito seguindo as regras de formação, cada cadeia é uma sequencia de uma linguagem

### Gramatica
    - Quadrupla ordenada G = (Vn, Vt, P, S)
        * Vn: simbolos nao terminais
        * Vt: Simbolos terminais (constituem as palavras reservadas, nao produzem derivacao)
        * P: Regras de producao, responsaveis por produzir sentencas
        * S: Simbolo inicial da gramatica, de onde as sentenças sao derivadas


    - Especificação de uma linguagem
    - ou seja, uma linguagem de programacao nada mais é do que englobar todos os possiveis programas que posso escrever seguindo as especificações da gramatica definida para aquela linguagem
#### Exemplo:
    G = ({S, A, B}, {a, b}, P, S)
    P:
        S-> AB          // <A partir desse simbolo> -> <substitua por isso>
        A -> a
        B => bB | b

    cadeias validas: ab, abb, abbb ...
    Linguagem:
        L = ab^n | n >= 1 (b ocore esse numero de vezes)
    -  a expressao acima descreve a linguagem gerada por essa gramática
##### Exercicio 1
G = ({A,B}, {0,1}, P, A)
P:
    A -> 0A | B
    B -> 1B | e
    L = 0^n1^m / n >= 0 m >= 0

##### Exercicio 2
S => AB
A -> aaA|e
B-> Bbb|e
L = a^n b^m / n,m >= 0 e n,m é par

##### Exercício 3
S -> SS+ | SS* | a
S -> SS* -> SS+a* ->aa+a*

#### Propriedades de Gramáticas
    - duas gramaticas são equivalentes quando produzem a mesma linguagem
        * L(G1) = L(G2)
    - Uma sentença é ambigua se existirem duas ou mais sequencias de derivação que a define
    - uma gramática é ambigua se possuir qualquer sentença ambigua
    *exemplo:*
        S -> aSbS | bSaS| e (testar para abab)

##### Exercício 4
- A gramatica e ambigua?
S -> AB
A -> AA | B | a
B -> Bcd | A

teste: aaacd

S -> AB -> AABcd -> AAAcd -> aaacd
S -> AB -> BB -> AB -> AAB -> AAA -> AAB -> AABcd -> AAAcd -> aaacd
é pois posso alternar A e B infinitamente, logo infinitas derivacoes possiveis

#### Classes de gramáticas
    - Dependendo das restrições de formato de uma gramatica, a classe de gramatica varia
    - Hierarquia de Chomsky (menos restrita - mais restrita):
        * Nivel 0: Grmáticas com estrutura de frase (sem restrições)
        * Nivel 1: Gramáticas sensíveis ao contexto (|simbolos esquerda| <= |simbolos direita| )
        * Nivel 2: Gramáticas livres de contexto (apenas um simbolo não terminal do lado esquerdo)
        * Nivel 3: Gramáticas regulares (S -> aW|a|e apenas)

    - Nivel 2: Utilizadas na análise sintática (automatos com pilha)
    - Nivel 3: Utilizada na análise léxica (automatos regulares, regex)

    - Compiladores precisam de gramaticas livres de contexto
