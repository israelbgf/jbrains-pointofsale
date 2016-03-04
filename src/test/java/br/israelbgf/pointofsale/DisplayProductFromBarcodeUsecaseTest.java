package br.israelbgf.pointofsale;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DisplayProductFromBarcodeUsecaseTest {

    private DisplayProductFromBarcodePresenterSpy presenterSpy;
    private DisplayProductFromBarcodeUsecase usecase;

    @Before
    public void setUp() {
        presenterSpy = new DisplayProductFromBarcodePresenterSpy();
        usecase = new DisplayProductFromBarcodeUsecase(presenterSpy);
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

}
