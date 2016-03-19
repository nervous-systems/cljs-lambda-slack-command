(ns leiningen.new.cljs-lambda-slack-command
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "cljs-lambda-slack-command"))

(defn cljs-lambda-slack-command
  [name & opts]
  (let [opts (apply hash-map opts)
        data {:name        name
              :sanitized   (name-to-path name)
              :slack-token (opts ":slack-token" "FIXME")}]
    (main/info "Generating fresh 'lein new' cljs-lambda-slack-command project.")
    (->files
     data
     ["project.clj"                       (render "project.clj" data)]
     ["README.md"                         (render "README.md"   data)]
     ["src/{{sanitized}}/core.cljs"       (render "core.cljs"   data)]
     ["test/{{sanitized}}/core_test.cljs" (render "core_test.cljs" data)]
     ["static/config.edn"                 (render "config.edn"     data)]
     [".gitignore"                        (render "gitignore"      data)]
     ["create-api.sh"                     (render "create-api.sh"  data) :executable true]
     ["assets/slack-post.ftl"             (render "slack-post.ftl" data)]

     ["test/{{sanitized}}/test_runner.cljs" (render "test_runner.cljs" data)])))
