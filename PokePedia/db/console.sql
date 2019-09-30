create table mochilas
(
    nome_usuario varchar(25) references usuarios (nome),
    id_pokemon   int unique references pokemons (id)
);


insert into mochilas (nome_usuario, id_pokemon)
values ('mark', 15),
       ('mark', 278);


delete
from mochilas
where nome_usuario = 'mark'
  and id_pokemon = 278;



select id, nome, tipo, categoria, altura, peso, geracao
from pokemons
         inner join mochilas m on pokemons.id = m.id_pokemon
where nome_usuario = 'mark';