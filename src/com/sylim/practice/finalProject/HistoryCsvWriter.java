package com.sylim.practice.finalProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class HistoryCsvWriter implements CsvWriter {
    private static final String COMMA_DELIMITER = ",";
    private static final String FILE_HEADER = "bookid,userid,extend,borrowdate,due";
    private List<String[]> history;

    public HistoryCsvWriter(List<String[]> history) {
        this.history = history;
    }

    @Override
    public String getHeader() {
        return FILE_HEADER;
    }

    @Override
    public List<String[]> getData() {
        return history;
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
            for (String[] data : history) {
                bw.write(data[0]);
                bw.write(COMMA_DELIMITER);
                bw.write(data[1]);
                bw.write(COMMA_DELIMITER);
                bw.write(data[2]);
                bw.write(COMMA_DELIMITER);
                bw.write(data[3]);
                bw.write(COMMA_DELIMITER);
                bw.write(data[4]);
                bw.newLine();
            }
        } catch (Exception e) {
                System.out.println("실패"+ e.getMessage());
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
