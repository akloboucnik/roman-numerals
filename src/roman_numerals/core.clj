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
  [[position part]]
  (cond
    (= 4 part) (str (prefix position) (convert-char position "5"))
    (= 9 part) (str (prefix position) (convert-char (inc position) "1"))
    :default (regular position)))

(defn convert
  [num-list]
  (apply str (reduce convert-char num-list)))

(defn order
  [number]
  (let [arabic (reverse (map (comp read-string str) (str number)))
        positions (cycle [1 2 3])]
    (map vector positions arabic)))

(defn roman
  [x]
  (convert (order x)))
