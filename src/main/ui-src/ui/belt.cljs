(ns ui.belt
  (:require [ui.db :refer [app-state]]))


(defn belt
  []
  (let [{data :data}(:data @app-state)]
    (for [belt data]
      [:div {:key (:id belt)}
       [:p (:id belt)]])))