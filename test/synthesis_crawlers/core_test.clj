(ns synthesis-crawlers.core-test
  (:require [clojure.test :refer :all]
            [synthesis-crawlers.core :refer :all]))


(deftest knowledge-difference-test
  (testing "returns some if there is no difference between two knowlege otherwise returns nil"
    (is (diff-knowledge? {:title #{"wagahai-ha-neko-de-aru"}} {:title #{""}}))
    (is (not (diff-knowledge? {:title #{"wagahai-ha-neko-de-aru"}} {:title #{"wagahai-ha-neko-de-aru"}})))))

(deftest extractors-difference-test
  (testing "return some if there is no difference between two extractor sets otherwise returns nil"
    (is (not (diff-extractors? {"site-url" ["container-expr" {:attr "partial-expr"}]}
                               {"site-url" ["container-expr" {:attr "partial-expr"}]})) "extractors-difference-test-1")
    (is (diff-extractors? {"site-url" ["container-expr" {:attr "partial-expr"}]
                           "site-url2" ["container-expr2" {:attr "partial-expr"}]}
                          {"site-url" ["container-expr" {:attr "partial-expr"}]}) "extractors-difference-test-2")))

(deftest crawled-test
  (testing "returns something if the specified extractor is used"
    (is (crawled? {"site-url" ["container-expr" {:attr "partial-expr"}]} #{{"site-url" ["container-expr" {:attr "partial-expr"}]}}))))

#_(deftest extract-instance-test
  (testing "extrtacts knowledge"
    (is (= (extract-kowledge #{:title :price} 
                      #{"http://www.barnesandnoble.com/w/living-clojure-carin-meier/1120914833?ean=9781491909041"}
                      #{{"http://www.barnesandnoble.com/" [["container-expr" {:title "title-expr" :rice "price-expr"}]]}}
                        #{}) {:complete nil :knowledge nil :incomplete nil}))))

