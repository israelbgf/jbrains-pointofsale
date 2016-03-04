package br.israelbgf.pointofsale;

public class DisplayProductFromBarcodeUsecase {
    private Presenter presenter;

    public DisplayProductFromBarcodeUsecase(Presenter presenter) {
        this.presenter = presenter;
    }

    public void process(String barcode) {
        presenter.show("ERROR: Empty Barcode.");
    }

    public interface Presenter {

        void show(String message);
    }
}
