(ns python-challenge.level02)

(defn level02 []
  (->> "./data/level02.txt" slurp (filter #(Character/isLetter %)) (apply str)))
