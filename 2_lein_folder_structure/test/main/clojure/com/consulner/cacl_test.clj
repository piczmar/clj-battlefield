(ns com.consulner.cacl-test
  (:require [clojure.test :refer :all]
            [com.consulner.calc :refer :all]))

(deftest adding-numbers
  (is (= 4 (plus 2 2))))

(deftest adding-numbers
  (is (= 3 (plus 2 2))))
