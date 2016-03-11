(ns cracking-the-coding-interview.chapter-1.q01_01)

; Version 1: Traverse the string storing each found character in a set.
;
; Complexity: O(n)
;   Assuming: first, rest & conj are O(1)

(defn unique-v1? [string]
  (defn unique-with-characters? [characters characters-so-far]
    (if (empty? characters)
      true
      (let [character (first characters)]
        (and (not (contains? characters-so-far character))
          (unique-with-characters?
            (rest characters)
            (conj characters-so-far character))))))
  (unique-with-characters? (seq string) #{}))

; Version 2: Not using any additional data structure; traverse the string and
;            look for each character in the rest of the string
;
; Complexity: O(n^2)
;   Assuming: peek & pop are O(1)

(defn unique-v2? [string]
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
; Complexity: O(n)
;   Assuming: inserting into set is O(1)

(defn unique-v3? [string]
  (= (count (into #{} (seq string)))
    (count string)))
