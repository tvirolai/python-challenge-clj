(ns python-challenge.level03
  (:require [clojure.string :as s]))

(def input
 (apply str (s/split (slurp "./data/level03.txt") #"\n")))

(defn is-uppercase? [letter]
  (contains?
    (set
      (map char (range (int \A) (inc (int \Z)))))
    letter))

(defn matches-condition? [substring]
  (= (map is-uppercase? substring)
     '(false true true true false true true true false)))

(defn level03 [input]
  (loop [data input
         res []]
    (if (empty? data)
      (apply str res)
      (let [substr (take 9 data)]
        (if (matches-condition? substr)
          (recur
            (rest data)
            (conj res (nth substr 4)))
          (recur (rest data) res))))))
