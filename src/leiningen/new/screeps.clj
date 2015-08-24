(ns leiningen.new.screeps
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "screeps"))

(defn screeps
  "New project to create logic for screeps."
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' screeps project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["src/{{sanitized}}/core.cljs" (render "core.cljs" data)]
             ["scripts/watch" (render "scripts/watch") :executable true]
             ["scripts/build.clj" (render "scripts/build.clj")])))
