(ns {{sanitized}}.core
	(:require [{{sanitized}}.config :refer [init-application]]))


(def dependencies
	{;; set true to initialize browser connected REPL
	 :init-repl   true
	 ;; add js file paths here to load on app init
	 :javascripts []
	 ;; add css file paths here to load on app init
	 :css				  ["css/{{name}}.css"]})


 (defn init
  []
  (init-application dependencies))
