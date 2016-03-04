package br.israelbgf.pointofsale.gateway;

import br.israelbgf.pointofsale.entity.Product;

public interface ProductRepository {
    void save(Product product);

    Product findBy(String barcode);
}
