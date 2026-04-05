package by.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends ParentPage {
    private final String URL = "https://www.onliner.by/";
    private final String INPUT_SEARCH = "//*[@id=\"fast-search\"]/div/input";

    private final String BUTTON_AUTH = "//*[@id=\"userbar\"]/div[2]/div/div/div[1]";
    private final String COPY_RIGHTS = "/html/body/div[4]/footer/div/div/div/div[2]/div[2]";
    private final String COOKIES = "//*[@id=\"submit-button\"]";

    public HomePage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }

    public void clickButtonAuth() {
        driver.findElement(By.xpath(BUTTON_AUTH)).click();
    }

    public String getButtonAuthText() {
        return driver.findElement(By.xpath(BUTTON_AUTH)).getText();
    }

    public void setInputSearch(String text) {
        driver.findElement(By.xpath(INPUT_SEARCH)).sendKeys(text);
    }

    public String getPartInputSearchText() {
        //return driver.findElement(By.xpath(INPUT_SEARCH)).getText();
        // Получаем весь текст (или placeholder, если текст внутри атрибута)
        String fullText = driver.findElement(By.xpath(INPUT_SEARCH)).getAttribute("placeholder");

        if (fullText != null && fullText.contains(".")) {
            // Находим индекс первой точки и прибавляем 1, чтобы включить её в результат
            return fullText.substring(0, fullText.indexOf(".") + 1);
            /*Разберем по частям на примере строки "Поиск в Каталоге. Например, xbox":
            fullText.indexOf(".")
            Ищет в строке первую точку.
            Возвращает её индекс (порядковый номер символа, считая с нуля).
            В нашей фразе точка стоит на 17-й позиции. Значит, indexOf вернет 17.

            + 1
            Метод обрезки (substring) работает так: он берет символы до указанного индекса, не включая его.
            Если мы напишем просто 17, точка в результат не попадет.
            Прибавляя 1, мы сдвигаем границу так, чтобы точка включилась в итоговую строку. Теперь индекс равен 18.

            fullText.substring(0, 18)*/
        }
        return fullText;
    }

    public String getCopyRights() {
        return driver.findElement(By.xpath(COPY_RIGHTS)).getText();
    }

    public void acceptCookies() {
        driver.findElement(By.xpath(COOKIES)).click();
    }
}