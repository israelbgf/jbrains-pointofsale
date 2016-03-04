package br.israelbgf.pointofsale;

public class DisplayProductFromBarcodePresenterSpy implements DisplayProductFromBarcodeUsecase.Presenter {

    public String spiedText;

    @Override
    public void show(String message) {
        this.spiedText = message;
    }
}
