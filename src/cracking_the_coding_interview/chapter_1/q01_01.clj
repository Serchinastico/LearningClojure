(ns cracking-the-coding-interview.chapter-1.q01_01)

; Version 1: Traverse the string storing each found character in a set.

(defn is-unique-v1? [string]
  (defn is-unique-with-characters? [characters characters-so-far]
    (if (empty? characters)
      true
      (let [character (first characters)]
        (and (not (contains? characters-so-far character))
          (is-unique-with-characters?
            (rest characters)
            (conj characters-so-far character))))))
  (is-unique-with-characters? (seq string) #{}))

; Version 2: Not using any additional data structure; traverse the string and
;            look for each character in the rest of the string

(defn is-unique-v2? [string]
  (defn contains-character? [characters character]
    (if (empty? characters)
      false
      (or (= character (peek characters))
        (contains-character? (pop characters) character))))

  (defn is-unique-with-characters? [characters]
    (if (empty? characters)
      true
      (let [character (peek characters)
            rest-characters (pop characters)]
        (and (not (contains-character? rest-characters character))
          (is-unique-with-characters? rest-characters)))))
  (is-unique-with-characters? (vec string)))