package br.israelbgf.pointofsale;

public class DisplayProductFromBarcodeUsecase {
    private Presenter presenter;

    public DisplayProductFromBarcodeUsecase(Presenter presenter) {
        this.presenter = presenter;
    }

    public void process(String barcode) {
        if(barcode.isEmpty())
            presenter.show("ERROR: Empty Barcode.");
        else if(barcodeIsNotANumber(barcode)){
            presenter.show("ERROR: Invalid Barcode.");
        }else{
            presenter.show("ERROR: Product does not exists.");
        }
    }

    private boolean barcodeIsNotANumber(String barcode) {
        return !barcode.chars().allMatch(Character::isDigit);
    }

    public interface Presenter {

        void show(String message);
    }
}
