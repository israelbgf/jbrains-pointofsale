package br.israelbgf.pointofsale;

public class DisplayProductFromBarcodeUsecase {
    private Presenter presenter;

    public DisplayProductFromBarcodeUsecase(Presenter presenter) {
        this.presenter = presenter;
    }

    public void process(String barcode) {
        if(barcode.isEmpty())
            presenter.show("ERROR: Empty Barcode.");
        else{
            if(barcodeIsANumber(barcode)){
                presenter.show("ERROR: Product does not exists.");
            }else{
                presenter.show("ERROR: Invalid Barcode.");
            }
        }
    }

    private boolean barcodeIsANumber(String barcode) {
        try {
            Long.parseLong(barcode);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public interface Presenter {

        void show(String message);
    }
}
