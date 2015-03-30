(ns type-examples.core
  "Examples of core.typed, compiled from the Quick Guide and the Typed Clojure site"
  (:require [clojure.core.typed :as t])
  (:import (clojure.lang Seqable Symbol Keyword ISeq Indexed)))

(t/ann bar Number)
(def bar 15)

(t/ann add [Number Number -> Number])
(defn add [a b]
  (+ a b))

(t/ann foo [String -> nil])
(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

;; (foo 2) throws an error

(foo "akhilesh") ;; typechecks.

(t/ann my-fn [(Fn [Number -> Number]) -> Number])
(defn my-fn 
  [f]
  (f 10))

(t/ann no-arg [-> Number])
(defn no-arg [] bar)

(t/ann check-hmap [(HMap) -> (HMap :mandatory {:foo String})])
(defn check-hmap [map-arg]
  (assoc map-arg :foo "bar"))

(t/ann custom-filter-test (Seqable Number))
(def my-filter-test (filter odd? (range 10)))

(t/ann never-nil (All [x] [(U x nil) -> x]))
(defn never-nil 
  [a]
  (assert (not (nil? a)) "Found nil")
  a)

