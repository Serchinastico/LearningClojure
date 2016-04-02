(ns cracking-the-coding-interview.chapter-1.q01_05)

; Version 1: Handle the 2 cases differently:
;            - If one of the strings has less characters than the other, then
;              when we find a mismatch we "move the pointer" of the second
;              string to the right one more position and compare the remaining
;              string.
;            - If the strings have the same number of characters we don't do
;              any additional pointer movements.
;
; Complexity: O(_)

(defn one-away-v1?
  "Returns whether one of the strings can be transformed into the other by
  performing one (or zero) actions to its characters. Valid actions are adding,
  removing or replacing a character"
  [first-string second-string]

  (defn compare-string
    "Compares character by character two strings and returns whether they are
    one change away one from the other. Assumes the larget string has at most
    one more character than the smaller string"
    [smaller-string larger-string has-mismatch-so-far]
    (if (empty? smaller-string)
      (not (and has-mismatch-so-far (not-empty larger-string)))
      (if (not= (first smaller-string) (first larger-string))
        (if has-mismatch-so-far
          false
          (if (= (count smaller-string) (count larger-string))
            (compare-string (rest smaller-string) (rest larger-string) true)
            (compare-string smaller-string (rest larger-string) true)))
        (compare-string (rest smaller-string) (rest larger-string) has-mismatch-so-far))))

    (let [first-string-smaller? (<= (count first-string) (count second-string))
          smaller-string (if first-string-smaller? first-string second-string)
          larger-string (if first-string-smaller? second-string first-string)]

      (if (<= (- (count larger-string) (count smaller-string)) 1)
        (compare-string smaller-string larger-string false)
        false)))
