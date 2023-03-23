package com.sylim.practice.finalProject;

import java.io.*;
import java.util.List;

public class BookCsvWriter implements CsvWriter {
    private static final String COMMA_DELIMITER = ",";
    private static final String FILE_HEADER = "id,title,writer,publisher,available";
    private List<String[]> books;

    public BookCsvWriter(List<String[]> books) {
        this.books = books;
    }

    @Override
    public String getHeader() {
        return FILE_HEADER;
    }

    @Override
    public List<String[]> getData() {
        return books;
    }

    public void writeCsvFile(String fileName) {
        BufferedWriter bw = null;
        OutputStreamWriter osw = null;
        boolean headerExists = false; // 파일에 header가 이미 있는지 여부

        try {
            // 파일 읽기
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                // 파일에 header가 존재하는지 확인
                if (line.equals(FILE_HEADER)) {
                    headerExists = true;
                    break;
                }
            }
            br.close();
            osw = new OutputStreamWriter(new FileOutputStream(fileName), "EUC-KR");
            bw = new BufferedWriter(osw);

            if (!headerExists) {
                // 파일 헤더 쓰기
                bw.write(FILE_HEADER);
                bw.newLine();
            }

            // List 데이터 쓰기
            for (String[] bookData : books) {
                bw.write(bookData[0]);
                bw.write(COMMA_DELIMITER);
                bw.write(bookData[1]);
                bw.write(COMMA_DELIMITER);
                bw.write(bookData[2]);
                bw.write(COMMA_DELIMITER);
                bw.write(bookData[3]);
                bw.write(COMMA_DELIMITER);
                bw.write(bookData[4]);
                bw.newLine();
            }

        } catch (Exception e) {
            System.out.println("실패" + e.getMessage());
        } finally {
            try {
                bw.flush();
                bw.close();
                osw.close();
            } catch (IOException e) {
                System.out.println("실패" + e.getMessage());
            }
        }
    }

}
