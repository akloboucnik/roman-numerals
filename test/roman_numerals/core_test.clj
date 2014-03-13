(ns roman-numerals.core-test
  (:require [clojure.test :refer :all]
            [roman-numerals.core :refer :all]))

(deftest convert-char-test
  (is (= "IV" (convert-char 1 4)))
  (is (= "IX" (convert-char 1 9))))

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
  (is (= "C" (roman 100)))
  (is (= "D" (roman 500)))
  (is (= "M" (roman 1000))))
