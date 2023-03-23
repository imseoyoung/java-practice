package com.sylim.practice.finalProject;

import java.util.List;

public interface CsvWriter {
    String getHeader();
    List<String[]> getData();
}
