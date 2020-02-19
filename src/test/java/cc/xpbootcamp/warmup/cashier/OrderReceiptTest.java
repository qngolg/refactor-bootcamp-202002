package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<OrderItem> orderItems = new ArrayList<OrderItem>() {{
            add(new OrderItem("milk", 10.0, 2));
            add(new OrderItem("biscuits", 5.0, 5));
            add(new OrderItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, orderItems));

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk\t10.0\t2\t20.0\n"));
        assertThat(output, containsString("biscuits\t5.0\t5\t25.0\n"));
        assertThat(output, containsString("chocolate\t20.0\t1\t20.0\n"));
        assertThat(output, containsString("Sales Tax\t6.5"));
        assertThat(output, containsString("Total Amount\t71.5"));
    }

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
        assertThat(output, containsString("巧克力，21.50 × 2，43.00"));
        assertThat(output, containsString("小白菜，10.00 × 1，10.00"));
        assertThat(output, containsString("----------------------"));
        assertThat(output, containsString("税额：5.30"));
        assertThat(output, containsString("总价：58.30"));
    }
}