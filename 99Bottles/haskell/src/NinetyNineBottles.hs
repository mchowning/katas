module NinetyNineBottles ( sing
                         , song
                         , verses
                         , verse
                         )where

import Text.Printf
import Data.Char (toUpper)

sing :: IO ()
sing = putStr $ unlines song

song :: [String]
song = verses 99 0

verses :: Int -> Int -> [String]
verses start end = map verse $ enumFromThenTo start (start-1) end

verse :: Int -> String
verse n = let stringFormat = "%s of beer on the wall, %s of beer.\n\
                             \%s, %s of beer on the wall."
              currentBottles@(c:cs) = bottles n
              currentBottlesCap = toUpper c : cs
              nextBottles = bottles (n-1)
          in printf stringFormat currentBottlesCap currentBottles (takeDown n) nextBottles


bottles :: Int -> String
bottles (-1) = "99 bottles"
bottles 0 = "no more bottles"
bottles 1 = "1 bottle"
bottles n = show n ++ " bottles"

takeDown :: Int -> String
takeDown 0 = "Go to the store and buy some more"
takeDown 1 = "Take it down and pass it around"
takeDown _ = "Take one down and pass it around"
