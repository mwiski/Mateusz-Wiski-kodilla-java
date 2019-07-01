package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product keyboard = new Product("Keyboard");
        Product mouse = new Product("Mouse");

        Item keyboardItem = new Item(keyboard, BigDecimal.valueOf(100), 1, BigDecimal.valueOf(70));
        Item mouseItem1 = new Item(mouse, BigDecimal.valueOf(30), 2, BigDecimal.valueOf(20));
        Item mouseItem2 = new Item(mouse, BigDecimal.valueOf(35), 3, BigDecimal.valueOf(25));

        Invoice invoice1 = new Invoice("123d42");
        Invoice invoice2 = new Invoice("987a43");

        invoice1.addItem(keyboardItem);
        invoice1.addItem(mouseItem1);
        invoice2.addItem(mouseItem2);

        //When
        productDao.save(keyboard);
        productDao.save(mouse);
        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);

        //Then
        assertThat(keyboardItem.getId()).isGreaterThan(0);
        assertThat(mouseItem1.getId()).isGreaterThan(0);
        assertThat(mouseItem2.getId()).isGreaterThan(0);

        //CleanUp
        try {
            invoiceDao.deleteById(invoice1.getId());
            invoiceDao.deleteById(invoice2.getId());
            productDao.deleteById(keyboard.getId());
            productDao.deleteById(mouse.getId());
        } catch (Exception e) {
        //    do nothing
        }
    }
}
