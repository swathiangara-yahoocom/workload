package com.wawa.workloadmanagement.ordermanagement;

import com.wawa.workloadmanagement.model.OrderLineItem;
import com.wawa.workloadmanagement.model.ProductGroup;
import org.springframework.stereotype.Component;

@Component(name = "prepareOrder")
public class PrepareOrderWorker {


    public void processLineItem(OrderLineItem orderItem) {

        ProductGroup productGroup = orderItem.getProduct().getProductGroup();

        switch (productGroup.getProductType()) {
            case VEGPIZZA:
                // route to Group Veg
                break;
            case NVPIZZA:
                // route to GroupNonVeg
                break;
            case SANDWICH:
                // route to Sandwich
                break;
        }

    }

}
