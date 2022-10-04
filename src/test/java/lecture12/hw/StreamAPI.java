package lecture12.hw;

import driver.SimpleDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.NavigationItems;
import pageObjects.herokuapp.NavigationPage;
import pageObjects.herokuapp.SortableDataTablesPage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPI extends BaseTest {

    @Test
    public void streamSort(){

        setUp();
        List<Integer> numbers = Arrays.asList(-79, 99, -83, -75, -78, -22, -57, 84, 11, 15);
        List<Integer> sortedNumbers = numbers.stream().map(num -> Math.abs(num)).collect(Collectors.toList());
        Collections.sort(sortedNumbers);
        System.out.println(sortedNumbers);

    }

    @Test
    public void emailChange(){
        get(NavigationPage.class).open().navigateTo(NavigationItems.SORTABLE_DATA_TABLES);
        Map<String, List<String>> mapTableData = get(SortableDataTablesPage.class).checkTableIsDisplayed().getTableData();
        List<String> emailData = mapTableData
                .get("Email")
                .stream()
                .map(email -> email.substring(0, email.indexOf('@'))+"@gmail.com")
                .collect(Collectors.toList());
        System.out.println(emailData);
    }
    // или нужно было типа хэшмапы ключ-значение?

}
