package io;

import model.Statistics;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcelWriter {

    private static final Logger logger = Logger.getLogger(ExcelWriter.class.getName());

    private ExcelWriter() {
    }

    public static void writeStatistics(List<Statistics> statisticsList, String filePath) {
        logger.info("Starting write statistics to excel");
        String[] headerNames =
                {"Профиль обучения",
                        "Средний балл за экзамен",
                        "Количество студентов по профилю",
                        "Количество университетов по профилю",
                        "Названия университетов"};
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Статистика");
            Row row = sheet.createRow(0);

            logger.info("Formatting header");
            CellStyle styleHeader = workbook.createCellStyle();
            Font fontHeader = workbook.createFont();
            fontHeader.setBold(true);
            fontHeader.setFontHeightInPoints((short) 14);
            styleHeader.setFont(fontHeader);
            styleHeader.setWrapText(true);
            styleHeader.setAlignment(HorizontalAlignment.CENTER);

            for (int i = 0; i < headerNames.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellStyle(styleHeader);
                cell.setCellValue(headerNames[i]);
            }

            logger.info("Filling the data");
            for (int i = 0; i < statisticsList.size(); i++) {
                row = sheet.createRow(i + 1);
                Statistics statistics = statisticsList.get(i);
                row.createCell(0).setCellValue(statistics.getMainProfile().toString());
                row.createCell(1).setCellValue(statistics.getAvgExamScore());
                row.createCell(2).setCellValue(statistics.getStudentQty());
                row.createCell(3).setCellValue(statistics.getUniversityQty());
                row.createCell(4).setCellValue(statistics.getUniversityNames());
            }

            sheet.autoSizeColumn(1);

            logger.info("Creating a file: "+filePath);
            File file = new File(filePath);
            file.createNewFile();
            workbook.write(new FileOutputStream(file));
            logger.info("Successful of writing statistics");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Fail of writing statistics", e);
        }
    }

}
