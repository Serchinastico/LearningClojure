(ns cracking-the-coding-interview.chapter-1.q01-01-test
  (:require [clojure.test :refer :all]
            [cracking-the-coding-interview.chapter-1.q01_01 :refer :all]))

(deftest empty-string-test
  (is (unique-v1? ""))
  (is (unique-v2? ""))
  (is (unique-v3? "")))

(deftest all-characters-string-test
  (is (unique-v1? "abcdefghijklmnopqrstuvwxyz"))
  (is (unique-v2? "abcdefghijklmnopqrstuvwxyz"))
  (is (unique-v3? "abcdefghijklmnopqrstuvwxyz")))

(deftest one-repetition-string-test
  (is (not (unique-v1? "aa")))
  (is (not (unique-v1? "abcdefga")))
  (is (not (unique-v1? "aaaaaaaaa")))
  (is (not (unique-v2? "aa")))
  (is (not (unique-v2? "abcdefga")))
  (is (not (unique-v2? "aaaaaaaaa")))
  (is (not (unique-v3? "aa")))
  (is (not (unique-v3? "abcdefga")))
  (is (not (unique-v3? "aaaaaaaaa"))))

(deftest case-test
  (is (unique-v1? "aAbBcCdD"))
  (is (unique-v2? "aAbBcCdD"))
  (is (unique-v3? "aAbBcCdD")))
