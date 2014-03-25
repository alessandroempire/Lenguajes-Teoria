--Tarea 1 de la teoria, pregunta G

data Proc = Proc (String, Integer, [Proc])
    deriving (Show)
   
takeName :: Proc -> String
takeName (Proc (name,_,_)) = name

completo :: [Proc] -> Bool
completo [] = True
completo ps = completoAux ps []
    where completoAux :: [Proc] -> [String] -> Bool
          completoAux [] xs                      = True 
--          completoAux ((Proc (name,_,[])):ps) xs = completoAux ps (name:xs)
          completoAux ((Proc (name,_,ls)):ps) xs = 
              if and (map (flip (elem) xs) (map takeName ls)) then completoAux ps (name:xs)
              else False

completoFR :: [Proc] -> Bool
completoFR = undefined

--Ejemplos para probar
a = Proc ("a", 10, [b])
b = Proc ("b", 10, [c])
c = Proc ("c", 10, [])

m = Proc ("main", 20, [a])

list1 = [c]
list  = [c,b,a,m]
listF = [m,c,b,a]
