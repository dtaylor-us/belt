(ns ui.service
  (:require [ui.db :refer [belts app-state]]
            [clojure.edn :as edn]
            [clojure.walk :as walk]
            [ajax.core :refer [GET POST]]))

(enable-console-print!)

(defn handler [response]
  (.log js/console (str response)))

(defn error-handler [{:keys [status status-text]}]
  (.log js/console (str "something bad happened: " status " " status-text)))

(defn get-data []
  (GET "http://localhost:8080/belt/"
       {:format          :json
        :response-format :json
        :keywords?       true
        :handler         #(do
                           (handler %)
                           (println %)
                           (swap! app-state assoc :belts %))
        :error-handler   error-handler}))

(defn print-state []
  (let [data (:belts @app-state)]
    (println
     (into []
           (map
            (fn [belt]
              (.log js/console belt))
            data)))))
