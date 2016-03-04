package br.israelbgf.pointofsale;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DisplayProductFromBarcodeUsecaseTest {

    @Test
    public void validationOfEmptyBarcode(){
        DisplayProductFromBarcodePresenterSpy presenterSpy = new DisplayProductFromBarcodePresenterSpy();
        DisplayProductFromBarcodeUsecase usecase = new DisplayProductFromBarcodeUsecase(presenterSpy);

        usecase.process("");

        assertThat(presenterSpy.spiedText, equalTo("ERROR: Empty Barcode."));
    }

    @Test
    public void validationOfNotANumberBarcode(){
        DisplayProductFromBarcodePresenterSpy presenterSpy = new DisplayProductFromBarcodePresenterSpy();
        DisplayProductFromBarcodeUsecase usecase = new DisplayProductFromBarcodeUsecase(presenterSpy);

        usecase.process("12JBC2");

        assertThat(presenterSpy.spiedText, equalTo("ERROR: Invalid Barcode."));
    }

}
