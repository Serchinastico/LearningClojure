(ns cracking-the-coding-interview.chapter-1.q01_02)

; Version 1: Count how many times each character appears in both strings
;            and compare their frequencies
;
; Complexity: O(n * log(n)) where n is (max (count first-string) (count second-string))
;   Assuming: sort complexity is O(n * log(n))

(defn permutations-v1? [first-string second-string]
  "Returns whether one string is a permutation of the characters of the other"
  (and (= (count first-string) (count second-string))
       (every? true? (map =
                          (sort (frequencies first-string))
                          (sort (frequencies second-string))))))

; Version 2: Sort the strings and compare them directly
;
; Complexity: O(n * log(n)) where n is (max (count first-string) (count second-string))
;   Assuming: sort complexity is O(n * log(n))

(defn permutations-v2? [first-string second-string]
  "Returns whether one string is a permutation of the characters of the other"
  (= (sort first-string) (sort second-string)))
