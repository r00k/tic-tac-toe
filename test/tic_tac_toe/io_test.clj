(ns tic-tac-toe.io-test
  (:use clojure.test
        tic-tac-toe.io))

(deftest test-printable-board
  (testing "Printing an empty board shows numbered available moves"
    (is (= (str " 0 | 1 | 2 \n"
                "-----------\n"
                " 3 | 4 | 5 \n"
                "-----------\n"
                " 6 | 7 | 8 \n")
           (render '[- - -, - - -, - - -]))))
  (testing "Printing a board with moves"
    (is (= (str " X | 1 | X \n"
                "-----------\n"
                " 3 | O | 5 \n"
                "-----------\n"
                " 6 | X | 8 \n")
           (render '[X - X, - O -, - X -])))))
