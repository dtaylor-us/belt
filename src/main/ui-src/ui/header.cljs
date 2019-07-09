(ns ui.header
  (:require [ui.service :refer [print-state]]))


(defn header
  []
  [:div
   [:h2 "Welcome to Reagent"]
   [:button.foo-button.mdc-button {:on-click (fn [] (print-state))} "Print State"]])
