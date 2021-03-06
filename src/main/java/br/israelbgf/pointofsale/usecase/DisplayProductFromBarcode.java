package br.israelbgf.pointofsale.usecase;

import br.israelbgf.pointofsale.entity.Product;
import br.israelbgf.pointofsale.gateway.ProductNotFoundException;
import br.israelbgf.pointofsale.gateway.ProductRepository;

public class DisplayProductFromBarcode {
    private Presenter presenter;
    private ProductRepository repository;

    public DisplayProductFromBarcode(Presenter presenter, ProductRepository repository) {
        this.presenter = presenter;
        this.repository = repository;
    }

    public void process(String barcode) {
        barcode = sanitized(barcode);
        if (barcode.isEmpty())
            presenter.show("ERROR: Empty Barcode.");
        else if (barcodeIsNotANumber(barcode)) {
            presenter.show("ERROR: Invalid Barcode.");
        } else {
            try {
                Product product = repository.findBy(barcode);
                presenter.show("$" + product.price);
            } catch (ProductNotFoundException e) {
                presenter.show("ERROR: Product does not exists.");
            }
        }
    }

    private String sanitized(String barcode) {
        return barcode.trim();
    }

    private boolean barcodeIsNotANumber(String barcode) {
        return !barcode.chars().allMatch(Character::isDigit);
    }

    public interface Presenter {
        void show(String message);
    }
}
