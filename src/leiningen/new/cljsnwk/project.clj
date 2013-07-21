(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "Fix ME."
  :min-lein-version "2.0.0"
  :dependencies [[node-webkit-cljs "0.1.4"]]
  :plugins [[lein-cljsbuild "0.3.0"]]
  :cljsbuild {:builds [{:source-paths ["src" "test"]
  											; uncomment this if you use growl notify
  											; :notify-command ["growlnotify" "-m"]
                        :compiler {:output-to     "public/js/{{name}}.js"
                                   :optimizations :whitespace
                                   :pretty-print  true}}]})
