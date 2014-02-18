(ns peg-game.core)

(defn find-missing-pegs-for-row [row missing-pegs]
    (into [] (map #(get % 1) (filter #(= row (get % 0)) missing-pegs))))

(defn build-game-board-row [row-num num-pegs missing-pegs-row]
    (loop [curr-column 0 the-vector [] curr-symbol (str "x") total-pegs 0]
        (cond
            (= total-pegs num-pegs)   the-vector
            (and (= curr-symbol "x")) (recur (inc curr-column) (conj the-vector (if (some #(= total-pegs %) missing-pegs-row) "." curr-symbol)) "." (inc total-pegs))
            :default                  (recur (inc curr-column) (conj the-vector curr-symbol) "x" total-pegs))))

(defn build-game-board [num-rows num-columns missing-pegs]
    (loop [curr-row 0 the-vector []]
        (if (< curr-row num-rows)
            (let [missing-pegs-row (find-missing-pegs-for-row curr-row missing-pegs)]
                (recur (inc curr-row) (conj the-vector (build-game-board-row curr-row (if (= 0 (mod curr-row 2)) num-columns (- num-columns 1)) missing-pegs-row))))
            the-vector)))