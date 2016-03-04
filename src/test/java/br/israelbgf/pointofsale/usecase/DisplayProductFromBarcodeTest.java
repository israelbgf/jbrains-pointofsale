package br.israelbgf.pointofsale.usecase;

import br.israelbgf.pointofsale.doubles.DisplayProductFromBarcodePresenterSpy;
import br.israelbgf.pointofsale.entity.Product;
import br.israelbgf.pointofsale.gateway.InMemoryProductRepository;
import br.israelbgf.pointofsale.gateway.ProductRepository;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DisplayProductFromBarcodeTest {

    private DisplayProductFromBarcodePresenterSpy presenterSpy;
    private DisplayProductFromBarcode usecase;
    private ProductRepository repository;

    @Before
    public void setUp() {
        presenterSpy = new DisplayProductFromBarcodePresenterSpy();
        repository = new InMemoryProductRepository();
        usecase = new DisplayProductFromBarcode(presenterSpy, repository);
    }

    @Test
    public void errorWhenEmptyBarcode() {
        usecase.process("");

        assertThat(presenterSpy.spiedText, equalTo("ERROR: Empty Barcode."));
    }

    @Test
    public void errorWhenBarcodeMixedWithLettersAndNumbers() {
        usecase.process("12JBC2");

        assertThat(presenterSpy.spiedText, equalTo("ERROR: Invalid Barcode."));
    }

    @Test
    public void errorWhenProductForBarcodeDoesNotExists() {
        usecase.process("123456");

        assertThat(presenterSpy.spiedText, equalTo("ERROR: Product does not exists."));
    }

    @Test
    public void showPriceWhenProductExists() {
        repository.save(new Product("123456", 10.59));

        usecase.process("123456");

        assertThat(presenterSpy.spiedText, equalTo("$10.59"));
    }

    @Test
    public void showPriceForTheRightProductWhenOthersExist() {
        repository.save(new Product("123456", 10.59));
        repository.save(new Product("654321", 95.01));

        usecase.process("654321");

        assertThat(presenterSpy.spiedText, equalTo("$95.01"));
    }

    @Test
    public void showPriceWhenBarcodeForProductExistsButItIsMessedUp() {
        repository.save(new Product("123456", 10.59));

        usecase.process("  123456\n\r");

        assertThat(presenterSpy.spiedText, equalTo("$10.59"));
    }


}
