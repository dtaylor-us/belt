(ns ui.core
    (:require
      [reagent.core :as r]
      [ajax.core :refer [GET POST]]))

;; -------------------------
;; Views
(defn handler [response]
  (.log js/console (str response)))

(defn error-handler [{:keys [status status-text]}]
  (.log js/console (str "something bad happened: " status " " status-text)))

(defn get-test [user-data]
  (GET "http://localhost:8080/belt/" {:handler handler
                                      :error-handler error-handler}))

(defn home-page []
  [:div
   [:h2 "Welcome to Reagent"]
   [:button.foo-button.mdc-button {:on-click (fn [] (get-test))} "Button"]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
