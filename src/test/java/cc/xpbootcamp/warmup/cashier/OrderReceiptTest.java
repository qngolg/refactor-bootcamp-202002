package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {

    @Test
    void shouldPrintTitleInformationOnOrder() {
        Order order = new Order(null, new ArrayList<>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();
        assertThat(output, containsString("===== 老王超市，值得信赖 ====="));
    }

    @Test
    void shouldPrintDateInfomationOnOrder() {
        Order order = new Order(LocalDate.of(2020, 2, 17), new ArrayList<>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();
        assertThat(output, containsString("2020年2月17日，星期一"));
    }

    @Test
    void shouldPrintLineItemAndSalesTaxInformationNotInWednesday() {
        List<OrderItem> orderItems = new ArrayList<OrderItem>() {{
            add(new OrderItem("巧克力", 21.50, 2));
            add(new OrderItem("小白菜", 10.00, 1));
        }};
        LocalDate date = LocalDate.of(2020, 2, 17);
        OrderReceipt receipt = new OrderReceipt(new Order(date, orderItems));

        String output = receipt.printReceipt();
        assertThat(output, containsString("巧克力，21.5 × 2，43.0"));
        assertThat(output, containsString("小白菜，10.0 × 1，10.0"));
        assertThat(output, containsString("----------------------"));
        assertThat(output, containsString("税额：5.3"));
        assertThat(output, containsString("总价：58.3"));
    }

    @Test
    void shouldPrintLineItemAndSalesTaxAndDiscountInWednesday(){
        List<OrderItem> orderItems = new ArrayList<OrderItem>() {{
            add(new OrderItem("巧克力", 21.50, 2));
            add(new OrderItem("小白菜", 10.00, 1));
        }};
        LocalDate date = LocalDate.of(2020, 2, 19);
        OrderReceipt receipt = new OrderReceipt(new Order(date, orderItems));

        String output = receipt.printReceipt();
        assertThat(output, containsString("2020年2月19日，星期三"));
        assertThat(output, containsString("巧克力，21.5 × 2，43.0"));
        assertThat(output, containsString("小白菜，10.0 × 1，10.0"));
        assertThat(output, containsString("----------------------"));
        assertThat(output, containsString("税额：5.3"));
        assertThat(output, containsString("折扣：1.17"));
        assertThat(output, containsString("总价：57.13"));
    }
}