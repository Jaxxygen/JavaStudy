import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class TableFormatter {
    List<Product> productList;
    Workbook workbook = new XSSFWorkbook();
    Sheet sheet;
    int rowCount;
    public TableFormatter (String line) {
        productList = new InfoCollector(line).getProductList();
        sheet = workbook.createSheet("new sheet"); // Здесь можно изменить название в соответствии с запросом, который введет пользователь при выборе товаров для поиска
        creatingTableTitle();
        fillTable();
        try {
            FileOutputStream fileOut = new FileOutputStream("data/GoodsList.xlsx");
            workbook.write(fileOut);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    private void fillTable () {
        for (int i = 0; i < productList.size(); i++) {
            Row row = sheet.createRow(++rowCount);

            Cell name = row.createCell(0);
            name.setCellValue(productList.get(i).getName());

            Cell price = row.createCell(1);
            price.setCellValue(productList.get(i).getPrice());

            Cell bonus = row.createCell(2);
            bonus.setCellValue(productList.get(i).getBonus());

            Cell bonusPercent = row.createCell(3);
            bonusPercent.setCellValue(productList.get(i).getBonusPercent());

            Cell moneyBackFromBonus = row.createCell(4);
            moneyBackFromBonus.setCellValue(productList.get(i).getMoneyBackFromBonus());

            Cell link = row.createCell(5);
            link.setCellValue(productList.get(i).getLink());
        }
    }

    private void creatingTableTitle() {
        Row row = sheet.createRow(rowCount);

        Cell productName = row.createCell(0);
        productName.setCellValue("Наименование товара");


        Cell price = row.createCell(1);
        price.setCellValue("Стоимость товара");

        Cell bonus = row.createCell(2);
        bonus.setCellValue("Вернется \"СберСпасибо\"");

        Cell bonusPercent = row.createCell(3);
        bonusPercent.setCellValue("Процент бонусов");

        Cell moneyBackFromBonus = row.createCell(4);
        moneyBackFromBonus.setCellValue("Возврат деньгами 21%");

        Cell link = row.createCell(5);
        link.setCellValue("Ссылка");
    }
}
