(ns cracking-the-coding-interview.chapter-2.q02-01-test
  (:require [clojure.test :refer :all]
            [cracking-the-coding-interview.chapter-2.q02_01 :refer :all]
            [cracking-the-coding-interview.chapter-2.linked_list :refer :all]))

(defn remove-duplicates-str-v1
  [in]
  (apply str (ll-to-seq (remove-duplicates-v1 (to-ll in)))))

(deftest remove-duplicates-v1-test
  (is (= (remove-duplicates-str-v1 "") ""))
  (is (= (remove-duplicates-str-v1 "a") "a"))
  (is (= (remove-duplicates-str-v1 "aa") "a"))
  (is (= (remove-duplicates-str-v1 "aaa") "a"))
  (is (= (remove-duplicates-str-v1 "abc") "abc"))
  (is (= (remove-duplicates-str-v1 "abcabc") "abc"))
  (is (= (remove-duplicates-str-v1 "abccccccc") "abc")))

(deftest remove-duplicates-v2-test
  (is (= (remove-duplicates-v2 "") '()))
  (is (= (remove-duplicates-v2 "a") '(\a)))
  (is (= (remove-duplicates-v2 "aa") '(\a)))
  (is (= (remove-duplicates-v2 "aaa") '(\a)))
  (is (= (remove-duplicates-v2 "abc") '(\a, \b, \c)))
  (is (= (remove-duplicates-v2 "abcabc") '(\a, \b, \c)))
  (is (= (remove-duplicates-v2 "abccccccc") '(\a, \b, \c))))

(deftest remove-duplicates-v3-test
  (is (= (remove-duplicates-v3 "") '()))
  (is (= (remove-duplicates-v3 "a") '(\a)))
  (is (= (remove-duplicates-v3 "aa") '(\a)))
  (is (= (remove-duplicates-v3 "aaa") '(\a)))
  (is (= (remove-duplicates-v3 "abc") '(\a, \b, \c)))
  (is (= (remove-duplicates-v3 "abcabc") '(\a, \b, \c)))
  (is (= (remove-duplicates-v3 "abccccccc") '(\a, \b, \c))))
