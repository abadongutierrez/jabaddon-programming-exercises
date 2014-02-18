(ns peg-game.core-test
  (:require [clojure.test :refer :all]
            [peg-game.core :refer :all]))

(deftest test-find-missing-pegs-for-row
    (testing "Finding missing pegs for row"
        (is (= [1 0] (find-missing-pegs-for-row 0 [[0 1] [2 3] [5 4] [0 0]])))
        (is (= [0 0 0 0] (find-missing-pegs-for-row 0 [[0 0] [0 0] [0 0] [2 3] [5 4] [0 0]])))))

(deftest test-build-game-board
    (testing "Build a normal game board")
        (is (= (build-game-board 5 5 [])
               [
               ["x" "." "x" "." "x" "." "x" "." "x"]
               ["x" "." "x" "." "x" "." "x"]
               ["x" "." "x" "." "x" "." "x" "." "x"]
               ["x" "." "x" "." "x" "." "x"]
               ["x" "." "x" "." "x" "." "x" "." "x"]
               ]))
    (testing "Build game board according the exercise")
        (is (= (build-game-board 5 5 [[1 1] [2 1] [3 2]])
               [
               ["x" "." "x" "." "x" "." "x" "." "x"]
               ["x" "." "." "." "x" "." "x"]
               ["x" "." "." "." "x" "." "x" "." "x"]
               ["x" "." "x" "." "." "." "x"]
               ["x" "." "x" "." "x" "." "x" "." "x"]
               ])))
