(ns {{sanitized}}.config
	(:require [{{sanitized}}.util :refer [log start-repl-server]]))


(defn head
	[]
	(.querySelector js/window.document "head"))


(defn body
	[]
	(.querySelector js/window.document "body"))


(defn load-js-file
	[path]
	(let [js-file (.createElement js/document "script")]
		(aset js-file "path" path)
		(aset js-file "type" "text/javascript")
		(aset js-file "async" false)
		(.appendChild (body) js-file)
		js-file))


(defn load-css-file
	[path]
	(let [css-file (.createElement js/document "link")]
		(aset css-file "href" path)
		(aset css-file "rel" "stylesheet")
		(aset css-file "type" "text/css")
		(.appendChild (head) css-file)
		css-file))


(defn init-application
	([deps]
		(init-application deps nil nil))
	([deps before-init-fn after-init-fn]
		(when before-init-fn
			(before-init-fn))	
		(doseq [js (:javascripts deps)]
			(load-css-file js))
		(doseq [css (:css deps)]
			(load-css-file css))
		(when (:init-repl deps)
			(start-repl-server))
		(when after-init-fn
			(before-init-fn))))