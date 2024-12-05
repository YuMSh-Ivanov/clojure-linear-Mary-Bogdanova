(ns linear)

(defn v-operation [f & args]
  (apply mapv f args))

(def v+ (partial v-operation +))

(def v- (partial v-operation -))

(def v* (partial v-operation *))

(def vd (partial v-operation /))

(defn dot [& args]
  (if (empty? args)
    0
    (apply + (apply v* args))))

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

(defn transpose [args]
  (apply mapv vector args))

(defn m*v [m v]
  (mapv #(dot v %) m))

(defn m*m-two [m1 m2]
  (mapv #(m*v (transpose m2) %) m1))

(defn m*m [& args]
  (reduce m*m-two args))

;(println (m*m [[1 2] [3 4] [5 6] [7 8]]
;              [[1000 100 10] [1 0.1 0.01]]
;              [[11] [22] [33]]))