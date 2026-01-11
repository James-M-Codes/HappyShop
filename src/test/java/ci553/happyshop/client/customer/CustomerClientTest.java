package ci553.happyshop.client.customer;

import ci553.happyshop.catalogue.Product;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;
import javafx.application.Platform;
import ci553.happyshop.storageAccess.DatabaseRW;
import ci553.happyshop.storageAccess.DatabaseRWFactory;
import org.junit.jupiter.api.Test;


class CustomerClientTest {

    private static CustomerView view;
    private static CustomerModel model;
    private static CustomerController controller;
    private static RemoveProductNotifier removePro;
    private static Product testProduct;

    @BeforeAll
    static void setup() {
        Platform.startup(() -> {
            view = new CustomerView();
            controller = new CustomerController();
            model = new CustomerModel();
            DatabaseRW databaseRW = DatabaseRWFactory.createDatabaseRW();


            view.cusController = controller;
            controller.cusModel = model;
            model.cusView = view;
            model.databaseRW = databaseRW;

            removePro = new RemoveProductNotifier();
            removePro.cusView = view;
            model.Rmvprod = removePro;
            //cusView.start(window);

        });

    }

    @AfterAll
    static void teardown() {
        Platform.exit();


    }







}