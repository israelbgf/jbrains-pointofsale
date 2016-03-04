package br.israelbgf.pointofsale.doubles;

import br.israelbgf.pointofsale.usecase.DisplayProductFromBarcode;

public class DisplayProductFromBarcodePresenterSpy implements DisplayProductFromBarcode.Presenter {

    public String spiedText;

    @Override
    public void show(String message) {
        this.spiedText = message;
    }
}
