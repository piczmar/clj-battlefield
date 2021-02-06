(ns pdf
  (:import [org.apache.pdfbox.pdmodel PDDocument]
           [org.apache.pdfbox.pdfparser PDFParser]
           [org.apache.pdfbox.io RandomAccessFile]
           [org.apache.pdfbox.text PDFTextStripper]
           [org.fit.pdfdom PDFDomTree]
           [java.util ArrayList])
  (:require [clojure.java.io :as io]))

(def filename "/mnt/d/docs/pszczoly/rol-03/egzamin/r04-2014-czerwiec-egzamin-zawodowy-pisemny.pdf")
(def file (io/file filename))
(def pdf (PDDocument/load file))
;; (def d (new PDFDomTree))

(with-open [output (clojure.java.io/writer  "pdf2html.html" :encoding "UTF-8")]
  (.writeText (new PDFDomTree) pdf output))


(def rar (new RandomAccessFile file "r"))
(def parser (new PDFParser rar))
(.parse parser)
(def pdDoc (new PDDocument (.getDocument parser)))
(def txt (.getText (new PDFTextStripper) pdDoc))
(println txt)

