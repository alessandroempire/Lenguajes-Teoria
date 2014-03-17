--ejercicio B de la tarea 1 de lenguajes Teoria. 

import Data.List

data Proc = Proc (String, Integer, [Proc])
          deriving (Show, Eq)

mem :: Proc -> Integer
mem (Proc (_,i,[])) = i
--mem (Proc (a,i,ps)) = memAux (Proc (a,i,ps))
  --  where memAux (Proc (x,y,ps)) = foldl (\counter -> ) 0 ps

memAux (Proc (x,y, [])) contador = contador + y
memAux (Proc (x,y,ps))  contador = foldl (funcion) 0 ps
    where funcion (Proc (a,b,cs)) = 

--memAux1 (Proc (x,y,ps)) = map (memAux1) ps 

proc1 = Proc ("caso base", 6, [])

proc2 = Proc ("caso 2", 3, [proc1])

proc3 = Proc ("caso3", 5, [proc2, proc1])


procA = Proc ("a", 6, [procB, procC])
procB = Proc ("b", 5, [procC, procD])
procC = Proc ("c", 4, [procE])
procD = Proc ("d", 2, [])
procE = Proc ("e", 1, [])
