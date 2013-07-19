(ns {{sanitized}}.util
  (:require [clojure.browser.repl :as repl]))

(defn log
  "Print a log message to the console."
  [v & text]
  (let [vs (if (string? v)
             (apply str v text)
             (str v))]
    (dispatch/fire :log-message vs)
    (.log js/console vs)))


; TODO: add some kind of automatic clj->js and pretty-print support for more easily
; outputting objects, types, nested object structures, etc...
(defn log-obj
  "Print a JS object to the console."
  [obj]
  (.log js/console obj)
  obj)

(defn start-repl-server
  []
  (repl/connect "http://127.0.0.1:9000/repl"))