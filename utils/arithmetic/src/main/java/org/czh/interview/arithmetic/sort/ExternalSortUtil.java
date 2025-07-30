package org.czh.interview.arithmetic.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author : CZH
 * description : 外部排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class ExternalSortUtil {

    private static final int MAX_CHUNK_SIZE = 1000; // 内存中块大小（元素数量）

    // 模拟对大文件的外部排序
    public static void externalSort(String inputFile, String outputFile) throws IOException {
        List<File> sortedChunks = createSortedChunks(inputFile);
        mergeSortedFiles(sortedChunks, outputFile);
        // 删除临时文件
        for (File file : sortedChunks) {
            file.delete();
        }
    }

    // 分割并对每块排序，写入临时文件
    private static List<File> createSortedChunks(String inputFile) throws IOException {
        List<File> chunks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            List<Integer> buffer = new ArrayList<>(MAX_CHUNK_SIZE);
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.add(Integer.parseInt(line.trim()));
                if (buffer.size() == MAX_CHUNK_SIZE) {
                    chunks.add(sortAndSaveChunk(buffer));
                    buffer.clear();
                }
            }
            if (!buffer.isEmpty()) {
                chunks.add(sortAndSaveChunk(buffer));
            }
        }
        return chunks;
    }

    private static File sortAndSaveChunk(List<Integer> chunk) throws IOException {
        Collections.sort(chunk);
        File tempFile = File.createTempFile("sortChunk", ".txt");
        tempFile.deleteOnExit();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            for (int num : chunk) {
                writer.write(Integer.toString(num));
                writer.newLine();
            }
        }
        System.out.println(tempFile.getPath());
        return tempFile;
    }

    // 多路归并多个已排序的文件到一个输出文件
    private static void mergeSortedFiles(List<File> files, String outputFile) throws IOException {
        PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        List<BufferedReader> readers = new ArrayList<>();

        try {
            // 初始化每个文件的BufferedReader和优先队列
            for (File file : files) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                readers.add(br);
                String line = br.readLine();
                if (line != null) {
                    pq.offer(new Element(Integer.parseInt(line.trim()), readers.size() - 1));
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                while (!pq.isEmpty()) {
                    Element smallest = pq.poll();
                    writer.write(Integer.toString(smallest.value));
                    writer.newLine();

                    String nextLine = readers.get(smallest.fileIndex).readLine();
                    if (nextLine != null) {
                        pq.offer(new Element(Integer.parseInt(nextLine.trim()), smallest.fileIndex));
                    }
                }
            }
        } finally {
            // 关闭所有reader
            for (BufferedReader br : readers) {
                if (br != null) br.close();
            }
        }
    }

    // 用于存储优先队列元素（值和对应文件索引）
    private static class Element {
        int value;
        int fileIndex;

        Element(int value, int fileIndex) {
            this.value = value;
            this.fileIndex = fileIndex;
        }
    }

    // 测试
    public static void main(String[] args) throws IOException {
        // 这里请准备一个大文件，文件中每行是一个整数，如 input.txt
        // externalSort("input.txt", "sorted_output.txt");

        // 下面为示例：生成测试文件并排序
        String inputFile = "test_input.txt";
        String outputFile = "test_output.txt";

        generateTestFile(inputFile, 5000);

        System.out.println("开始外部排序...");
        externalSort(inputFile, outputFile);
        System.out.println("排序完成，结果写入 " + outputFile);
    }

    // 生成测试文件（随机整数）
    private static void generateTestFile(String filename, int size) throws IOException {
        Random rand = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < size; i++) {
                writer.write(Integer.toString(rand.nextInt(10000)));
                writer.newLine();
            }
        }
    }
}
