(ns cracking-the-coding-interview.chapter-1.q01-02-test
  (:require [clojure.test :refer :all]
            [cracking-the-coding-interview.chapter-1.q01_02 :refer :all]))

(deftest empty-string-test
  (is (are-permutations? "" ""))
  (is (not (are-permutations? "" "a")))
  (is (not (are-permutations? "a" ""))))

(deftest real-permutations-test
  (is (are-permutations? "asdfgh" "hgfdsa"))
  (is (are-permutations? "aaa" "aaa"))
  (is (are-permutations? "aaabbb" "bbbaaa")))

(deftest no-permutations-test
  (is (not (are-permutations? "aaa" "aaab")))
  (is (not (are-permutations? "aza" "zaz"))))