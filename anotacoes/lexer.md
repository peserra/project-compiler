## Implementado um analisador léxico


### Como trabalhar nisso
1 - Definir os tokens que conhecemos
2 - Gerar excessoes
3 - Manipular essas possíveis excessões


#### Tokens
Identificadores         -> (a..z) seguido de (A..Z | 0..9 | a..z)*
Numeros                 -> (0..9)+
Pontuacao               -> ;
Operador_Relacional     -> > | >= | < | <= | == | !=
Operador_Atribuicao     -> =

(a..z) : intervalo
'+' : existe pelo menos um
'*' : 0 ou n elementos
