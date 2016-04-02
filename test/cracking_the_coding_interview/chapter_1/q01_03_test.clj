(ns cracking-the-coding-interview.chapter-1.q01-03-test
  (:require [clojure.test :refer :all]
            [cracking-the-coding-interview.chapter-1.q01_03 :refer :all]))

(deftest empty-string-test
  (is (= (escape-url (str-to-array "" 0) 0) "")))

(deftest multiple-escape-test
  (is (= (escape-url (str-to-array "Mr John" 9) 7) "Mr%20John"))
  (is (= (escape-url (str-to-array " Mr John" 12) 8) "%20Mr%20John"))
  (is (= (escape-url (str-to-array "Mr John " 12) 8) "Mr%20John%20"))
  (is (= (escape-url (str-to-array "   " 9) 3) "%20%20%20")))
