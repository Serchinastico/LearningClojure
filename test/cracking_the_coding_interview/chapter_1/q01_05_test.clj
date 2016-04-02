(ns cracking-the-coding-interview.chapter-1.q01-05-test
  (:require [clojure.test :refer :all]
            [cracking-the-coding-interview.chapter-1.q01_05 :refer :all]))

(deftest one-away-test
  (is (one-away-v1? "" ""))
  (is (one-away-v1? "a" "a"))
  (is (one-away-v1? "a" ""))
  (is (one-away-v1? "" "a"))
  (is (one-away-v1? "a" "aa"))
  (is (one-away-v1? "a" "b"))
  (is (one-away-v1? "abc" "bbc"))
  (is (one-away-v1? "abc" "abd"))
  (is (one-away-v1? "Hola mundo" "Holo mundo"))
  (is (not (one-away-v1? "" "aa")))
  (is (not (one-away-v1? "aa" "bb")))
  (is (not (one-away-v1? "ab" "ba")))
  (is (not (one-away-v1? "a" "bb")))
  (is (not (one-away-v1? "Hola mundo" "Hello world"))))
