(defproject ui "0.1.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [cljs-ajax "0.7.5"]
                 [org.clojure/clojurescript "1.10.520"]
                 [reagent "0.8.1"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.19"]]

  :clean-targets ^{:protect false}

  [:target-path
   [:cljsbuild :builds :app :compiler :output-dir]
   [:cljsbuild :builds :app :compiler :output-to]]

  :resource-paths ["src/main/resources/static"]


  :figwheel {:http-server-root "."
             :nrepl-port 7002
             :nrepl-middleware [cider.piggieback/wrap-cljs-repl]
             :css-dirs ["src/main/resources/static/css"]}

  :cljsbuild {:builds {:app
                       {:source-paths ["src/main/ui-src" "env/dev/cljs"]
                        :compiler
                        {:main "ui.dev"
                         :output-to "src/main/resources/static/js/ui.js"
                         :output-dir "src/main/resources/static/js/dev"
                         :asset-path   "js/dev"
                         :source-map true
                         :optimizations :none
                         :pretty-print  true}
                        :figwheel
                        {:on-jsload "ui.core/mount-root"
                         :open-urls ["http://localhost:3449/index.html"]}}
                       :release
                       {:source-paths ["src/main/ui-src" "env/prod/cljs"]
                        :compiler
                        {:output-to "src/main/resources/static/js/ui.js"
                         :output-dir "src/main/resources/static/js/out"
                         :optimizations :advanced
                         :infer-externs true
                         :pretty-print false}}}}

  :aliases {"package" ["do" "clean" ["cljsbuild" "once" "release"]]}

  :profiles {:dev {:source-paths ["src/main/ui-src" "env/dev/clj"]
                   :dependencies [[binaryage/devtools "0.9.10"]
                                  [figwheel-sidecar "0.5.19"]
                                  [nrepl "0.6.0"]
                                  [cider/piggieback "0.4.1"]]}})
