package br.israelbgf.pointofsale;

public class DisplayProductFromBarcodeUsecase {
    private Presenter presenter;
    private ProductRepository repository;

    public DisplayProductFromBarcodeUsecase(Presenter presenter, ProductRepository repository) {
        this.presenter = presenter;
        this.repository = repository;
    }

    public void process(String barcode) {
        if(barcode.isEmpty())
            presenter.show("ERROR: Empty Barcode.");
        else if(barcodeIsNotANumber(barcode)){
            presenter.show("ERROR: Invalid Barcode.");
        } else{
            try {
                Product product = repository.findBy(barcode);
                presenter.show("$" + product.price);
            } catch (ProductNotFoundException e) {
                presenter.show("ERROR: Product does not exists.");
            }
        }

    }

    private boolean barcodeIsNotANumber(String barcode) {
        return !barcode.chars().allMatch(Character::isDigit);
    }

    public interface Presenter {

        void show(String message);
    }
}
