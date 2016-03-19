(ns {{name}}.core-test
  (:require [{{name}}.core :as {{name}}]
            [cljs.test :refer-macros [deftest is]]
            [cljs-lambda.local :refer [invoke]]
            [promesa.core :as p]))

(deftest rejects-bad-token
  (cljs.test/async
   done
   (-> (invoke {{name}}/{{name}} {:token "bad token"})
       (p/branch
         #(is false (str "Expected error" %))
         #(is (= :bad-token (-> % ex-data :type))))
       (p/then done))))
