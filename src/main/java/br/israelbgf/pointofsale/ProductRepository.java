package br.israelbgf.pointofsale;

public interface ProductRepository {
    void save(Product product);

    Product findBy(String barcode);
}
