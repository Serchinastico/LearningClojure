(ns cracking-the-coding-interview.chapter-2.linked_list)

; We could use the clojure list implementation but wanted to practice some more
; clojure :)

; Abstraction to hide implementation details, it's not really needed ¯\_(ツ)_/¯

(defn ll-first [ll] (:first ll))
(defn ll-item [node] (:item node))
(defn ll-next [node] (:next node))

(defn ll-node
  "Creates a new node with the provided item and next node"
  [item next]
  {:item item :next next})

(defn ll-unitary
  "Creates a linked list with one single node"
  [node]
  {:first node})

(defn ll-node
  "Creates a new node"
  [item next]
  {:item item :next next})

(defn ll-set-first
  "Returns a new linked list with the provided first node"
  [node first]
  (assoc node :first first))

(defn ll-set-next
  "Returns a new node having as its next node the provided one"
  [node next]
  (assoc node :next next))

(defn ll-empty
  "Creates an empty linked list"
  []
  (ll-unitary nil))

(defn ll-remove
  "Removes the item in the position provided. If the item does not exist it
  will not perform any action"
  [ll position]
  (defn remove-node
    [node position]
    (if (nil? node)
      nil
      (if (= 0 position)
        (ll-next node)
        (ll-set-next node (remove-node (ll-next node) (dec position))))))

  (if (or (nil? ll) (< position 0))
    ll
    (ll-set-first ll (remove-node (ll-first ll) position))))

(defn ll-insert-first
  "Adds a new item to the beginning of the linked list"
  [ll item]
  (let [first (ll-first ll)]
    (ll-unitary (ll-node item first))
      (assoc ll :first {:item item :next first})))

(defn ll-insert-last
  "Appends a new item to the tail of the linked list"
  [ll item]
  (defn insert-last
    [node]
    (if (nil? node)
      (ll-node item nil)
      (ll-set-next node (insert-last (ll-next node)))))

  (ll-unitary (insert-last (ll-first ll))))

(defn to-ll
  "Creates a linked list from a sequence"
  [seq]
  (reduce ll-insert-first (ll-empty) (reverse seq)))

(defn ll-to-seq
  "Creates a sequence from a linked list"
  [ll]
  (loop [node (ll-first ll)
         seq-so-far []]
    (if (nil? node)
      seq-so-far
      (recur (ll-next node) (conj seq-so-far (ll-item node))))))
