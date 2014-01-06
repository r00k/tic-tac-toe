(ns tic-tac-toe.core-test
  (:use clojure.test
        tic-tac-toe.core))

(def in-progress-board [["X" "X" "O"] ["O" "O" "X"] [" " " " " "]])
(def board-with-x-as-horizontal-winner [["X" "X" "X"] ["" "" ""] ["" "" ""]])
(def board-with-o-as-horizontal-winner [["O" "O" "O"] ["" "" ""] ["" "" ""]])
(def board-with-x-as-vertical-winner [["O" "O" "X"] ["" "" "X"] ["O" "" "X"]])
(def board-with-o-as-vertical-winner [["O" "O" "X"] ["" "" "X"] ["O" "" "X"]])

(deftest test-make-board
  (testing "Given a string representation it returns a board"
    (is (= '((\X \X \X) (\O \O \O) (\X \X \X)) (make-board "XXXOOOXXX")))
    (is (= '((\X \O \X) (\space \space \space) (\O \X \O)) (make-board "XOX   OXO")))
    (is (= '((\space \X \X) (\O \O \space) (\X \X \O)) (make-board " XXOO XXO")))))

(deftest test-printable-board
  (testing "Printing an empty board"
    (is (= " | | \n-----\n | | \n-----\n | | "
           (make-printable-board tic-tac-toe.core/empty-board))))
  (testing "Printing a board with moves"
    (is (= "X|X|O\n-----\nO|O|X\n-----\n | | ")
           (make-printable-board in-progress-board))))

(deftest test-in-winning-state?
  (testing "When no one has won"
    (is (not (in-winning-state? in-progress-board))))
  (testing "When someone has won"
    (is (in-winning-state? board-with-x-as-horizontal-winner))
    (is (in-winning-state? board-with-o-as-horizontal-winner))
    (is (in-winning-state? board-with-x-as-vertical-winner))))



(= 0 (:fail (run-tests)) (:error (run-tests)))

