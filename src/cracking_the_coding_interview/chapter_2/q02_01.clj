(ns cracking-the-coding-interview.chapter-2.q02_01
  (:require [cracking-the-coding-interview.chapter-2.linked_list :refer :all]))


; Version 1: Traverse the linked list storing each element in a set, if an
; element is already in the list, we remove it by pointing its previous node
; to the next one.
;
; Complexity: O(n) where n = (count string)
;   Assuming: first, rest & conj are O(1)

(defn remove-duplicates-v1
  "Remove all duplicated elements from a list"
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
