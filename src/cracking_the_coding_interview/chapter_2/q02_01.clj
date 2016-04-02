(ns cracking-the-coding-interview.chapter-2.q02_01
  (:require [cracking-the-coding-interview.chapter-2.linked_list :refer :all]))


; Version 1: Traverse the linked list storing each element in a set, if an
; element is already in the list, we remove it by pointing its previous node
; to the next one.
;
; Complexity: O(n) where n = (count ll)

(defn remove-duplicates-v1
  "Remove all duplicated elements from a linked list"
  [ll]
  (defn remove-duplicate-nodes
    [node found-elements]
    (if (nil? node)
      nil
      (if (contains? found-elements (ll-item node))
        (remove-duplicate-nodes (ll-next node) found-elements)
        (ll-set-next node (remove-duplicate-nodes (ll-next node) (conj found-elements (ll-item node)))))))

  (ll-unitary (remove-duplicate-nodes (ll-first ll) #{})))

(ll-to-seq (remove-duplicates-v1 (to-ll "hola")))

; Version 2: Same solution as in version 1 but using clojure a list.
;
; Complexity: O(n) where n = (count list)

(defn remove-duplicates-v2
  "Remove all duplicated elements from a clojure list"
  [list]
  (reverse
    (loop [in-list list
           out-list '()
           found-elements #{}]
      (if (empty? in-list)
        out-list
        (if (contains? found-elements (first in-list))
          (recur
            (rest in-list)
            out-list
            found-elements)
          (recur
            (rest in-list)
            (conj out-list (first in-list))
            (conj found-elements (first in-list))))))))

; Version 3: Same solution as in version 2 but using the reduce function.
;
; Complexity: O(n) where n = (count list)
(defn remove-duplicates-v3
  [list]
  (reverse (second (reduce (fn [[found-elements out] element]
                             (if (contains? found-elements element)
                               [found-elements out]
                               [(conj found-elements element) (conj out element)]))
                           [#{} '()]
                           list))))
