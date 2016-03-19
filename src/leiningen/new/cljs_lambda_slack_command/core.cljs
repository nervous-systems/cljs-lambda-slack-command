(ns {{name}}.core
  (:require [cljs-lambda.macros :refer-macros [deflambda]]
            [cljs.reader :refer [read-string]]
            [cljs.nodejs :as nodejs]))

(def config
  (-> (nodejs/require "fs")
      (.readFileSync "static/config.edn" "UTF-8")
      read-string))

(deflambda {{name}} "I just echo, for now."
  [{:keys [token] :as input} ctx]
  (when (not= token (config :slack-token))
    (throw (ex-info "Unauthorized" {:type :bad-token})))
  input)
