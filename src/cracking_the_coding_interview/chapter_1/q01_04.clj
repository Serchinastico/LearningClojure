(ns cracking-the-coding-interview.chapter-1.q01_04)

; Version 1: Count the number of appearances of each letter in the string. In
;            order to be a palindrome all letters have to appear an even number
;            of times (optionally there can be only one letter appearing an odd
;            number of times)
;
; Complexity: O(n) where n = (count string)

(defn palindrome-permutations-v1?
  "Returns whether any of the permutations of the string is a palindrome"
  [string]
  (let [group-chars (group-by even? (vals (frequencies string)))
        odd-chars (get group-chars false)]
    (<= (count odd-chars) 1)))
