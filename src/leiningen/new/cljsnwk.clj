(ns leiningen.new.cljsnwk
  (:use [leiningen.new.templates :only [renderer name-to-path ->files]]))


(def render (renderer "cljsnwk"))


(defn cljsnwk
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (->files data
             "public"             
             "public/css"
             "public/js"
             "public/images"
             
             ["public/css/{{sanitized}}.css" (render "public/css/cljsnwk.css" data)]
             ["public/index.html" (render "public/index.html" data)]
             
             ["project.clj" (render "project.clj" data)]

             "src"
             "src/{{sanitized}}"
             ["src/{{sanitized}}/core.cljs" (render "src/cljsnwk/core.cljs" data)]
             ["src/{{sanitized}}/util.cljs" (render "src/cljsnwk/util.cljs" data)]
             ["src/{{sanitized}}/config.cljs" (render "src/cljsnwk/config.cljs" data)]
             ["src/{{sanitized}}/macros.clj" (render "src/cljsnwk/macros.clj" data)]

             "test"

             "script"
             ["script/{{sanitized}}" (render "script/runner" data)]

             ["app.js" (render "app.js" data)]
             
             ["package.json" (render "package.json" data)])))
