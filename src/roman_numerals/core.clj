(ns roman-numerals.core)

(def prefix {
              1 "I"
              2 "X"
              3 "C"
              })

(def regular {
              1 {1 "I" 2 "X" 3 "C" 4 "M"}
              5 {1 "V" 2 "L" 3 "D"}
              })

(defn convert-regular
  "Convert non-special case digit to roman digit."
  [[position part]]
  (cond
    (= part 0) ""
    (< part 5) (apply str (repeat part ((regular 1) position)))
    :default (str ((regular 5) position) (convert-regular [position (- part 5)]))))


(defn convert-char
  "Convert pair [order digit] into roman digits."
  [[position part :as digit-pair]]
  (cond
    (and (= 4 part) (< position 4)) (str (prefix position) (convert-char [position 5]))
    (and (= 9 part) (< position 4)) (str (prefix position) (convert-char [(inc position) 1]))
    :default (convert-regular digit-pair)))

(defn convert
  [num-list]
  (apply str (reverse (map convert-char num-list))))

(defn order
  "Convert integer into list of [order digit] pairs."
  [number]
  (let [reverse-digits (->> (str number)
                       (map #(Character/getNumericValue %))
                       reverse)
        positions (cycle [1 2 3 4])]
    (map vector positions reverse-digits)))

(defn roman
  "Convert arabic number into its roman representation.
  Works only for numbers < 5000."
  [x]
  (convert (order x)))
