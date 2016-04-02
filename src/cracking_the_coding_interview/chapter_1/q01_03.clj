(ns cracking-the-coding-interview.chapter-1.q01_03)

; Version 1: The algorithm traverses all the characters of the input string
; and replace all spaces by the string '%20'. It traverses it in reverse
; order to avoid relocating characters when a whitespace is found.
;
; Complexity: O(n) where n = (alength string)
(defn escape-url
  "Replace all whitespaces with its escaped counterpart, %20. Expects an array
  of characters and the size of the text and returns a regular clojure string
  seq"
  [string chars-count]
  (defn copy-character
    "Copies the character from one array to the other, replacing whitespaces
    with the string '%20'. Returns the new position of the out-index"
    [in-array in-index out-array out-index]
    (let [character (aget string in-index)]
        (if (= character \ )
            (do (aset out-array out-index \0)
                (aset out-array (- out-index 1) \2)
                (aset out-array (- out-index 2) \%)
                (- out-index 3))
            (do (aset out-array out-index character)
                (dec out-index)))))

  (loop [in-index (dec chars-count)
         out-index (dec (alength string))
         escaped-string (char-array (alength string))]
    (if (< in-index 0)
      (apply str (seq escaped-string))
      (let [new-out-index (copy-character string in-index escaped-string out-index)]
        (recur (dec in-index) new-out-index escaped-string)))))

(defn str-to-array
  "Transforms a string into a char-array of fixed size. If the provided size is
  greater than the size of the string, it will fill with the default character"
  [string array-size]
  (let [array (char-array array-size)
        indexed-string (map-indexed vector string)]
    (doseq [c indexed-string] (aset array (first c) (second c)))
    array))
