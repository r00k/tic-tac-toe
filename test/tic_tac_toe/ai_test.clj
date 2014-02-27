(ns tic-tac-toe.ai-test
  (:use clojure.test
        tic-tac-toe.ai))

(deftest test-minimax
  (testing "Determines a win for x"
    (is (= 100 (minimax { :board '[x x x, - - -, - - -] :turn 'x }))))
  (testing "Determines a win for o"
    (is (= -100 (minimax { :board '[o o o, - - -, - - -] :turn 'o }))))
  (testing "Determines a draw"
    (is (= 0 (minimax {:board '[o x o, x o x, x o x] :turn 'o}))))
  (testing "Determines a win for x in 1 move"
    (is (= 107 (minimax {:board '[x x -, - - -, - - -] :turn 'x}))))
  (testing "Determines a win for o in 1 move"
    (is (= -107 (minimax {:board '[o o -, - - -, - - -] :turn 'o})))))
