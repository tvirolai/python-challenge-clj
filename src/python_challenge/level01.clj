(ns python-challenge.level01)

(defn get-next-char [amount original]
  (let [alphabet
        (vec (take 50 (cycle (map char (range (int \a) (inc (int \z)))))))]
    (if (Character/isLetter original)
      (get alphabet (+ amount (.indexOf alphabet original)))
      original)))

(def input
  "g fmnc wms bgblr rpylqjyrc gr zw fylb. rfyrq ufyr amknsrcpq ypc dmp. bmgle gr gl zw fylb gq glcddgagclr ylb rfyr'q ufw rfgq rcvr gq qm jmle. sqgle qrpgle.kyicrpylq() gq pcamkkclbcb. lmu ynnjw ml rfc spj.")

(defn level-01 [input]
  (->> input
       (map (partial get-next-char 2))
       (apply str)))
