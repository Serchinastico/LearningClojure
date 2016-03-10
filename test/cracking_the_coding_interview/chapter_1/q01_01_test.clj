(ns cracking-the-coding-interview.chapter-1.q01-01-test
  (:require [clojure.test :refer :all]
            [cracking-the-coding-interview.chapter-1.q01_01 :refer :all]))

(deftest empty-string-test
    (is (is-unique-v1? ""))
    (is (is-unique-v2? "")))

(deftest all-characters-string-test
    (is (is-unique-v1? "abcdefghijklmnopqrstuvwxyz"))
    (is (is-unique-v2? "abcdefghijklmnopqrstuvwxyz")))

(deftest one-repetition-string-test
    (is (not (is-unique-v1? "aa")))
    (is (not (is-unique-v1? "abcdefga")))
    (is (not (is-unique-v1? "aaaaaaaaa")))
    (is (not (is-unique-v2? "aa")))
    (is (not (is-unique-v2? "abcdefga")))
    (is (not (is-unique-v2? "aaaaaaaaa"))))