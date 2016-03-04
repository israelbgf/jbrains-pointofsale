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
    public void validationOfEmptyBarcode() {
        usecase.process("");

        assertThat(presenterSpy.spiedText, equalTo("ERROR: Empty Barcode."));
    }

    @Test
    public void validationOfNotANumberBarcode() {
        usecase.process("12JBC2");

        assertThat(presenterSpy.spiedText, equalTo("ERROR: Invalid Barcode."));
    }

}
