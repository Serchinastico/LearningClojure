(ns cracking-the-coding-interview.chapter-2.q02-01-test
  (:require [clojure.test :refer :all]
            [cracking-the-coding-interview.chapter-2.q02_01 :refer :all]
            [cracking-the-coding-interview.chapter-2.linked_list :refer :all]))

(defn remove-duplicates-str-v1
  [in]
  (apply str (ll-to-seq (remove-duplicates-v1 (to-ll in)))))

(deftest remove-duplicates-test
  (is (= (remove-duplicates-str-v1 "") ""))
  (is (= (remove-duplicates-str-v1 "a") "a"))
  (is (= (remove-duplicates-str-v1 "aa") "a"))
  (is (= (remove-duplicates-str-v1 "aaa") "a"))
  (is (= (remove-duplicates-str-v1 "abc") "abc"))
  (is (= (remove-duplicates-str-v1 "abcabc") "abc"))
  (is (= (remove-duplicates-str-v1 "abccccccc") "abc")))
