(defproject learning-clojure "0.1.0-SNAPSHOT"
  :description "Simple project to learn clojure"
  :url "https://github.com/Serchinastico/LearningClojure"
  :license {:name "Apache License Version 2.0"
            :url "http://www.apache.org/licenses/"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [proto-repl "0.1.2"]]
  :profiles
  {:dev {:source-paths ["dev" "src" "test"]
         :dependencies [[org.clojure/tools.namespace "0.2.11"]]}})
