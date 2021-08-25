package com.payments.restapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.payments.restapi.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
