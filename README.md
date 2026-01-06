# Insertion vs Merge Sort Analysis (Java)

## Overview

This project provides a comparative study of **Insertion Sort** and **Merge Sort** implemented in **Java**, using a **video game global sales dataset**. The goal is to evaluate how both algorithms behave across different input sizes and input orders (best / average / worst cases), and to compare **experimental runtime** with **theoretical time and space complexity**.

Each dataset entry contains:

* Game title
* Global sales (in millions)

The algorithms sort the data in **decreasing order** of global sales.

---

## Dataset

The project uses generated video game sales datasets of different sizes:

* **Small inputs:** 15, 25, 40 entries
* **Large inputs:** 50, 70, 100 entries

For each size, datasets are prepared in multiple orders (e.g., sorted, reverse, random) to simulate best, worst, and average cases.

---

## Implemented Algorithms

### 1) Insertion Sort

* Incremental, in-place sorting
* **Best case:** O(n) (nearly sorted input)
* **Average/Worst case:** O(n²)
* **Space:** O(1)

### 2) Merge Sort

* Divide-and-conquer sorting
* **Best/Average/Worst case:** O(n log n)
* **Space:** O(n) due to temporary arrays

---

## Experimental Setup

* Runtime measured using `System.nanoTime()` and converted to microseconds
* Each algorithm writes the sorted output to a text file and prints runtime to the console

Output files produced by the code:

* `SortedGameSales(Insertion).txt`
* `SortedGameSales(merge).txt`

---

## Key Findings

* **Insertion Sort** is suitable for **small inputs** or nearly sorted data due to low overhead.
* **Merge Sort** scales better for **larger inputs** because of its O(n log n) time complexity.
* Merge Sort requires additional memory (O(n)), while Insertion Sort is constant-space.

---

## Project Structure

```
insertion-vs-merge-sort-analysis/
├── code/
│   ├── InsertionSort.java
│   └── MergeSort.java
│
├── datasets/
│   ├── small_datasets.txt
│   └── large_datasets.txt
│
├── report/
│   └── Algorithm_project.pdf
│
├── README.md
└── requirements.txt
```

---

## How to Run

1. Open the project in any Java IDE (e.g., NetBeans / IntelliJ) or compile from terminal.

2. Compile:

* `javac InsertionSort.java`
* `javac MergeSort.java`

3. Run:

* `java InsertionSort`
* `java MergeSort`

The program will print the runtime and generate a sorted output file.

---

## Tools

* Java
* File I/O (FileWriter)

---

## Future Work

* Read datasets from external files instead of hard-coded arrays
* Add plots to visualize runtime vs input size
* Compare against additional algorithms (e.g., Selection Sort)
