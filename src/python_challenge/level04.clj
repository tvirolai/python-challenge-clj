(ns python-challenge.level04
  (:require [clj-http.client :as client]
            [clojure.string :as s]))

(defn level04 [url]
  (let [body "http://www.pythonchallenge.com/pc/def/linkedlist.php?nothing="
        res (:body (client/get url))
        no (re-find #"\d+" (last (s/split res #"next nothing is ")))]
    (if (s/includes? res ".html")
      res
      (do
        (println res)
        (if (s/includes? res "Divide by two")
          (level04 (str body (/ (Integer. no) 2)))
          (level04 (str body no)))))))
