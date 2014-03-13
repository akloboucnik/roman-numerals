(ns roman-numerals.core)

(def prefix {
              1 "I"
              2 "X"
              3 "C"
              })

(def regular {
              1 "I"
              5 "V"
              10 "X"
              50 "L"
              100 "C"
              500 "D"
              1000 "M"
              })

(defn convert-char
  [position part]
  (cond
    (= 4 part) (str (prefix position) (convert-char position "5"))
    (= 9 part) (str (prefix position) (convert-char (inc position) "1"))
    :default (regular position)))

(defn convert
  [a]
  )

(defn roman
  [x]
  (let [arabic (str x)]
    (convert arabic)))