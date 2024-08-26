# Locadora-ES1

Trabalho para a disciplina de Engenharia de Software 1, com o objetivo de colocar em prática o conhecimento adquirido sobre arquitetura de software.

 
## Funcionalidades a ser implementadas:

### Exclusão de Cliente

a) Deve ser solicitado o CPF do cliente.
b) Ao final, deve ser apresentada a mensagem “Exclusão bem-sucedida” ou “Cliente não 
encontrado”.

### Listar Clientes 
a) Alterar a funcionalidade para, inicialmente, ler do usuário a ordenação desejada: C-CPF ou NNome.
b) A lista de clientes deve ser apresentada de acordo com essa ordenação.


### Inclusão de Veículos
a) Placa: deve ter o formato AAA9999 onde AAA são letras (A-Z ou a-z) e 9999 são dígitos.
Letras devem ser convertidas para caixa alta.
b) Modelo: 3 a 30 caracteres.
c) Ano de fabricação:  2000 e ≤ ano atual.
d) Valor da diária: valor real > 0.
e) Quilometragem: valor inteiro > 0.
f) Não podem existir dois veículos com a mesma placa.
g) Devem ser apesentadas mensagens de erro de acordo com as validações realizadas.
Exclusão de Veículo
a) Deve ser solicitada a placa.
b) Ao final, deve ser apresentada a mensagem “Exclusão bem-sucedida” ou “Veículo não 
encontrado”.

### Listar Veículos 
a) Ler do usuário a ordenação desejada: P-Placa ou M-Modelo.
b) A lista de veículos deve ser apresentada de acordo com essa ordenação.
c) A formatação da lista deve seguir o padrão definido a seguir.
 -----------------------------------------------------------
 Placa Modelo Ano Diária Km
 -----------------------------------------------------------
 AAA-9999 xxxxxxxx_30_caracteres_xxxxxxx 9999 9999,99 999999

### Locar Veículo 
a) Deve ser solicitado o CPF do cliente e a placa do veículo.
b) Ao final, são esperadas as seguintes mensagens: “Cliente não encontrado”, “Veículo não 
encontrado” ou “Locação bem-sucedida”.

### Listar Locações 
a) A formatação da lista deve seguir o padrão definido a seguir.
 --------------------------------------------------------------------------------
 CPF Nome Placa Modelo Data/hora
 --------------------------------------------------------------------------------
 999.999.999-99 xx_30_caracteres_xx AAA-9999 xx_30_caracteres_xx 99/99/9999 99:99
