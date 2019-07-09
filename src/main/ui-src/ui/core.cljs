(ns ui.core
  (:require
    [reagent.core :as r]
    [ui.db :refer [app-state]]
    [ui.header :refer [header]]
    [ui.belt :refer [belt]]
    [ui.service :refer [get-data print-state]]))

(enable-console-print!)

;; -------------------------
;; Views
(defn app []
  [:div
   [header]
   [belt]])

;; -------------------------
;; Initialize app
(defn init-db []
  (get-data))

(defn mount-root []
  (init-db)
  (r/render [app] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
