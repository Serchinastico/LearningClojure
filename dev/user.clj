(ns user
  (:require [clojure.tools.namespace.repl :as tnr]
            [proto]))


(defn start
  [])

(defn reset []
  (tnr/refresh :after 'user/start))

(println "LearningClojure dev/user.clj loaded.")
