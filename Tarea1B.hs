--ejercicio B de la tarea 1 de lenguajes Teoria. 

import Data.Maybe

data Proc = Proc (String, Integer, [Proc])
          deriving (Show, Eq)

mem :: Proc -> Integer
mem (Proc (name, weight, [])) = weight
mem (Proc (name, weight, xs)) = weight + maximum (map mem xs)

{-
memRec :: Proc -> Maybe Integer
memRec (Proc (name, weight, xs)) = memRec' (Proc (name, weight, xs)) []
    where memRec' (Proc (name, weight, [])) listP = Just weight
          memRec' (Proc (name, weight, xs)) listP = 
              if elem name listP         then Nothing
              else if elem Nothing value then Nothing
                   else Just ( weight + fromJust (maximum value))
                   where value = ( map (flip ( memRec' name:listP)) xs) FUCKING FLIP
-}

memRec :: Proc -> Maybe Integer
memRec (Proc (name, weight, xs)) = memRec' [] (Proc (name, weight, xs)) 

memRec' :: [String] -> Proc -> Maybe Integer
memRec' listP (Proc (name, weight, []))  = Just weight
memRec' listP (Proc (name, weight, xs))  = if elem name listP         then Nothing
                                           else if elem Nothing value then Nothing
                                                else Just ( weight + fromJust (maximum value))
                                                where value = (map (memRec' (name:listP)) xs)


--Ejemplo de prueba
procA = Proc ("a", 10, [procB, procC])
procB = Proc ("b", 15, [procC])
procC = Proc ("c", 10, [procA])
