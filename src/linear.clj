(ns linear)

(defn v-operation [f & args]
  (apply mapv f args))

(def v+ (partial v-operation +))

(def v- (partial v-operation -))

(def v* (partial v-operation *))

(def vd (partial v-operation /))

(defn dot [& args] (apply + (apply v* args)))

(defn v*s [v & args]
  (mapv #(* (apply * args) %) v))

(defn m-operation [f & args]
  (apply mapv f args))

(def m+ (partial m-operation v+))

(def m- (partial m-operation v-))

(def m* (partial m-operation v*))

(def md (partial m-operation vd))

(defn m*s [v & args]
  (mapv #(apply v*s % args) v))

(defn transpose [& args])

(defn m*v [m v]
  (mapv #(dot v %) m))

(defn m*m [m1 m2])

;(println )