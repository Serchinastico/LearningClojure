(ns cracking-the-coding-interview.chapter-1.q01_02)

; Count how many times each character appears in both strings and compare
; their frequencies

(defn are-permutations? [first-string, second-string]
  (and (= (count first-string) (count second-string))
    (every? true? (map =
      (sort (frequencies (seq first-string)))
      (sort (frequencies (seq second-string)))))))