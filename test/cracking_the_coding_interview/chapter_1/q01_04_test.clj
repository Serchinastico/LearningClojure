(ns cracking-the-coding-interview.chapter-1.q01-04-test
  (:require [clojure.test :refer :all]
            [cracking-the-coding-interview.chapter-1.q01_04 :refer :all]))

(deftest palindrome-permutations-test
  (is (palindrome-permutations-v1? ""))
  (is (palindrome-permutations-v1? "a"))
  (is (palindrome-permutations-v1? "aa"))
  (is (palindrome-permutations-v1? "aaa"))
  (is (palindrome-permutations-v1? "aab"))
  (is (palindrome-permutations-v1? "aabb"))
  (is (palindrome-permutations-v1? "aabbc"))
  (is (palindrome-permutations-v1? "aabbcc"))
  (is (not (palindrome-permutations-v1? "ab")))
  (is (not (palindrome-permutations-v1? "abc")))
  (is (not (palindrome-permutations-v1? "abbc"))))
