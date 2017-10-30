package ru.sstu.ushankashop.dto;

import ru.sstu.ushankashop.domain.PaymentInfoEntity;
import ru.sstu.ushankashop.domain.ShippingInfoEntity;


public class User {
    private String email;
    private String password;
    private ShippingInfoEntity shippingInfoEntity;
    private PaymentInfoEntity paymentInfoEntity;
}
