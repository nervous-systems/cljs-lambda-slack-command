(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME"
  :url "http://please.FIXME"
  :dependencies [[org.clojure/clojure            "1.8.0"]
                 [org.clojure/clojurescript      "1.8.34"]
                 [org.clojure/core.async         "0.2.374"]

                 [io.nervous/cljs-lambda         "0.3.0-SNAPSHOT"]
                 [io.nervous/cljs-nodejs-externs "0.2.0"]]
  :plugins [[lein-cljsbuild "1.1.3"]
            [lein-npm       "0.6.0"]
            [lein-doo       "0.1.7-SNAPSHOT"]
            [io.nervous/lein-cljs-lambda "0.5.1-SNAPSHOT"]]
  :npm {:dependencies [[source-map-support "0.4.0"]]}
  :source-paths ["src"]
  :cljs-lambda
  {:defaults      {:role "FIXME"}
   :resource-dirs ["static"]
   :functions
   [{:name   "{{name}}"
     :invoke {{name}}.core/{{name}}}]}
  :cljsbuild
  {:builds [{:id "{{name}}"
             :source-paths ["src"]
             :compiler {:output-to     "target/{{name}}/{{sanitized}}.js"
                        :output-dir    "target/{{name}}"
                        :source-map    "target/{{name}}/{{sanitized}}.js.map"
                        :target        :nodejs
                        :language-in   :ecmascript5
                        :optimizations :advanced}}
            {:id "{{name}}-test"
             :source-paths ["src" "test"]
             :compiler {:output-to     "target/{{name}}-test/{{sanitized}}.js"
                        :output-dir    "target/{{name}}-test"
                        :target        :nodejs
                        :language-in   :ecmascript5
                        :optimizations :none
                        :main          {{name}}.test-runner}}]})
