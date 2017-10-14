package service;

import domain.Product;

/**
 * Created by lenovo on 2017/10/9.
 */
public interface ProductService {

    Product add(Product product);

    Product get(long id);

}
