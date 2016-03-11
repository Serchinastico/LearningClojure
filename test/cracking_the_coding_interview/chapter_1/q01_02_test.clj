(ns cracking-the-coding-interview.chapter-1.q01-02-test
  (:require [clojure.test :refer :all]
            [cracking-the-coding-interview.chapter-1.q01_02 :refer :all]))

(deftest empty-string-test
  (is (permutations-v1? "" ""))
  (is (not (permutations-v1? "" "a")))
  (is (not (permutations-v1? "a" "")))
  (is (permutations-v2? "" ""))
  (is (not (permutations-v2? "" "a")))
  (is (not (permutations-v2? "a" ""))))

(deftest real-permutations-test
  (is (permutations-v1? "asdfgh" "hgfdsa"))
  (is (permutations-v1? "aaa" "aaa"))
  (is (permutations-v1? "aaabbb" "bbbaaa"))
  (is (permutations-v2? "asdfgh" "hgfdsa"))
  (is (permutations-v2? "aaa" "aaa"))
  (is (permutations-v2? "aaabbb" "bbbaaa")))

(deftest no-permutations-test
  (is (not (permutations-v1? "aaa" "aaab")))
  (is (not (permutations-v1? "aza" "zaz")))
  (is (not (permutations-v2? "aaa" "aaab")))
  (is (not (permutations-v2? "aza" "zaz"))))