(ns cracking-the-coding-interview.chapter-1.q01_01)

; Version 1: Traverse the string storing each found character in a set.
;
; Complexity: O(n) where n = (count string)
;   Assuming: first, rest & conj are O(1)

(defn unique-v1? [string]
  "Returns whether all the characters in the string appear once"
  (defn unique-with-characters? [characters characters-so-far]
    (if (empty? characters)
      true
      (let [character (first characters)]
        (and (not (contains? characters-so-far character))
          (unique-with-characters?
            (rest characters)
            (conj characters-so-far character))))))
  (unique-with-characters? string #{}))

; Version 2: Not using any additional data structure; traverse the string and
;            look for each character in the rest of the string
;
; Complexity: O(n^2) where n = (count string)
;   Assuming: peek & pop are O(1)

(defn unique-v2? [string]
  "Returns whether all the characters in the string appear once"
  (defn contains-character? [characters character]
    (if (empty? characters)
      false
      (or (= character (peek characters))
        (contains-character? (pop characters) character))))

  (defn unique-with-characters? [characters]
    (if (empty? characters)
      true
      (let [character (peek characters)
            rest-characters (pop characters)]
        (and (not (contains-character? rest-characters character))
          (unique-with-characters? rest-characters)))))
  (unique-with-characters? (vec string)))

; Version 3: After learning some new methods I decided to go with a shorter
;            solution
;
; Complexity: O(n) where n = (count string)
;   Assuming: inserting into set is O(1)

(defn unique-v3? [string]
  "Returns whether all the characters in the string appear once"
  (= (count (into #{} string))
    (count string)))
