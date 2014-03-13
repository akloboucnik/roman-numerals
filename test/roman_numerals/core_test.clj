(ns roman-numerals.core-test
  (:require [clojure.test :refer :all]
            [roman-numerals.core :refer :all]))

(deftest order-test
  (is (= '([1 1]) (order "1")))
  (is (= '([1 1] [2 1]) (order "11")))
  (is (= '([1 0] [2 1]) (order "10"))))

(deftest convert-char-test
  (is (= "II" (convert-char [1 2])))
  (is (= "IV" (convert-char [1 4])))
  (is (= "IX" (convert-char [1 9])))
  (is (= "XL" (convert-char [2 4])))
  (is (= "XC" (convert-char [2 9])))
  (is (= "CD" (convert-char [3 4]))))

(deftest roman-test
  (is (= "I" (roman 1)))
  (is (= "II" (roman 2)))
  (is (= "III" (roman 3)))
  (is (= "IV" (roman 4)))
  (is (= "V" (roman 5)))
  (is (= "VI" (roman 6)))
  (is (= "VII" (roman 7)))
  (is (= "VIII" (roman 8)))
  (is (= "IX" (roman 9)))
  (is (= "X" (roman 10)))
  (is (= "XLIX" (roman 49)))
  (is (= "L" (roman 50)))
  (is (= "XCIII" (roman 93)))
  (is (= "C" (roman 100)))
  (is (= "D" (roman 500)))
  (is (= "M" (roman 1000))))
