(ns todo-app.app
  (:require [reagent.core :as r]
            [alandipert.storage-atom :refer [local-storage]]))
;; based on https://codepen.io/Snugug/pen/yOXemR

;;(enable-console-print!)

(defonce todo-items (local-storage (r/atom #{}) :prefs))
(defonce next-todo (r/atom ""))

(defn remove-item [item]
  (swap! todo-items disj item))

(defn add-item [item]
  (when-not (empty? item)
    (swap! todo-items conj item)
    (reset! next-todo "")))

(defn todo-page
  []
  (fn []
    [:form
      [:fieldset
        [:legend "Todo list:"]
        [:ul {:class "todo-list"}
          (for [item @todo-items]
            ^{:key item} [:li [:input.toggle
                                 {:type "checkbox"
                                  :id item
                                  :on-change #(remove-item item)}]
                            item])]]
      [:div {:class "add"}
        " "[:input {:class "add-input"
                    :type "text"
                    :id "add-input"
                    :value @next-todo
                    :auto-focus true
                    :placeholder "Your next item..."
                    :on-change #(reset! next-todo (-> % .-target .-value))
                    :on-key-press #(when (= 13 (.-which %))
                                      (add-item @next-todo)
                                      (.preventDefault %))}]
        [:input {:class "add-submit"
                 :type "button"
                 :value "Add Item"
                 :on-click #(add-item @next-todo)}]]]))

(defn init []
  (r/render [todo-page]
            (js/document.getElementById "container")))
