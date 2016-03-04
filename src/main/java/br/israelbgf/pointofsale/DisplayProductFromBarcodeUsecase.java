package br.israelbgf.pointofsale;

public class DisplayProductFromBarcodeUsecase {
    private Presenter presenter;

    public DisplayProductFromBarcodeUsecase(Presenter presenter) {
        this.presenter = presenter;
    }

    public void process(String barcode) {
        if(barcode.isEmpty())
            presenter.show("ERROR: Empty Barcode.");
        else
            presenter.show("ERROR: Invalid Barcode.");
    }

    public interface Presenter {

        void show(String message);
    }
}
